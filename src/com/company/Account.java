package com.company;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Account implements Atm {
    private int balance;
    private Calendar calendar = Calendar.getInstance();
    private Database database = Database.getInstance();
    private LocalDate startingDate = getStartingDate();
    private Date previousCheckWeek = getPreviousWeek();
    private Date previousCheckMonth = getPreviousMonth();


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public LocalDate getStartingDate(){
        return database.getStartingDate().toLocalDate();
    }

    public Date getPreviousWeek() {
        Date prevWeek = Date.valueOf(startingDate.minusWeeks(1));
        return prevWeek;
    }

    public Date getPreviousMonth(){
        Date prevMonth = Date.valueOf(startingDate.minusMonths(1));
        return prevMonth;
    }


    public String getDay() {
        String dayNames[] = new DateFormatSymbols().getWeekdays();
        return (dayNames[this.calendar.get(Calendar.DAY_OF_WEEK)]);
    }

    public int getDate() {
        return calendar.get(Calendar.DATE);
    }

    public LocalDate getDateMonthYear() {
        return LocalDate.now();
    }

    public void deleteDatabase() {
        database.deleteData();
    }

    public void printDatabase() {
        database.printAll();
    }


    @Override
    public void sendMoney(Account a, int amount) {
        this.balance -= amount;
        a.balance += amount;
    }


    @Override
    public int getReport(Date previousCheck) {
        Date sqlDate = Date.valueOf(getDateMonthYear());
        int amount = database.getSaved(sqlDate, previousCheck);
        return amount;
    }

    @Override
    public int getSpending(Date previousCheck) {
        Date sqlDate = Date.valueOf(getDateMonthYear());
        int amount = database.getSaved(sqlDate, previousCheck);
        return amount;
    }


    @Override
    public int sendStockMoney(StockAccount s) {

        int weeklySaving = getReport(previousCheckWeek) * 20 / 100;
        sendMoney(s, weeklySaving);
        this.balance -= weeklySaving;
        return weeklySaving;

    }

    public void insert(Date date,int amount , String information, char type){
        database.insert(date,amount,information,type);
    }
}




