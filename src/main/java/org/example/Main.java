package org.example;

import org.example.database.Database;



public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        //db.getConnection();
        //db.createTable();
        //doing CURD
        //db.insertData();
        db.readData();
        //db.updateData();
        //db.Delete();
    }
}