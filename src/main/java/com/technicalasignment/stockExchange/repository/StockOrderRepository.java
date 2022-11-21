package com.technicalasignment.stockExchange.repository;

import com.technicalasignment.stockExchange.model.StockOrder;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StockOrderRepository extends ReactiveCrudRepository<StockOrder, Integer> {
    @Query("select * from stock_orders where type = 'BUY' order by price desc limit 10")
    Flux<StockOrder> findTopBuy();

    @Query("select * from stock_orders where type = 'SELL' order by price asc limit 10")
    Flux<StockOrder> findTopSell();
}
