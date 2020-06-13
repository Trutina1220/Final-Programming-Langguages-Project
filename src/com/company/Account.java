package com.company;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class Account implements Atm {
    private int balance;
    private ArrayList<Integer> debitList =  new ArrayList<Integer>();
    private ArrayList<Integer> creditList = new ArrayList<Integer>();
    private ArrayList<String> debitInfo = new ArrayList<String>();
    private ArrayList<String> creditInfo = new ArrayList<String>();
    private Calendar calendar = Calendar.getInstance();

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

    public ArrayList<String> getDebitInfo() {
        return debitInfo;
    }

    public void setDebitInfo(String info) {
        this.debitInfo.add(info);
    }

    public ArrayList<String> getCreditInfo() {
        return creditInfo;
    }

    public void setCreditInfo(String info) {
        this.creditInfo.add(info);
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


    @Override
    public void sendMoney(Account a, int amount) {
        this.balance -= amount;
        a.balance += amount;
    }

    @Override
    public void debit(int amount, String info) {
        setDebitInfo(info);
        setDebitList(amount);
    }

    @Override
    public void credit(int amount, String info) {
        setCreditList(amount);
        setDebitInfo(info);
    }
}
