package db;

import java.sql.Connection;
import java.sql.DriverManager;


public class DB {
    
    private static Connection conn = null;
    
    public static Connection getConnection() {
        
            try {
                Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalhojavaweb", "root", "");
                
            } catch (Exception e) {
                throw new DbException("Error Connection: " + e.getMessage());
            }
        }
    }

