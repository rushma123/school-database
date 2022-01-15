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
import school.model.teacher_subject;
/**
 *
 * @author dell
 */
public class teacher_subjectRepository {
    public List<teacher_subject> getteacher_subject() throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from teacher_subject");
        List<teacher_subject> teacher_subjects = new ArrayList<>();

        while (resultSet.next()) {
           teacher_subject ts = new teacher_subject(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
            teacher_subjects.add(ts);
        }

        //DBConnection.closeConnection();
        return teacher_subjects;
    }
     public void save(teacher_subject tea) throws SQLException {
    
     Connection connection = DBConnection.getConnection();
     Statement statement = connection.createStatement();
    
     
       try
        {
            int x = statement.executeUpdate(("insert into teacher_subject(teacher_id,subject_id,F_name,L_name,subject_name) values ('"+ tea.getTeacher_id() + "','" + tea.getSubject_id()+ "','" + tea.getF_name() + "','" + tea.getL_name() + "','"  + tea.getSubject_name() +"')"));
             
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


