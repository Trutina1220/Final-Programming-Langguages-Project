package com.company;

import java.util.Calendar;

public class StockAccount extends Account {
    public void buyStock(int amount){

        int actualBalance = this.getBalance()-amount;
        this.setBalance(actualBalance);

    }

}
