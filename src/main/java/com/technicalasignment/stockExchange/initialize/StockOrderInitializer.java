package com.technicalasignment.stockExchange.initialize;

import com.technicalasignment.stockExchange.model.StockOrder;
import com.technicalasignment.stockExchange.repository.StockOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import java.util.Arrays;
import java.util.List;

@Component
@Profile("!test")
@Slf4j
public class StockOrderInitializer implements CommandLineRunner {

    @Autowired
    private StockOrderRepository stockOrderRepository;

    @Override
    public void run(String... args) {
        initialDataSetup();
    }

    private List<StockOrder> getData() {
        return Arrays.asList(
                new StockOrder(null, 100, 30, "BUY"),
                new StockOrder(null, 90, 500, "BUY"),
                new StockOrder(null, 80, 440, "BUY"),
                new StockOrder(null, 70, 500, "BUY"),
                new StockOrder(null, 60, 500, "BUY"),
                new StockOrder(null, 50, 500, "BUY"),
                new StockOrder(null, 40, 500, "BUY"),
                new StockOrder(null, 30, 500, "BUY"),
                new StockOrder(null, 20, 440, "BUY"),
                new StockOrder(null, 10, 500, "BUY"),
                new StockOrder(null, 110, 500, "BUY"),
                new StockOrder(null, 120, 500, "BUY"),
                new StockOrder(null, 130, 500, "BUY"),
                new StockOrder(null, 140, 500, "BUY"),
                new StockOrder(null, 100, 30, "SELL"),
                new StockOrder(null, 90, 500, "SELL"),
                new StockOrder(null, 80, 440, "SELL"),
                new StockOrder(null, 70, 500, "SELL"),
                new StockOrder(null, 60, 500, "SELL"),
                new StockOrder(null, 50, 500, "SELL"),
                new StockOrder(null, 40, 500, "SELL"),
                new StockOrder(null, 30, 500, "SELL"),
                new StockOrder(null, 20, 440, "SELL"),
                new StockOrder(null, 10, 500, "SELL"),
                new StockOrder(null, 110, 500, "SELL"),
                new StockOrder(null, 120, 500, "SELL"),
                new StockOrder(null, 130, 500, "SELL"),
                new StockOrder(null, 140, 500, "SELL")
        );
    }

    private void initialDataSetup() {
        stockOrderRepository.deleteAll()
                .thenMany(Flux.fromIterable(getData()))
                .flatMap(stockOrderRepository::save)
                .thenMany(stockOrderRepository.findAll())
                .subscribe(stockOrder -> log.info("Stock order inserted from CommandLineRunner " + stockOrder));
    }
}
