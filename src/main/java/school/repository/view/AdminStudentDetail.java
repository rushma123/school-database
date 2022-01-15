
package school.repository.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import school.main.DBConnection;
import school.model.student;
import school.model.result;
import school.repository.studentRepository;
import school.repository.resultRepository;
import school.repository.ClassRepository;
import school.model.Class;
import school.model.subject;
import school.repository.subjectRepository;
import school.model.student_class;
import school.repository.student_classRepository;

public class AdminStudentDetail {
     public void displayStudents() throws SQLException {
                System.out.println("Please select:");
                System.out.println("1 Student Detail");
                System.out.println("2 Student Class");
                System.out.println("3 Subject");
                System.out.println("4 Result");
                System.out.println("5 Exit.");
		Scanner scanner = new Scanner(System.in);
		int selectedOption = scanner.nextInt();
		switch(selectedOption)
                {
                    case 1:
                        studentRepository student = new studentRepository();
                        List<student> students = student.getstudents();
                        for (student stu : students) {
                            System.out.println(stu.toString());
                        }
                        displayStudents();
                        break;
                    case 2:
                        student_classRepository student_class = new student_classRepository();
                        List<student_class> student_classes = student_class.getstudent_class();
                        for (student_class c : student_classes) {
                            System.out.println(c.toString());
                        }
                        displayStudents();
                        break;
                    case 3:
                        subjectRepository subject = new subjectRepository();
                        List<subject> subjects = subject.getsubjects();
                        for (subject sub : subjects) {
                            System.out.println(sub.toString());
                        }
                        displayStudents();
                        break;
                    case 4:
                        resultRepository result = new resultRepository();
                        List<result> results = result.getresults();
                        for (result r : results) {
                            System.out.println(r.toString());
                        }
                        displayStudents();
                        break;
                    case 5:       
                        break;
                    default:
                        System.out.println("Invalid Choice.......");
                        displayStudents();    
                }
         }

    void addStudent() throws SQLException {
                System.out.println("Please select:");
                System.out.println("1 Student Detail");
                System.out.println("2 Student Class");
                System.out.println("3 Subject");
                System.out.println("4 Result");
                System.out.println("5 Exit.");
		Scanner scanner = new Scanner(System.in);
		int selectedOption = scanner.nextInt();
		switch(selectedOption)
                {
                    case 1:
                        System.out.println("Please provide student details:");
                        System.out.println("Enter Student Id:");
                        String student_id = scanner.next();
                        System.out.println("Enter First Name: ");
                        String F_name = scanner.next();
                        System.out.println("Enter Last Name: ");
                        String L_name = scanner.next();
                        System.out.println("Enter Gender: ");
                        String gender = scanner.next();
                        System.out.println("Enter DOB: ");
                        String dob = scanner.next();
                        System.out.println("Enter Address: ");
                        String address = scanner.next();
                        System.out.println("Enter contact_number: ");
                        String contact_number = scanner.next();
                        System.out.println("Enter Class Id: ");
                        String class_id = scanner.next();
                        student stu = new student(student_id, F_name, L_name, gender, dob, address, contact_number, class_id);
                        studentRepository stud = new studentRepository();
                        stud.save(stu);
                        addStudent();
                        break;
                    case 2:
                        String sclass_id="0";
                        String sF_name="Harry";
                        String sL_name="jhgd";
                        int sgrade=0;
                        String sec="A";
                        System.out.println("Please provide student_class details:");
                        System.out.println("Enter Student Id:");
                        String stud_id = scanner.next();
                        /*System.out.println("Enter Class Id: ");
                        String sclass_id = scanner.next();
                        /*System.out.println("Enter First Name: ");
                        String sF_name = scanner.next();
                        System.out.println("Enter Last Name: ");
                        String sL_name = scanner.next();*/
                       studentRepository student = new studentRepository();
                        List<student> students = student.getstudents();
                        for (student st : students) {
                            if(st.getStudent_id().equals(stud_id))
                            {
                                sclass_id=st.getClass_id();
                                sF_name=st.getF_name();
                                sL_name=st.getL_name();
                            }
                        }
                        
                        ClassRepository Class = new ClassRepository();
                        List<Class> classes = Class.getclass();
                        for (Class c : classes) {
                            if(c.getClass_id().equals(sclass_id))
                            {
                               sgrade=c.getGrade();
                               sec=c.getSection();
                            }
                        }
                       /* System.out.println("Enter Grade: ");
                        int sgrade = scanner.nextInt();
                        System.out.println("Enter section: ");
                        String sec = scanner.next(); */                 
                        student_class stuc = new student_class(stud_id,sclass_id,sF_name,sL_name, sgrade, sec);
                        student_classRepository studc = new student_classRepository();
                        studc.save(stuc);
                        addStudent();
                        break;                       
                    case 3:
                        System.out.println("Please provide subject details:");
                        System.out.println("Enter Subject Id:");
                        String s_id = scanner.next();
                        System.out.println("Enter Subject name: ");
                        String sname_id = scanner.next();
                        System.out.println("Enter Grade: ");
                        int subgrade = scanner.nextInt();                       
                        subject sub = new subject(s_id,sname_id,subgrade);
                        subjectRepository subj = new subjectRepository();
                        subj.save(sub);
                        addStudent();
                        break;
                    case 4:
                        String c_id="0";
                        System.out.println("Please provide details:");
                        System.out.println("Enter Result Id:");
                        String r_id = scanner.next();
                        System.out.println("Enter Student Id: ");
                        String stu_id = scanner.next();
                        System.out.println("Enter Subject Id: ");
                        String sub_id = scanner.next();
                       /* System.out.println("Enter Class Id: ");
                        String c_id = scanner.next();*/
                        
                        int full = 100;
                        
                        int pass = 40;
                        System.out.println("Enter Marks: ");
                        float marks = scanner.nextFloat();    
                        
                        studentRepository q = new studentRepository();
                        List<student> a = q.getstudents();
                        for (student st : a) {
                            if(st.getStudent_id().equals(stu_id))
                            {
                                c_id=st.getClass_id();
                            }
                        }
                        result re = new result(r_id,stu_id,sub_id,c_id,full,pass,marks);
                        resultRepository res = new resultRepository();
                        res.save(re);
                        addStudent();
                        break;
                    case 5:
                        
                        break;
                    default:
                        System.out.println("Invalid Choice.......");  
                        addStudent();
                }
       }
      void deleteStudent() throws SQLException {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
                System.out.println("Please select:");
                System.out.println("1 Student Detail");
                System.out.println("2 Student Class");
                System.out.println("3 Subject");
                System.out.println("4 Result");
                System.out.println("5 Exit.");
		Scanner scanner = new Scanner(System.in);
		int selectedOption = scanner.nextInt();
		switch(selectedOption)
                {
                    case 1:
                        System.out.println("Please provide student ID you want to delete:");
                        System.out.println("Student Id:");
                        String id = scanner.next();
                        try
                        {
                             String q1 = "DELETE from student WHERE student_id = '" + id +"'";
                            int x = statement.executeUpdate(q1);
                            if (x > 0)           
                                System.out.println("One User Successfully Deleted");           
                            else
                                System.out.println("ERROR OCCURED :("); 
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        deleteStudent();
                        break;
                    case 2:
                        System.out.println("Please provide student ID you want to delete:");
                        System.out.println("Student Id:");
                        String sc_id = scanner.next();
                        try
                        {
                             String q1 = "DELETE from student_class WHERE student_id = '" + sc_id +"'";
                            int x = statement.executeUpdate(q1);
                            if (x > 0)           
                                System.out.println("One Student_class Successfully Deleted");           
                            else
                                System.out.println("ERROR OCCURED :("); 
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        deleteStudent();
                        break;
                    case 3:
                        System.out.println("Please provide subject ID you want to delete:");
                        System.out.println("Subject Id:");
                        String sub_id = scanner.next();
                        try
                        {
                             String q1 = "DELETE from subject WHERE subject_id = '" + sub_id +"'";
                            int x = statement.executeUpdate(q1);
                            if (x > 0)           
                                System.out.println("One Subject Successfully Deleted");           
                            else
                                System.out.println("ERROR OCCURED :("); 
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        deleteStudent();
                        break;
                    case 4:
                        System.out.println("Please provide student ID and subject_id you want to delete:");
                        System.out.println("Student Id:");
                        String r_id = scanner.next();
                        System.out.println("Subject Id:");
                        String s_id = scanner.next();
                        try
                        {
                             String q1 = "DELETE from result WHERE student_id = '" + r_id + "'AND subject_id = '" + s_id + "'" ;
                            int x = statement.executeUpdate(q1);
                            if (x > 0)           
                                System.out.println("One Student's subject Result Successfully Deleted");           
                            else
                                System.out.println("ERROR OCCURED :("); 
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        deleteStudent();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid Choice.......");
                        deleteStudent();
                }
    }

    void updateStudent() throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
                 int x=0;
                System.out.println("Please select:");
                System.out.println("1 Student Detail");
                System.out.println("2 Student Class");
                System.out.println("3 Subject");
                System.out.println("4 Result");
                System.out.println("5 Exit.");
		Scanner scanner = new Scanner(System.in);
		int selectedOption = scanner.nextInt();
		switch(selectedOption)
                {
                    case 1:
                        System.out.println("Choose the attribute you want to update:");
                        System.out.println("1.ID");
                        System.out.println("2.F_Name");
                        System.out.println("3.L_Name");
                        System.out.println("4.Gender");
                        System.out.println("5.DOB");
                        System.out.println("6.Address");
                        System.out.println("7.Contact");
                        System.out.println("8.Class_id");
                        System.out.println("9.Exit");
                        int ch=scanner.nextInt();
                            System.out.println("\n\n\nPlease provide Student ID you want to update:");
                            System.out.println("Student Id:");
                            String id = scanner.next();
                            try
                           {
                           switch(ch)
                           {
                                case 1:
                                   System.out.println("Enter new id:");
                                   String new_id=scanner.next();
                                    x=statement.executeUpdate("UPDATE student set student_id = '" + new_id +"' WHERE student_id = '" +id+ "'");
                                   break;
                                case 2:
                                   System.out.println("Enter new Firstname:");
                                   String new_Fname=scanner.next();
                                    x=statement.executeUpdate("UPDATE student set F_name = '" + new_Fname +"' WHERE student_id = '" +id+ "'");
                                    statement.executeUpdate("UPDATE student_class set F_name = '" + new_Fname +"' WHERE student_id = '" +id+ "'");
                                    
                                    break;
                                case 3:
                                    System.out.println("Enter new Lastname:");
                                   String new_Lname=scanner.next();
                                    x=statement.executeUpdate("UPDATE student set L_name = '" + new_Lname +"' WHERE student_id = '" +id+ "'");
                                    statement.executeUpdate("UPDATE student_class set L_name = '" + new_Lname +"' WHERE student_id = '" +id+ "'");
                                    break;
                                case 4:
                                    System.out.println("Enter new gender:");
                                    String new_gender=scanner.next();
                                    x=statement.executeUpdate("UPDATE student set gender = '" + new_gender +"' WHERE student_id = '" +id+ "'");
                                   break;
                                case 5:
                                    System.out.println("Enter new DOB:");
                                    String new_DOB=scanner.next();
                                    x=statement.executeUpdate("UPDATE student set DOB = '" + new_DOB +"' WHERE student_id = '" +id+ "'");
                                   break;
                                case 6:
                                    System.out.println("Enter new address:");
                                    String new_address=scanner.next();
                                    x=statement.executeUpdate("UPDATE student set address = '" + new_address +"' WHERE student_id = '" +id+ "'");
                                   break;
                                case 7:
                                    System.out.println("Enter new contact:");
                                    String new_contact=scanner.next();
                                    x=statement.executeUpdate("UPDATE student set contact_number = '" + new_contact +"' WHERE student_id = '" +id+ "'");
                                   break;
                                case 8:
                                    System.out.println("Enter new class_id:");
                                    String class_id=scanner.next();
                                    x=statement.executeUpdate("UPDATE student set class_id = '" + class_id +"' WHERE student_id = '" +id+ "'");
                                   break;
                                case 9:
                                   break;
                                default:
                                    System.out.println("Invalid Choice.......");
                           }
                            if (x > 0)           
                                   System.out.println("One Student Successfully Updated");           
                               else
                                   System.out.println("ERROR OCCURED :( Student id not found..."); 
                            }
                            catch(Exception e)
                                    {
                                       System.out.println("error occured"+e);
                                    }
                            updateStudent();
                        break;
                    case 2:
                        System.out.println("Choose the attribute you want to update:");
                        System.out.println("1.Student ID");
                        System.out.println("2.Class_id");
                        System.out.println("3.F_Name");
                        System.out.println("4.L_Name");
                        System.out.println("5.Grade");
                        System.out.println("6.Section");
                        System.out.println("7.Exit");
                        int c=scanner.nextInt();
                            System.out.println("\n\n\nPlease provide Student ID you want to update:");
                            System.out.println("Student Id:");
                            String sid = scanner.next();
                            try
                           {
                           switch(c)
                           {
                                case 1:
                                   System.out.println("Enter new student id:");
                                   String sc_id=scanner.next();
                                    x=statement.executeUpdate("UPDATE student_class set student_id = '" + sc_id +"' WHERE student_id = '" +sid+ "'");
                                   break;
                                case 2:
                                    System.out.println("Enter new class_id:");
                                    String sclass_id=scanner.next();
                                    x=statement.executeUpdate("UPDATE student_class set class_id = '" + sclass_id +"' WHERE student_id = '" +sid+ "'");
                                   break;
                                case 3:
                                   System.out.println("Enter new Firstname:");
                                   String sc_Fname=scanner.next();
                                    x=statement.executeUpdate("UPDATE student_class set F_name = '" + sc_Fname +"' WHERE student_id = '" +sid+ "'");
                                    statement.executeUpdate("UPDATE student set F_name = '" + sc_Fname +"' WHERE student_id = '" +sid+ "'");
                                    break;
                                case 4:
                                    System.out.println("Enter new Lastname:");
                                   String sc_Lname=scanner.next();
                                    x=statement.executeUpdate("UPDATE student_class set L_name = '" + sc_Lname +"' WHERE student_id = '" +sid+ "'");
                                    statement.executeUpdate("UPDATE student set L_name = '" + sc_Lname +"' WHERE student_id = '" +sid+ "'");
                                    break;
                                case 5:
                                    System.out.println("Enter new grade:");
                                    String sc_grade=scanner.next();
                                    x=statement.executeUpdate("UPDATE student_class set grade = '" + sc_grade +"' WHERE student_id = '" +sid+ "'");
                                    statement.executeUpdate("UPDATE class set grade = '" + sc_grade +"' WHERE class_id = (select class_id from student where student_id='"+sid+"')");
                                    statement.executeUpdate("UPDATE teacher_class set grade = '" + sc_grade +"' WHERE class_id = (select class_id from student where student_id='"+sid+"')");
                                    statement.executeUpdate("UPDATE subject set grade = '" + sc_grade +"' WHERE subject_id =(select subject_id from teacher where class_id=(select class_id from student where student_id='"+sid+"'))");
                                   break;
                                case 6:
                                    System.out.println("Enter new section:");
                                    String sc_sec=scanner.next();
                                    x=statement.executeUpdate("UPDATE student_class set section = '" + sc_sec +"' WHERE student_id = '" +sid+ "'");
                                    statement.executeUpdate("UPDATE teacher_class set section = '" + sc_sec +"' WHERE class_id = (select class_id from student where student_id='"+sid+"')");
                                    statement.executeUpdate("UPDATE class set section = '" + sc_sec +"' WHERE class_id = (select class_id from student where student_id='"+sid+"')");
                                   break;
                                case 7:
                                   break;
                                default:
                                    System.out.println("Invalid Choice.......");
                           }
                            if (x > 0)           
                                   System.out.println("One Student-Class Successfully Updated");           
                               else
                                   System.out.println("ERROR OCCURED :( Student id not found..."); 
                            }
                            catch(Exception e)
                                    {
                                       System.out.println("error occured"+e);
                                    }
                            updateStudent();
                        break;
                    case 3:
                        System.out.println("Choose the attribute you want to update:");
                        System.out.println("1.Subject ID");
                        System.out.println("2.Subject_name");
                        System.out.println("3.Grade");
                        System.out.println("4.Exit");
                        int s=scanner.nextInt();
                            System.out.println("\n\n\nPlease provide Subject ID you want to update:");
                            System.out.println("Subject Id:");
                            String sub_id = scanner.next();
                            try
                           {
                           switch(s)
                           {
                                case 1:
                                   System.out.println("Enter new subject id:");
                                   String s_id=scanner.next();
                                    x=statement.executeUpdate("UPDATE subject set subject_id = '" + s_id +"' WHERE subject_id = '" +sub_id+ "'");
                                   break;
                                case 2:
                                    System.out.println("Enter new subject_name:");
                                    String s_name=scanner.next();
                                    x=statement.executeUpdate("UPDATE subject set subject_name = '" + s_name +"' WHERE subject_id = '" +sub_id+ "'");
                                    statement.executeUpdate("UPDATE teacher_subject set subject_name = '" + s_name +"' WHERE subject_id = '" +sub_id+ "'");
                                   break;
                                case 3:
                                   System.out.println("Enter new Grade:");
                                   int s_grade=scanner.nextInt();
                                    x=statement.executeUpdate("UPDATE subject set grade = '" + s_grade +"' WHERE subject_id = '" +sub_id+ "'");
                                    statement.executeUpdate("UPDATE teacher_class set grade = '" + s_grade +"' WHERE class_id = (select class_id from teacher where subject_id='"+sub_id+"')");
                                    statement.executeUpdate("UPDATE student_class set grade = '" + s_grade +"' WHERE class_id = (select class_id from teacher where subject_id='"+sub_id+"')");
                                    statement.executeUpdate("UPDATE class set grade = '" + s_grade +"' WHERE class_id = (select class_id from teacher where subject_id='"+sub_id+"')");
                                    break;
                                case 4:
                                   break;
                                default:
                                    System.out.println("Invalid Choice.......");
                           }
                            if (x > 0)           
                                   System.out.println("One Subject Successfully Updated");           
                               else
                                   System.out.println("ERROR OCCURED :( Subject id not found..."); 
                            }
                            catch(Exception e)
                                    {
                                       System.out.println("error occured"+e);
                                    }
                            updateStudent();
                        break;
                    case 4:
                        System.out.println("Choose the attribute you want to update:");
                        System.out.println("1.Result ID");
                        System.out.println("2.Student_id");
                        System.out.println("3.Subject_id");
                        System.out.println("4.Class_id");
                        System.out.println("5.Marks_obtained");
                        System.out.println("6.Exit");
                        int r=scanner.nextInt();
                            System.out.println("\n\n\nPlease provide Result ID you want to update:");
                            System.out.println("Result Id:");
                            String rid = scanner.next();
                            try
                           {
                           switch(r)
                           {
                               case 1:
                                   System.out.println("Enter new result id:");
                                   String r_id=scanner.next();
                                    x=statement.executeUpdate("UPDATE result set id = '" + r_id +"' WHERE id = '" +rid+ "'");
                                   break;
                                case 2:
                                   System.out.println("Enter new student id:");
                                   String sc_id=scanner.next();
                                    x=statement.executeUpdate("UPDATE result set student_id = '" + sc_id +"' WHERE id = '" +rid+ "'");
                                   break;
                                case 3:
                                   System.out.println("Enter new subject id:");
                                   String rsub_id=scanner.next();
                                    x=statement.executeUpdate("UPDATE result set subject_id = '" + rsub_id +"' WHERE id = '" +rid+ "'");
                                   break;
                                case 4:
                                    System.out.println("Enter new class_id:");
                                    String rclass_id=scanner.next();
                                    x=statement.executeUpdate("UPDATE result set class_id = '" + rclass_id +"' WHERE id = '" +rid+ "'");
                                   break;
                                case 5:
                                   System.out.println("Enter new Marks:");
                                   float marks=scanner.nextFloat();
                                    x=statement.executeUpdate("UPDATE result set marks_obtained = '" + marks +"' WHERE id = '" +rid+ "'");
                                    break;
                               
                                case 6:
                                   break;
                                default:
                                    System.out.println("Invalid Choice.......");
                           }
                            if (x > 0)           
                                   System.out.println("One Student Result Successfully Updated");           
                               else
                                   System.out.println("ERROR OCCURED :( Student id not found..."); 
                            }
                            catch(Exception e)
                                    {
                                       System.out.println("error occured"+e);
                                    }
                            updateStudent();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid Choice.......");    
                        updateStudent();
                }
    } 

}
