package com.tripPropper.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by admin on 7/30/2016.
 */

@Entity
@Table(name = "stock_history")
public class StockHistory {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "stock_code")
    private String stockCode;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "closingPrice")
    private Double closingPrice;

    @Column(name = "openPrice")
    private Double openPrice;
}
