package com.study.springbatch.job.test;

import com.study.springbatch.domain.SalesSum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.study.springbatch.util.DateUtil.DATE_FORMATTER;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BatchJpaTestConfiguration {

    public static final String JOB_NAME = "batchJpaUnitTestJob";
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
                .<SalesSum, SalesSum>chunk(chunkSize)
                .reader(reader(null))
                .writer(writer())
                .build();
    }

    @Bean(BEAN_PREFIX + "reader")
    @StepScope
    public JpaPagingItemReader<SalesSum> reader(@Value("#{jobParameters[orderDate]}") String orderDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("orderDate", LocalDate.parse(orderDate, DATE_FORMATTER));

        String className = SalesSum.class.getName();
        String queryString = String.format (
                "SELECT new %s(s.orderDate, SUM(s.amount)) " +
                        "FROM Sales s " +
                        "WHERE s.orderDate =:orderDate " +
                        "GROUP BY s.orderDate ", className);

        return new JpaPagingItemReaderBuilder<SalesSum>()
                .name(BEAN_PREFIX + "reader")
                .entityManagerFactory(entityManagerFactory)
                .pageSize(chunkSize)
                .queryString(queryString)
                .parameterValues(params)
                .build();
    }

    @Bean(BEAN_PREFIX + "writer")
    public JpaItemWriter<SalesSum> writer() {
        JpaItemWriter<SalesSum> jpaItemWriter = new JpaItemWriter<>();
        jpaItemWriter.setEntityManagerFactory(entityManagerFactory);
        return jpaItemWriter;
    }
}
