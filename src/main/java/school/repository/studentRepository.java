/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import school.main.DBConnection;
//import javax.swing.JOptionPane;
import school.model.student;

public class studentRepository {
     public List<student> getstudents() throws SQLException {
       
        Connection connection = DBConnection.getConnection();
       Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student");
        List<student> students = new ArrayList<>();

        while (resultSet.next()) {
           student stu = new student(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
            students.add(stu);
        }
        return students;
    }
     
     
        public void save(student stu) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
         try
        {
            int x = statement.executeUpdate(("insert into student values ('" +stu.getStudent_id() + "','" + stu.getF_name() + "','" + stu.getL_name() + "','" + stu.getGender() + "','" + stu.getDOB() + "','" + stu.getAddress() + "','" +stu.getContact_number() + "','" + stu.getClass_id()+"')"));
             
            if (x > 0)           
                System.out.println("One Student Record Successfully Added");           
            else
                System.out.println("ERROR OCCURED :("); 
           
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
      
    
}
