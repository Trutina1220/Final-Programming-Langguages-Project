package com.company;

import java.sql.Date;
import java.util.Calendar;

public class StockAccount extends Account {
    private StockDatabase sDB = StockDatabase.getInstance();
    public void buyStock(int amount){

        int actualBalance = this.getBalance()-amount;
        this.setBalance(actualBalance);

    }

    @Override
    public void deleteDatabase() {
        sDB.deleteData();
    }

    @Override
    public void printDatabase() {
        sDB.printAll();
    }

    public void insertDatabase(int amount , char type){
        Date sqlDate = Date.valueOf(getDateMonthYear());
        sDB.insert(sqlDate,amount,type);
    }
}

