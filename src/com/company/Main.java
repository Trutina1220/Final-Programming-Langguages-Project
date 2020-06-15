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
        String str = "2020-05-16";
        Date sqlData = Date.valueOf(str);
        a1.setBalance(0);
        StockDatabase s2 ;
        String strs = "2020-06-14";
        Date sqlDatas = Date.valueOf(strs);

//        System.out.println(sqlData.before(sqlDate));
//
//        System.out.println(a1.previousWeek());
//        a1.insert(sqlData,30,"bulan lalu",'d');
//        a1.insert(sqlData,5,"bulan lalu 2.0",'c');
//        a1.printDatabase();
//        System.out.println(a1.getStartingDate());
//        System.out.println(a1.getReport(a1.previousWeek()));
//        System.out.println(a1.getReport(a1.previousMonth()));













    }
}


