package com.company;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Account a1 = new Account();
        StockAccount s1 = new StockAccount();
        System.out.println(a1.getDateMonthYear());
        Date sqlDate = Date.valueOf(a1.getDateMonthYear());
        a1.setBalance(0);







    }
}


