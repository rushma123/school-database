/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.main;

import school.repository.view.HomeView;
import java.sql.*;

/**
 *
 * @author dell
 */
public class MainApplication {
     public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6437997","sql6437997","WXN3xrTJ93");
       // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","rush","rush123");
        Statement statement = connection.createStatement();
      
       
        HomeView homeView = new HomeView();
        homeView.showMainPage();
    }
    
    
}
