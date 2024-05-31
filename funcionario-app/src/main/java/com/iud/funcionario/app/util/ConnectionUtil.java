
package com.iud.funcionario.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
    
    
    private static final String URL = "jdbc:mysql://localhost/funcionario-bd";
    private static final String USER = "root";
    private static final String PASSWORD = "Mateito2002";
    
    
    public static Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection(URL,USER,PASSWORD);
        
    }
    
}
