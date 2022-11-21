package com.study.springbatch.job.test;

import com.study.springbatch.TestBatchLegacyConfig;
import com.study.springbatch.domain.Sales;
import com.study.springbatch.domain.SalesSum;
import com.study.springbatch.repository.SalesRepository;
import com.study.springbatch.repository.SalesSumRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static com.study.springbatch.util.DateUtil.DATE_FORMATTER;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {BatchJpaTestConfiguration.class, TestBatchLegacyConfig.class})
class BatchIntegrationTestJobConfigurationLegacyTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private SalesSumRepository salesSumRepository;

    @Autowired
    private SalesRepository salesRepository;

    @AfterEach
    void tearDown() {
        salesRepository.deleteAll();
        salesSumRepository.deleteAll();
    }

    @Test
    @DisplayName("기간 내 Sales 가 집계되어 SalesSum 이 된다.")
    void test() throws Exception {
        // given
        LocalDate orderDate = LocalDate.of(2019, 10, 6);
        int amount1 = 1000;
        int amount2 = 500;
        int amount3 = 100;
        salesRepository.save(new Sales(orderDate, amount1, "1"));
        salesRepository.save(new Sales(orderDate, amount2, "2"));
        salesRepository.save(new Sales(orderDate, amount3, "3"));

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("orderDate", orderDate.format(DATE_FORMATTER))
                .toJobParameters();

        // when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

        // then
        assertThat(jobExecution.getStatus()).isEqualTo(BatchStatus.COMPLETED);
        List<SalesSum> salesSums = salesSumRepository.findAll();
        assertThat(salesSums.size()).isEqualTo(1);
        assertThat(salesSums.get(0).getOrderDate()).isEqualTo(orderDate);
        assertThat(salesSums.get(0).getAmountSum()).isEqualTo(amount1 + amount2 + amount3);
    }

}