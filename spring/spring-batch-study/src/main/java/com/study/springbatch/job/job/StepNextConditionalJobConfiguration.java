package com.study.springbatch.job.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class StepNextConditionalJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job stepNextConditionalJob() {
        return jobBuilderFactory
                .get("stepNextConditionalJob")
                .start(conditionalStep1())
                .on("FAILED")
                .to(conditionalStep3())
                .on("*")
                .end()
                .from(conditionalStep1())
                .on("*")
                .to(conditionalStep2())
                .next(conditionalStep3())
                .on("*")
                .end()
                .end()
                .build();

    }

    @Bean
    public Step conditionalStep1() {
        return stepBuilderFactory
                .get("step1")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>> This is stepNextConditionalJob Step1");

//                    contribution.setExitStatus(ExitStatus.FAILED);
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step conditionalStep2() {
        return stepBuilderFactory
                .get("conditionalStep2")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>> This is stepNextConditional Step2");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step conditionalStep3() {
        return stepBuilderFactory
                .get("conditionalStep3")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>> This is stepNextConditional Step3");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

}
