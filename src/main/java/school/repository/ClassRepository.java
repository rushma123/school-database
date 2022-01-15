/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import school.main.DBConnection;
import school.model.Class;

/**
 *
 * @author User
 */
public class ClassRepository {
     public List<Class> getclass() throws SQLException {
       Connection connection = DBConnection.getConnection();
       Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from class");
        List<Class> classes = new ArrayList<>();

        while (resultSet.next()) {
           Class stu = new Class(resultSet.getString(1), resultSet.getInt(2), resultSet.getString(3));
            classes.add(stu);
        }
        return classes;
    }
    
     public void save(Class c) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
         try
        {
            int x = statement.executeUpdate(("insert into class values ('" +c.getClass_id() + "','" + c.getGrade() + "','" + c.getSection() +"')"));
             
            if (x > 0)           
                System.out.println("One Class Record Successfully Added");           
            else
                System.out.println("ERROR OCCURED :("); 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
}

