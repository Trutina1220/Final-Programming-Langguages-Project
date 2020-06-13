package com.company;

public interface Atm {
    void sendMoney(Account a ,int amount);
    void debit(int amount,String info);
    void credit(int amount,String info);
}
