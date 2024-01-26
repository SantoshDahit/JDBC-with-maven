package org.example.database;

import java.sql.*;

public class Database {
public void getConnection() {
    try {
        String url = "jdbc:mysql://localhost:3306/";
        String userName = "root";
        String password = "1234";

        Connection conn = DriverManager.getConnection(url, userName, password);
        Statement stm = conn.createStatement();
        String dbQuery = "create database DAHIT";
        stm.execute(dbQuery);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void createTable() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "dahit";
            String userName = "root";
            String password = "1234";

            Connection conn = DriverManager.getConnection(url + db, userName, password);
            Statement stm = conn.createStatement();
            String tableQuery = "create table users (id int(3), name varchar(200), lastName varchar(200), age int(10))";
            stm.execute(tableQuery);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "dahit";
            String userName = "root";
            String password = "1234";

            Connection conn = DriverManager.getConnection(url + db, userName, password);
            String tableQuery = "INSERT into users (id, name, lastName, age) VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(tableQuery);
            pstm.setInt(1,20);
            pstm.setString(2,"rahul");
            pstm.setString(3, "chaudhary");
            pstm.setInt(4, 29);
            pstm.executeUpdate();
            System.out.println("Data inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void readData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "dahit";
            String userName = "root";
            String password = "1234";

            Connection conn = DriverManager.getConnection(url + db, userName, password);
            String readQuery = "select * from users";
            Statement stm = conn.createStatement();
           ResultSet rs = stm.executeQuery(readQuery);
            while(rs.next()) {
                System.out.println("id = " + rs.getInt(1));
                System.out.println("name = " + rs.getString(2));
                System.out.println("lastName = " + rs.getString(3));
                System.out.println("age = " + rs.getInt(4));
            }
            System.out.println("Read successfully ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "dahit";
            String userName = "root";
            String password = "1234";

            Connection conn = DriverManager.getConnection(url + db, userName, password);
            String updateQuery = "UPDATE users set id = ? where name = ?";
            PreparedStatement pstm = conn.prepareStatement(updateQuery);
            pstm.setInt(1,30);
            pstm.setString(2,"rahul");
            pstm.execute();
            System.out.println("Updated successfully ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void Delete() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "dahit";
            String userName = "root";
            String password = "1234";

            Connection conn = DriverManager.getConnection(url + db, userName, password);
            String updateQuery = "delete from users where id = ?";
            PreparedStatement pstm = conn.prepareStatement(updateQuery);
            pstm.setInt(1,30);

            pstm.execute();
            System.out.println("Deleted successfully ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
