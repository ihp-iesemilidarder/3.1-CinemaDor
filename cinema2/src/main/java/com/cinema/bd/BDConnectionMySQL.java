package com.cinema.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnectionMySQL {
	
	private final String URL = "jdbc:mysql://localhost:3306/"; // BD location
    private final String BD = "cinema2_stg1"; // BD Name .
    private final String USER = "IAW";
    private final String PASSWORD = "1234";
    
    public Connection con = null;
	
    @SuppressWarnings("finally")
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema2_stg1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", USER, PASSWORD);
            if (con != null) {
                System.out.println("Connexió OK!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return con;
        }
    }

}
