package com.technicalasignment.stockExchange.service;

import com.technicalasignment.stockExchange.model.StockOrder;
import com.technicalasignment.stockExchange.repository.StockOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@Transactional
public class StockOrderService {

    @Autowired
    private final StockOrderRepository stockOrderRepository;

    public StockOrderService(StockOrderRepository stockOrderRepository) {
        this.stockOrderRepository = stockOrderRepository;
    }

    public Mono<StockOrder> createStockOrder(StockOrder stockOrder) {
        return stockOrderRepository.save(stockOrder);
    }

    public Flux<StockOrder> getAllStockOrders() {
        return stockOrderRepository.findAll();
    }

    public Flux<StockOrder> getTopBuy() {
        return stockOrderRepository.findTopBuy();
    }

    public Flux<StockOrder> getTopSell() {
        return stockOrderRepository.findTopSell();
    }
}
