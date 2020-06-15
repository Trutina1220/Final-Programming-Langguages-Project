package com.company;

import java.sql.Date;

public interface Atm {
    void sendMoney(Account a ,int amount);
    int getReport(Date previousCheck);
    int sendStockMoney( StockAccount s );

}
