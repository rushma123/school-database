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
import school.model.subject;
/**
 *
 * @author dell
 */
public class subjectRepository {
     public List<subject> getsubjects() throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from subject");
        List<subject> subjects = new ArrayList<>();

        while (resultSet.next()) {
           subject s = new subject(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
            subjects.add(s);
        }

        //DBConnection.closeConnection();
        return subjects;
    }
     
     public void save(subject s) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
         try
        {
            int x = statement.executeUpdate(("insert into subject values ('" +s.getSubject_id() + "','" + s.getSubject_name() +"','" + s.getGrade() +"')"));
             
            if (x > 0)           
                System.out.println("One Subject Record Successfully Added");           
            else
                System.out.println("ERROR OCCURED :("); 
           
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
}
