package com.tripPropper.database.entities;

import java.time.LocalDate;

/**
 * Created by admin on 7/30/2016.
 */


public class StockHistory {

    private Integer id;

    private String stockCode;

    private LocalDate date;

    private Double closingPrice;

    private Double openPrice;
}
