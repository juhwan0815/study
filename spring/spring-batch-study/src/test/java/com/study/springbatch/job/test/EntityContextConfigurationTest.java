package com.study.springbatch.job.test;

import com.study.springbatch.TestBatchConfig;
import com.study.springbatch.domain.Order;
import com.study.springbatch.domain.Product;
import com.study.springbatch.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {EntityContextConfiguration.class, TestBatchConfig.class})
@SpringBatchTest
class EntityContextConfigurationTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @DisplayName("reader 에서 processor 로 entity를 넘기면 영속성이 유지되어야 한다.")
    void test() throws Exception {
        // given
        for (int i = 0; i < 100; i++) {
            List<Product> products = Arrays.asList(new Product("마우스", 10000L), new Product("키보드", 30000L));
            Order order = new Order("도착할때 전화주세요.", products);
            orderRepository.save(order);
        }

        // when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();

        // then
        assertThat(jobExecution.getStatus()).isEqualTo(BatchStatus.COMPLETED);
        assertThat(orderRepository.findAll().size()).isEqualTo(100);
    }

}