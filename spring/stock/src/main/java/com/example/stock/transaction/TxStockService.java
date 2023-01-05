package com.example.stock.transaction;

import com.example.stock.service.StockService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TxStockService {

    private final StockService stockService;

    public void decrease(Long id, Long quantity) {
        startTx();

        stockService.decrease(id, quantity); // 10:00

        // 10:00 ~ 10:05 까지 decrease 메소드 호출 가능
        endTx(); // 10:05
    }

    public void startTx() {

    }

    public void endTx() {

    }

}
