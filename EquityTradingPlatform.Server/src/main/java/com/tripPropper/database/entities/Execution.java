package com.tripPropper.database.entities;

import com.tripPropper.business.models.Trade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by xy30164 on 7/29/2016.
 */

@Entity @Table(name = "executions")
public class Execution implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "when_as_date" )
    private Date whenAsDate;

    @Column(name = "stock_code")
    private String stockCode;

    @Column(name = "buy")
    private boolean buy;

    @Column(name = "size")
    private int size;

    @Column(name = "price")
    private double price;

    @Column(name ="result")
    private String result;





}
