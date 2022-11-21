package com.technicalasignment.stockExchange.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("stock_orders")
public class StockOrder {

    @Id
    private Integer id;
    private double price;
    private int amount;
    private String type;
}
