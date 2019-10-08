package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static Connection connection;

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/barberia?useSSL=false";
    private static String user = "root";
    private static String password = "";
    
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = getConexion();
            System.out.println("CONEXION");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        public static Connection getConexion() {
        if (connection == null) {

            try {
                Class.forName(driver);
                connection = (Connection) DriverManager.getConnection(url, user, password);
                System.out.println("CONEXION");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("no se conecto");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                System.out.println("no se conecto");
                e.printStackTrace();
            }
        }
        return connection;
    }

}

