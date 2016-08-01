package com.tripPropper.database.entities;

import com.tripPropper.business.models.Trade;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by xy30164 on 7/29/2016.
 */

@Entity @Table(name = "executions")
public class Execution {


    private int id;

    private Timestamp when;

    private String stock;

    private boolean buy;

    private int size;

    private double price;

    private String result;




}
