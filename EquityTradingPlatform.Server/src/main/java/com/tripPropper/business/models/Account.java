package com.tripPropper.business.models;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 7/31/2016.
 */
public class Account {

    private double balance;

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void setBalance(double balance) {
        this.balance = balance;
    }
}
