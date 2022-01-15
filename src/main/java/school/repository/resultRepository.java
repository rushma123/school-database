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
import school.model.result;


public class resultRepository {
    public List<result> getresults() throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from result");
        List<result> results = new ArrayList<>();

        while (resultSet.next()) {
           result r = new result(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6),resultSet.getFloat(7));
            results.add(r);
        }

        //DBConnection.closeConnection();
        return results;
    }
    public void save(result r) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
         try
        {
            int x = statement.executeUpdate(("insert into result values ('" +r.getId() + "','" + r.getStudent_id() + "','" + r.getSubject_id() + "','" + r.getClass_id() + "','" + r.getFullmarks() +"','"+ r.getPassmarks() +"','" +r.getMarks_obtained()+"')"));
             
            if (x > 0)           
                System.out.println("One Student Result Successfully Added");           
            else
                System.out.println("ERROR OCCURED :("); 
           
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
}
