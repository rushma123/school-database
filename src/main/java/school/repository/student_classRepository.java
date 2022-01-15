
package school.repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import school.main.DBConnection;
import school.model.student;
import school.model.student_class;

public class student_classRepository {
    public List<student_class> getstudent_class() throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student_class");
        List<student_class> student_classes = new ArrayList<>();

        while (resultSet.next()) {
           student_class sc = new student_class(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6));
           student_classes.add(sc);
        }
        //DBConnection.closeConnection();
        return student_classes;
    }
    
    public void save(student_class s) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
         try
        {
            //int x = statement.executeUpdate(("insert into student values ('" +stu.getStudent_id() + "','" + stu.getF_name() + "','" + stu.getL_name() + "','" + stu.getGender() + "','" + stu.getDOB() + "','" + stu.getAddress() + "','" +stu.getContact_number() + "','" + stu.getClass_id()+"')"));
            //int x = statement.executeUpdate(("insert into student_class values ('" +s.getStudent_id() + "','" + s.getClass_id() +"','" + s.getF_name() + "','" + s.getL_name() + "','" + s.getGrade() + "','" + s.getSection() +"')"));
            int x = statement.executeUpdate(("insert into student_class values ('" +s.getStudent_id() + "','" + s.getClass_id() +"','" + s.getF_name() + "','" + s.getL_name() + "','" + s.getGrade() + "','" + s.getSection() +"')"));
            if (x > 0)           
                System.out.println("One Student_class Record Successfully Added");           
            else
                System.out.println("ERROR OCCURED :("); 
           
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
   
}
