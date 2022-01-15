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
import school.model.teacher_class;
/**
 *
 * @author dell
 */
public class teacher_classRepository {
     public List<teacher_class> getteacher_class() throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from teacher_class");
        List<teacher_class> teacher_classes = new ArrayList<>();

        while (resultSet.next()) {
           teacher_class tc = new teacher_class(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getInt(5), resultSet.getString(6));
            teacher_classes.add(tc);
        }

        //DBConnection.closeConnection();
        return teacher_classes;
        
    }

 public void save(teacher_class tea) throws SQLException {
    
     Connection connection = DBConnection.getConnection();
     Statement statement = connection.createStatement();
    
     
       try
        {
            int x = statement.executeUpdate(("insert into teacher_class(teacher_id,class_id,F_name,L_name,grade,section) values ('"+ tea.getTeacher_id() + "','" + tea.getClass_id()+ "','" + tea.getF_name() + "','" + tea.getL_name() + "','"  + tea.getGrade() + "','" + tea.getSection()+"')"));
             
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

