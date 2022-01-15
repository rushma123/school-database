/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.main;
import java.sql.*;

/**
 *
 * @author yough
 */
public class DBConnection {
    
    static Connection connection;

   /* final static String subProtocal = "mysql";
    final static String host = "//sql6.freesqldatabase.com";//"localhost";
    final static String port = "3306";
    final static String database = "sql6437997";//"school";
    final static String userName =  "sql6437997";//"rush";
    final static String password = "WZN3xrTJ93";//"rush123";

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:" + subProtocal + ":"
                    + host + ":" + port + "/" + database, userName, password);
        }

        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }

    }*/
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6437997","sql6437997","WXN3xrTJ93");
        }

        return connection;
    }

    
}


