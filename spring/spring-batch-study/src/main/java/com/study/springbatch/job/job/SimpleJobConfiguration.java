package com.study.springbatch.job.job;

import com.study.springbatch.tasklet.SimpleJobTasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class SimpleJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final SimpleJobTasklet simpleJobTasklet;

    @Bean
    public Job simpleJob() {
        return jobBuilderFactory
                .get("simpleJob")
                .start(simpleStep1())
                .next(simpleStep2(null))
                .build();
    }

    //    @Bean
//    @JobScope
    public Step simpleStep1() {
        return stepBuilderFactory
                .get("simpleStep1")
                .tasklet(simpleJobTasklet)
                .build();
    }

    @Bean
    @JobScope
    public Step simpleStep2(@Value("#{jobParameters[requestDate]}") String requestDate) {
        return stepBuilderFactory
                .get("simpleStep2")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>> This is Step2");
                    log.info(">>>>> requestDate={}", requestDate);
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

}
