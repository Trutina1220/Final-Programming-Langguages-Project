package com.company;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class Account implements Atm {
    private int balance;
    private ArrayList<Integer> debitList =  new ArrayList<Integer>();
    private ArrayList<Integer> creditList = new ArrayList<Integer>();
    private ArrayList<Integer> monthlyReport = new ArrayList<Integer>();
    private Calendar calendar = Calendar.getInstance();
    private Database database = Database.getInstance();

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<Integer> getDebitList() {
        return debitList;
    }

    public void setDebitList(int amount) {
        this.debitList.add(amount);
    }

    public ArrayList<Integer> getCreditList() {
        return creditList;
    }

    public void setCreditList(int amount) {
        this.creditList.add(amount);
    }


    public String getDay(){
        String dayNames[] = new DateFormatSymbols().getWeekdays();
        return (dayNames[this.calendar.get(Calendar.DAY_OF_WEEK)]);
    }

    public int getDate(){
        return calendar.get(Calendar.DATE);
    }

    public LocalDate getDateMonthYear(){
        return LocalDate.now();
    }

    public void deleteDatabase(){
        database.deleteData();
    }
    public void printDatabase(){
        database.printAll();
    }

    @Override
    public void sendMoney(Account a, int amount) {
        this.balance -= amount;
        a.balance += amount;
    }



    @Override
    public int getWeeklyAmount() {
        int debitAmount = 0;
        int creditAmount = 0;
        for(int i = 0 ; i < this.debitList.size();i++){
            debitAmount += this.debitList.get(i);
        }

        for (int i = 0 ; i < this.creditList.size();i++){
            creditAmount += this.creditList.get(i);
        }
        this.balance += debitAmount - creditAmount;
        this.monthlyReport.add(debitAmount-creditAmount);
        return debitAmount - creditAmount;

    }

    @Override
    public int getMonthlyAmount() {
        int monthlyAmount = 0 ;
        for(int i =0 ; i < this.monthlyReport.size();i++){
            monthlyAmount += this.monthlyReport.get(i);
        }
        return monthlyAmount;
    }

    @Override
    public int sendStockMoney(StockAccount s) {

        int weeklySaving =  getWeeklyAmount()*20/100 ;
        sendMoney(s,weeklySaving);
        this.balance -= weeklySaving;
        return weeklySaving;

    }

    @Override
    public void inputDatabase(char transaction , String info , int amount) {
        Date sqlDate = Date.valueOf(getDateMonthYear());
        database.insert(sqlDate,amount,info,transaction);
        if (transaction == 'd'){
            setDebitList(amount);
        }
        else{
            setCreditList(amount);
        }
    }
}
