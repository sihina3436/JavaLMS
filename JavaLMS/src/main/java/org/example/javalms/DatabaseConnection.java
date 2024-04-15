package org.example.javalms;

import java.sql.*;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection connection;

    public Connection getConnection(){
        String User = "root";
        String Password = "";
        String Url = "jdbc:mysql://localhost:3306/java_lms";

        try {
            connection = DriverManager.getConnection(Url,User,Password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
