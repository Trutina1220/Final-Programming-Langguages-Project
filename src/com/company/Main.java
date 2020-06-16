package com.company;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Account a1 = Account.getInstance();
        StockAccount s1 = StockAccount.getInstance();
        System.out.println(a1.getDateMonthYear());
        Date sqlDate = Date.valueOf(a1.getDateMonthYear());
        String str = "2020-05-18";
        Date sqlData = Date.valueOf(str);
        a1.setBalance(0);
        StockDatabase s2 ;
        String strs = "2020-06-14";
        Date sqlDatas = Date.valueOf(strs);

        a1.printDatabase();
        System.out.println(a1.getBalance());












    }
}


