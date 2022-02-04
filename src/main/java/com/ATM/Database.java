package com.ATM;

import java.sql.*;

public class Database {
    protected static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost/atmbot";

    public static final String USER = "root";
    public static final String PASSWORD = "pnne1200";
    Connection con;
    Statement statement;
    public Database(){
        try {
            con = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = con.createStatement();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createUser(String chat_id, int balance){
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO accounts(chat_id, balance) VALUES(?,2000)");
            ps.setString(1, chat_id);
            ps.setInt(2, balance);
            ps.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    public void updateUser(String chat_id, int balance){
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE accounts set chat_id = " + '?' + ", balance = " + '?' + "WHERE balance = " + '?');
            ps.setString(1, chat_id);
            ps.setInt(2, balance);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



