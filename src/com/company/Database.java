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
    private String sql = "select * from saving.transaction";
    private String query = "insert into saving.transaction (date, debet, credit,desc)"
            + " values (?, ?, ?,?)";

    public Database() {
        printAll();
    }

   public void printAll(){
       try{
           Connection con = DriverManager.getConnection(host,uName,uPass);
           Statement stat = con.createStatement();

           ResultSet rs = stat.executeQuery(sql);

           while(rs.next()){
               int id = rs.getInt("idtransaction");
               Date date = rs.getDate("date");
               int debet = rs.getInt("debet");
               int credit = rs.getInt("credit");
               String desc = rs.getString("desc");
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
           preparedStatement.setString (4, "Rubble");
           preparedStatement.execute();
           con.close();



       } catch (SQLException err) {
           System.out.println(err.getMessage());
       }
   }

   public void test(){

           try{
               Connection con = DriverManager.getConnection(host,uName,uPass);
               Statement st = con.createStatement();
               st.executeUpdate("INSERT INTO saving.transaction(debet,credit)"+ "VALUES(100,300)");
               con.close();



           }catch (SQLException err){
               System.out.println(err.getMessage());
           }
       }

   }





