package com.study.stock.service;

import com.study.stock.domain.Stock;
import com.study.stock.facade.LettuceLockStockFacade;
import com.study.stock.facade.NamedLockStockFacade;
import com.study.stock.facade.OptimisticLockStockFacade;
import com.study.stock.facade.RedissonLockStockFacade;
import com.study.stock.repository.StockRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class StockServiceTest {

    @Autowired
    private RedissonLockStockFacade stockService;
//    private LettuceLockStockFacade stockService;
//    private NamedLockStockFacade stockService;
//    private OptimisticLockStockFacade stockService;
//    private StockService stockService;
//    private PessimisticLockStockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    void init() {
        Stock stock = new Stock(1L, 100L);
        stockRepository.save(stock);
    }

    @AfterEach
    public void tearDown() {
        stockRepository.deleteAll();
    }

    @Test
    void stock_decrease() throws InterruptedException {
        stockService.decrease(1L, 1L);

        // 100 - 1 = 99
        Stock stock = stockRepository.findById(1L).orElseThrow();
        assertThat(stock.getQuantity()).isEqualTo(99);
    }

    @Test
    void 동시에_100개의_요청() throws InterruptedException {
        int threadCount = 100;

        ExecutorService executorService = Executors.newFixedThreadPool(16);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    stockService.decrease(1L, 1L);
                } finally {
                    latch.countDown();
                }

            });
        }

        latch.await();

        Stock stock = stockRepository.findById(1L).orElseThrow();
        // 100 - (1*100) = 0
        assertThat(stock.getQuantity()).isEqualTo(0);
    }


}