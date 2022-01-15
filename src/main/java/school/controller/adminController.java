/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.controller;

import java.sql.SQLException;




public class adminController {
     public int login(String id,String pw) throws SQLException {
        int check=0;
        
            if ( id.equals("admin") && pw.equals("admin")) {
                check++;
            }
        
        return check;
    }
}
