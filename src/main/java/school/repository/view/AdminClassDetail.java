
package school.repository.view;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import school.main.DBConnection;
import school.model.Class;
import school.repository.ClassRepository;


public class AdminClassDetail {
     public void displayClass() throws SQLException {
                ClassRepository Class = new ClassRepository();
                List<Class> classes = Class.getclass();
                for (Class c : classes) {
                    System.out.println(c.toString());
        }
     }
     void addClass() throws SQLException {
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("Please provide class details:");
        System.out.println("Enter Class Id:");
        String class_id = scanner.next();
        System.out.println("Enter Grade: ");
	int grade = scanner.nextInt();
        System.out.println("Enter section: ");
        String section = scanner.next();
        Class c = new Class(class_id, grade, section);
        ClassRepository cs = new ClassRepository();
        
        cs.save(c);
    }
     
     void deleteClass() throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("Please provide class ID you want to delete:");
        System.out.println("Class Id:");
        String id = scanner.next();
        try
        {
             String q1 = "DELETE from class WHERE class_id = '" + id +"'";
            int x = statement.executeUpdate(q1);
             
            if (x > 0)           
                System.out.println("One class Successfully Deleted");           
            else
                System.out.println("ERROR OCCURED :("); 
           
            }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
     
     void UpdateClass() throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        int x=0;
        Scanner scanner = new Scanner(System.in);
                        System.out.println("Choose the attribute you want to update:");
                        System.out.println("1.Class ID");
                        System.out.println("2.Grade");
                        System.out.println("3.Section");
                        System.out.println("4.Exit");
                        int ch=scanner.nextInt();
             
                        System.out.println("\n\n\nPlease provide class ID you want to update:");
                        System.out.println("Class Id:");
                        String id = scanner.next();
                        try
                        {
                        switch(ch)
                        {
                            case 1:
                                System.out.println("Enter new id:");
                                String new_id=scanner.next();
                                x=statement.executeUpdate("UPDATE class set class_id = '" + new_id + "' WHERE class_id = '" +id+ "'");
                                break;
                            case 2:
                                System.out.println("Enter new grade:");
                                int new_grade=scanner.nextInt();
                                x=statement.executeUpdate("UPDATE class set grade = '" + new_grade +"' WHERE class_id = '" +id+ "'");
                                statement.executeUpdate("UPDATE subject set grade = '" + new_grade +"' WHERE subject_id =(select subject_id from teacher where class_id='"+id+"')");
                                statement.executeUpdate("UPDATE teacher_class set grade = '" + new_grade +"' WHERE class_id = '" +id+ "'");
                                statement.executeUpdate("UPDATE student_class set grade = '" + new_grade +"' WHERE class_id = '" +id+ "'");
                                break;
                            case 3:
                                System.out.println("Enter new section:");
                                String new_sec=scanner.next();
                                x=statement.executeUpdate("UPDATE class set section = '" + new_sec +"' WHERE class_id = '" +id+ "'");
                                statement.executeUpdate("UPDATE teacher_class set section = '" + new_sec +"' WHERE class_id = '" +id+ "'");
                                statement.executeUpdate("UPDATE student_class set section = '" + new_sec +"' WHERE class_id = '" +id+ "'");
                                break;
            
                            case 4:
                                break;
                        }
                        if (x > 0)           
                                System.out.println("One Class Successfully Updated...");           
                            else
                                System.out.println("ERROR OCCURED :( Class_id not found...");
                        }
                        catch(Exception e)
                        {
                            System.out.println("error occured"+e);
                        }  
                         
}
}
