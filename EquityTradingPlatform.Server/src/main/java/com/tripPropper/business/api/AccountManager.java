package com.tripPropper.business.api;

import com.tripPropper.business.models.Account;
import org.springframework.stereotype.Component;

/**
 * Created by xy30164 on 8/1/2016.
 */

@Component
public class AccountManager {

    private Account account = new Account();


    public void updateBalance(double price, int size, boolean buy) {
        if (buy)
            account.setBalance(account.getBalance() - price * size);
        else
            account.setBalance(account.getBalance() + price * size);
    }

    public double getBalance() {
        return account.getBalance();
    }


}
