package com.company;
import com.sun.jdi.Value;

import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class Database {
    private String host = "jdbc:mysql://localhost:3306/saving";
    private String uName = "root";
    private String uPass = "admin";
    private String sql = "select * from saving.report";
    private String query = "insert into saving.report (date, debit, credit, information)"
            + " values (?, ?, ?, ?)";
    private String delete = "delete from saving.report";

    public Database() {

    }

   public void printAll(){
       try{
           Connection con = DriverManager.getConnection(host,uName,uPass);
           Statement stat = con.createStatement();

           ResultSet rs = stat.executeQuery(sql);

           while(rs.next()){
               int id = rs.getInt("id");
               Date date = rs.getDate("date");
               int debet = rs.getInt("debit");
               int credit = rs.getInt("credit");
               String desc = rs.getString("information");
               String t = id+" "+date+ " "+debet+ "  "+credit+"  "+desc;
               System.out.println(t);

           }

       }catch (SQLException err){
           System.out.println(err.getMessage());
       }

   }



   public void insert(Date date, int amount, String string, char type) {
       try {
           Connection con = DriverManager.getConnection(host, uName, uPass);
           PreparedStatement preparedStatement = con.prepareStatement(query);
           preparedStatement.setDate(1,date);
           if(type=='d'){
               preparedStatement.setInt(2,amount);
               preparedStatement.setInt(3,0);
           }
           else{
               preparedStatement.setInt(3,amount);
               preparedStatement.setInt(2,0);
           }
           preparedStatement.setString(4,string);
           preparedStatement.execute();
           con.close();



       } catch (SQLException err) {
           System.out.println(err.getMessage());
       }
   }

   public void deleteData(){
        try {
            Connection con = DriverManager.getConnection(host,uName,uPass);
            PreparedStatement preparedStatement =  con.prepareStatement(delete);
            preparedStatement.execute();
            con.close();
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }

   }

   }





