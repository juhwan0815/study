package com.study.springbatch.job.processor;

import com.study.springbatch.domain.Sale;
import com.study.springbatch.domain.Tax;
import com.study.springbatch.processor.ItemListProcessor;
import com.study.springbatch.writer.JpaItemListWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ItemListJobConfiguration {

    public static final String JOB_NAME = "itemListJob";
    public static final String BEAN_PREFIX = JOB_NAME + "_";

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final EntityManagerFactory entityManagerFactory;

    @Value("${chunkSize:1000}")
    private int chunkSize;

    @Bean(JOB_NAME)
    public Job job() {
        return jobBuilderFactory
                .get(JOB_NAME)
                .start(step())
                .build();
    }

    @Bean(BEAN_PREFIX + "step")
    public Step step() {
        return stepBuilderFactory
                .get(BEAN_PREFIX + "step")
                .<Sale, List<Tax>>chunk(chunkSize)
                .reader(reader())
                .processor(processor())
                .writer(writerList())
                .build();
    }

    @Bean(BEAN_PREFIX + "reader")
    public JpaPagingItemReader<Sale> reader() {
        return new JpaPagingItemReaderBuilder<Sale>()
                .name(BEAN_PREFIX + "reader")
                .entityManagerFactory(entityManagerFactory)
                .pageSize(chunkSize)
                .queryString("select s from Sale s")
                .build();
    }

    @Bean(BEAN_PREFIX + "processor")
    public ItemProcessor<Sale, List<Tax>> processor() {
        return new ItemListProcessor();
    }

    @Bean(BEAN_PREFIX + "writer")
    public JpaItemListWriter<Tax> writerList() {
        JpaItemWriter<Tax> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        JpaItemListWriter<Tax> JpaItemListWriter = new JpaItemListWriter<>(writer);
        JpaItemListWriter.setEntityManagerFactory(entityManagerFactory);
        return JpaItemListWriter;
    }

//    @Bean(BEAN_PREFIX + "writer")
    public JpaItemListWriter<List<Tax>> writer() {
        JpaItemWriter<List<Tax>> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return new JpaItemListWriter<>(writer);
    }

}
