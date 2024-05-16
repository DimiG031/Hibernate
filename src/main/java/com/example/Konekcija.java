package com.example;

import java.sql.DriverManager;

import java.sql.*;
public class Konekcija {
    public static Connection connection;
    public static Connection uspostaviKonekciju() {
        try {
            if(connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/baza_zaposlenih", "root", "");
            }
            if (!connection.isClosed()) {
                System.out.println("Konekcija je uspostavljena");
                return connection;
            } else {
                System.out.println("Konekcija nije uspostavljena");
                return null;
            }
        }catch (Exception ex) {
            System.out.println("Greska u datebase konekciji: \n" + ex.getMessage());
            return null;
        }
    }
}