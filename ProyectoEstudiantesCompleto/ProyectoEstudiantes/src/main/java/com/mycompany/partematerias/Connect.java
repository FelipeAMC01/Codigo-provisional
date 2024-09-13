/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.partematerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FelixDDP
 */
public class Connect {
    public static Connection getConnection() {
        Connection connection = null;

        String database = "RegistroEstudiantes";  
        String url = "jdbc:mysql://localhost:3306/" + database;
        String username = "root";
        String password = "";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error en la conexión a la BD: " + e.getMessage());
            e.printStackTrace(); 
        } 
        return connection;
    }
}
