package com.company;

public interface Atm {
    void sendMoney(Account a ,int amount);
    int getWeeklyAmount();
    int getMonthlyAmount();
    int sendStockMoney( StockAccount s );
    void inputDatabase(char transaction, String info, int amount);
}
