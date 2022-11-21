package com.technicalasignment.stockExchange.controller;

import com.technicalasignment.stockExchange.model.StockOrder;
import com.technicalasignment.stockExchange.service.StockOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/stockOrders")
public class StockOrderController {
    @Autowired
    private StockOrderService stockOrderService;

    /**
     * <p>This is a create endpoint. It is used to create a new stock order and store it in the database.</p>
     * @param stockOrder Stock order to be created.
     * @return Created stock order.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<StockOrder> create(@RequestBody StockOrder stockOrder) {
        return stockOrderService.createStockOrder(stockOrder);
    }
    /**
     * <p>This is a getAllStockOrders endpoint. It is used to return all stock orders form the database.</p>
     * @return All stock orders.
     */
    @GetMapping
    public Flux<StockOrder> getAllStockOrders() {
        return stockOrderService.getAllStockOrders();
    }
    /**
     * <p>This is a getTopBuy endpoint. It is used to return top 10 BUY stock orders form the database.</p>
     * @return Top 10 BUY stock orders.
     */
    @GetMapping("/topBuy")
    public Flux<StockOrder> getTopBuy() {
        return stockOrderService.getTopBuy();
    }
    /**
     * <p>This is a getTopSell endpoint. It is used to return top 10 SELL stock orders form the database.</p>
     * @return Top 10 SELL stock orders.
     */
    @GetMapping("/topSell")
    public Flux<StockOrder> getTopSell() {
        return stockOrderService.getTopSell();
    }
}
