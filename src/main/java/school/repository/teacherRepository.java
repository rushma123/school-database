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
import school.model.teacher;

public class teacherRepository {
        public List<teacher> getteachers() throws SQLException {
        //Connection connection = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6437997","sql6437997","WXN3xrTJ93");
        //Statement statement = connection.createStatement();
       Connection connection = DBConnection.getConnection();
       Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from teacher");
        List<teacher> teachers = new ArrayList<>();

        while (resultSet.next()) {
           teacher tea = new teacher(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
            teachers.add(tea);
        }

        //DBConnection.closeConnection();
        return teachers;
    }
     public void save(teacher tea) throws SQLException {
     teacherRepository teacher = new teacherRepository();
     Connection connection = DBConnection.getConnection();
     Statement statement = connection.createStatement();
     //statement.executeUpdate("insert into teacher(id,name,address,gender,contact,subject_id,class_id) values ('"+ tea.getId() + "','" + tea.getName() + "','" + tea.getAddress() + "','" + tea.getGender() + "','" + tea.getContact() + "','" +tea.getSubject_id() + "','" + tea.getClass_id()+"')");
     
       try
        {
            int x = statement.executeUpdate(("insert into teacher(id,F_name,L_name,address,gender,contact,subject_id,class_id) values ('"+ tea.getId() + "','" + tea.getF_name() + "','" + tea.getL_name() + "','"  + tea.getAddress() + "','" + tea.getGender() + "','" + tea.getContact() + "','" +tea.getSubject_id() + "','" + tea.getClass_id()+"')"));
             
            if (x > 0)           
                System.out.println("One Teacher Record Successfully Added");           
            else
                System.out.println("ERROR OCCURED :("); 
           
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
     }





