package com.study.springbatch.job.step;

import com.study.springbatch.TestBatchConfig;
import com.study.springbatch.domain.Sale;
import com.study.springbatch.job.processor.ItemListJobConfiguration;
import com.study.springbatch.repository.SaleRepository;
import com.study.springbatch.repository.TaxRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBatchTest
@SpringBootTest(classes = {ItemListJobConfiguration.class, TestBatchConfig.class})
class ItemListWriterTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private TaxRepository taxRepository;

    @Test
    @DisplayName("processor 에서 writer 로 List 로 넘긴다.")
    void test() throws Exception {
        // given
        saleRepository.save(new Sale(10000L, 1L));
        saleRepository.save(new Sale(20000L, 2L));
        saleRepository.save(new Sale(30000L, 3L));

        // when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();

        // then
        assertThat(jobExecution.getStatus()).isEqualTo(BatchStatus.COMPLETED);
        assertThat(taxRepository.findAll().size()).isEqualTo(9);
    }

}