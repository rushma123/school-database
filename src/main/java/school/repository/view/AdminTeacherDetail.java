/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.repository.view;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import school.main.DBConnection;
import school.repository.teacherRepository;
import school.model.teacher;
import school.model.teacher_subject;
import school.repository.teacher_subjectRepository;
import school.repository.teacher_classRepository;
import school.model.teacher_class;
import school.repository.ClassRepository;
import school.model.Class;
import school.model.subject;
import school.repository.subjectRepository;

public class AdminTeacherDetail {
    public void DisplayTeachers() throws SQLException{
		
                System.out.println("Please select:");
                System.out.println("1 Teacher Detail");
                System.out.println("2 Teacher Class");
                System.out.println("3 Teacher Subject");
                System.out.println("4 Exit.");
		Scanner scanner = new Scanner(System.in);
		int selectedOption = scanner.nextInt();
		switch(selectedOption)
                {
                    case 1:
                        teacherRepository teacher = new teacherRepository(); 
                        List<teacher> teachers = teacher.getteachers();
                        for(teacher teac : teachers){
			System.out.println(teac.toString());
                        }
                        DisplayTeachers();
                        break;
                    case 2:
                        teacher_classRepository teac = new teacher_classRepository(); 
                        List<teacher_class> tclass = teac.getteacher_class();
                        for(teacher_class tea : tclass){
			System.out.println(tea.toString());
                        }
                        DisplayTeachers();
                        break;
                    case 3:
                        teacher_subjectRepository ts = new teacher_subjectRepository();
                        List<teacher_subject> teacher_subjects = ts.getteacher_subject();
                        for (teacher_subject tea_s : teacher_subjects) {
                        System.out.println(tea_s.toString());
                         }
                        DisplayTeachers();
                        break;
                    case 4:                       
                        break;
                    default:
                        System.out.println("Invalid Choice.......");
                        DisplayTeachers();
                }
	}
	
	void AddTeacher() throws SQLException{
                System.out.println("Please select:");
                System.out.println("1 Teacher Detail");
                System.out.println("2 Teacher Class");
                System.out.println("3 Teacher Subject");
                System.out.println("4 Exit.");
		Scanner scanner = new Scanner(System.in);
		int selectedOption = scanner.nextInt();
		switch(selectedOption)
                {
                    case 1:
                        //String subject_id="0";
                        //String class_id="0";
                        System.out.println("Please provide teacher details:");
                        System.out.println("Teacher Id:");
                        String id= scanner.next();
                        System.out.println("Enter First Name: ");
                        String F_name = scanner.next();
                        System.out.println("Enter Last Name: ");
                        String L_name = scanner.next();
                        System.out.println("Enter Address: ");
                        String address = scanner.next();
                        System.out.println("Enter Gender: ");
                        String gender = scanner.next();
                        System.out.println("Enter contact_number: ");
                        String contact = scanner.next();
                        System.out.println("Enter subject_id: ");
                        String subject_id = scanner.next();
                        System.out.println("Enter Class Id: ");
                        String class_id=scanner.next();
                        teacher tea = new teacher(id,F_name,L_name,address,gender,contact,subject_id,class_id);
                        teacherRepository teacher = new teacherRepository();
                        teacher.save(tea);
                        AddTeacher();
                        break;
                        
                    case 2:
                        String tF_name="harry";
                        String tL_name="Maharjan";
                        String tclass_id="0";
                        int tgrade=0;
                        String tsec="A";
                        System.out.println("Please provide teacher_class details:");
                        System.out.println("Teacher Id:");
                        String tc_id= scanner.next();
                      
                        teacherRepository t = new teacherRepository(); 
                        List<teacher> teachers = t.getteachers();
                        for(teacher teac : teachers){
                            if(teac.getId().equals(tc_id))
                            {
                                tclass_id=teac.getClass_id();
                                tF_name=teac.getF_name();
                                tL_name=teac.getL_name();
                                
                            }
                        }
                        ClassRepository Class = new ClassRepository();
                        List<Class> classes = Class.getclass();
                        for (Class c : classes) {
                            if(c.getClass_id().equals(tclass_id))
                            {
                               tgrade=c.getGrade();
                               tsec=c.getSection();
                            }
                        }
                        
                        
                        teacher_class tc = new teacher_class(tc_id,tclass_id,tF_name,tL_name,tgrade,tsec);
                        teacher_classRepository teacher_class = new teacher_classRepository();
                        teacher_class.save(tc);
                        AddTeacher();
                        break;
                        
                    case 3:
                        String tsubject_id="0";
                        String tsF_name="Hari";
                        String tsL_name="Shakya";
                        String tsname="math";
                        System.out.println("Please provide teacher_subject details:");
                        System.out.println("Teacher Id:");
                        String ts_id= scanner.next();
                       
                        teacherRepository tes = new teacherRepository(); 
                        List<teacher> teas = tes.getteachers();
                        for(teacher teac : teas){
                            if(teac.getId().equals(ts_id))
                            {
                                tsubject_id=teac.getSubject_id();
                                tsF_name=teac.getF_name();
                                tsL_name=teac.getL_name();
                            }
                        }
                        subjectRepository subject = new subjectRepository();
                        List<subject> subjects = subject.getsubjects();
                        for (subject sub : subjects) {
                            if(sub.getSubject_id().equals(tsubject_id))
                            {
                                tsname=sub.getSubject_name();
                            }
                        }
                        
                        teacher_subject y = new teacher_subject(ts_id,tsubject_id,tsF_name,tsL_name,tsname);
                        teacher_subjectRepository teacher_subject = new teacher_subjectRepository();
                        teacher_subject.save(y);
                        AddTeacher();
                        break;
                    
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid Choice.......");
                        AddTeacher();
                }	
	}
       void DeleteTeacher() throws SQLException {
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement();
                System.out.println("Please select:");
                System.out.println("1 Teacher Detail");
                System.out.println("2 Teacher Class");
                System.out.println("3 Teacher Subject");
                System.out.println("4 Exit.");
		Scanner scanner = new Scanner(System.in);
		int selectedOption = scanner.nextInt();
		switch(selectedOption)
                {
                    case 1:
                        System.out.println("Please provide teacher ID you want to delete:");
                        System.out.println("Teacher Id:");
                        String id = scanner.next();
                        try
                        {
                            String q1 = "DELETE from teacher WHERE id = '" + id +"'";
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
                        DeleteTeacher();
                        break;
                        
                    case 2:
                        System.out.println("Please provide teacher ID you want to delete:");
                        System.out.println("Teacher Id:");
                        String tid = scanner.next();
                        try
                        {
                             String q1 = "DELETE from teacher_class WHERE teacher_id = '" + tid +"'";
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
                        DeleteTeacher();
                        break;
                        
                    case 3:
                        System.out.println("Please provide teacher ID you want to delete:");
                        System.out.println("Teacher Id:");
                        String tsid = scanner.next();
                        try
                        {
                            String q1 = "DELETE from teacher_subject WHERE teacher_id = '" + tsid +"'";
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
                        DeleteTeacher();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid Choice.......");
                        DeleteTeacher();
                }
            }
        
        
        void UpdateTeacher() throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        int x=0;
         System.out.println("Please select:");
         System.out.println("1 Teacher Detail");
         System.out.println("2 Teacher Class");
         System.out.println("3 Teacher Subject");
         System.out.println("4 Exit.");
		Scanner scanner = new Scanner(System.in);
		int selectedOption = scanner.nextInt();
		switch(selectedOption)
                {
                    case 1:
                        System.out.println("Choose the attribute you want to update:");
                        System.out.println("1.ID");
                        System.out.println("2.F_Name");
                        System.out.println("3.L_Name");
                        System.out.println("4.Address");
                        System.out.println("5.Gender");
                        System.out.println("6.Contact");
                        System.out.println("7.Subject_id");
                        System.out.println("8.Class_id");
                        System.out.println("9.Exit");
                        int ch=scanner.nextInt();
             
                        System.out.println("\n\n\nPlease provide teacher ID you want to update:");
                        System.out.println("Teacher Id:");
                        String id = scanner.next();
                        try
                        {
                        switch(ch)
                        {
                            case 1:
                                System.out.println("Enter new id:");
                                String new_id=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher set id = '" + new_id + "' WHERE id = '" +id+ "'");
                                break;
                            case 2:
                                System.out.println("Enter new Firstname:");
                                String new_Fname=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher set F_name = '" + new_Fname +"' WHERE id = '" +id+ "'");
                                statement.executeUpdate("UPDATE teacher_class set F_name = '" + new_Fname +"' WHERE teacher_id = '" +id+ "'");
                                statement.executeUpdate("UPDATE teacher_subject set F_name = '" + new_Fname +"' WHERE teacher_id = '" +id+ "'");
                                break;
                            case 3:
                                System.out.println("Enter new Lastname:");
                                String new_Lname=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher set L_name = '" + new_Lname +"' WHERE id = '" +id+ "'");
                                statement.executeUpdate("UPDATE teacher_class set L_name = '" + new_Lname +"' WHERE teacher_id = '" +id+ "'");
                                statement.executeUpdate("UPDATE teacher_subject set L_name = '" + new_Lname +"' WHERE teacher_id = '" +id+ "'");
                                break;
                            case 4:
                                System.out.println("Enter new address:");
                                String new_address=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher set address = '" + new_address +"' WHERE id = '" +id+ "'");
                                break;
                             case 5:
                                System.out.println("Enter gender:");
                                String new_gender=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher set gender = '" + new_gender +"' WHERE id = '" +id+ "'");
                                break;
                             case 6:
                                System.out.println("Enter new contact:");
                                String new_contact=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher set contact = '" + new_contact +"' WHERE id = '" +id+ "'");
                                break;
                              case 7:
                                System.out.println("Enter new subject_id:");
                                String subject_id=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher set subject_id = '" + subject_id +"' WHERE id = '" +id+ "'");
                                break;
                            case 8:
                                System.out.println("Enter new class_id:");
                                String class_id=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher set class_id = '" + class_id +"' WHERE id = '" +id+ "'");
                                break;
                            case 9:
                                break;
                            default:
                            System.out.println("Invalid Choice.......");
                        }
                        if (x > 0)           
                                System.out.println("One User Successfully Updated...");           
                            else
                                System.out.println("ERROR OCCURED :( Teacher_id not found...");
                        }
                        catch(Exception e)
                        {
                            System.out.println("error occured"+e);
                        } 
                        UpdateTeacher();
                         break;                                                  
                    case 2:
                        System.out.println("Choose the attribute you want to update:");
                        System.out.println("1.Teacher ID");
                        System.out.println("2.Class_id");
                        System.out.println("3.F_Name");
                        System.out.println("4.L_Name");
                        System.out.println("5.Grade");
                        System.out.println("6.Section");
                        System.out.println("7.Exit");
                        int c=scanner.nextInt();
             
                        System.out.println("\n\n\nPlease provide teacher ID you want to update:");
                        System.out.println("Teacher Id:");
                        String tid = scanner.next();
                        try
                        {
                        switch(c)
                        {
                            case 1:
                                System.out.println("Enter new id:");
                                String new_id=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher_class set teacher_id = '" + new_id +"' WHERE teacher_id = '" +tid+ "'");
                                break;
                            case 2:
                                System.out.println("Enter new class_id:");
                                String class_id=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher_class set class_id = '" + class_id +"' WHERE teacher_id = '" +tid+ "'");
                                break;
                            case 3:
                                System.out.println("Enter new Firstname:");
                                String new_Fname=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher_class set F_name = '" + new_Fname +"' WHERE teacher_id = '" +tid+ "'");
                                statement.executeUpdate("UPDATE teacher set F_name = '" + new_Fname +"' WHERE id = '" +tid+ "'");
                                statement.executeUpdate("UPDATE teacher_subject set F_name = '" + new_Fname +"' WHERE teacher_id = '" +tid+ "'");
                                 break;
                            case 4:
                                System.out.println("Enter new Lastname:");
                                String new_Lname=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher_class set L_name = '" + new_Lname +"' WHERE teacher_id = '" +tid+ "'");
                                statement.executeUpdate("UPDATE teacher set L_name = '" + new_Lname +"' WHERE id = '" +tid+ "'");
                                statement.executeUpdate("UPDATE teacher_subject set L_name = '" + new_Lname +"' WHERE teacher_id = '" +tid+ "'");
                                break;
                            case 5:
                                System.out.println("Enter new grade:");
                                int new_grade=scanner.nextInt();
                                x=statement.executeUpdate("UPDATE teacher_class set grade = '" + new_grade +"' WHERE teacher_id = '" +tid+ "'");
                                statement.executeUpdate("UPDATE class set grade = '" + new_grade +"' WHERE teacher_id = '" +tid+ "'");
                                statement.executeUpdate("UPDATE student_class set grade = '" + new_grade +"' WHERE teacher_id = '" +tid+ "'");
                                break;
                             case 6:
                                System.out.println("Enter section:");
                                String new_section=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher_class set section = '" + new_section +"' WHERE teacher_id = '" +tid+ "'");
                                statement.executeUpdate("UPDATE class set section = '" + new_section +"' WHERE teacher_id = '" +tid+ "'");
                                statement.executeUpdate("UPDATE student_class set section = '" + new_section +"' WHERE teacher_id = '" +tid+ "'");
                                break;
                            case 7:
                                break;
                            default:
                            System.out.println("Invalid Choice.......");
                        }
                        if (x > 0)           
                                System.out.println("One User Successfully Updated..");           
                            else
                                System.out.println("ERROR OCCURED :( Teacher_id not found...");
                        }
                        catch(Exception e)
                                {
                                    System.out.println("error occured"+e);
                                 }
                        UpdateTeacher();
                        break;
                        
                    case 3:
                        System.out.println("Choose the attribute you want to update:");
                        System.out.println("1.Teacher ID");
                        System.out.println("2.Subject_id");
                        System.out.println("3.F_Name");
                        System.out.println("4.L_Name");
                        System.out.println("5.Subject_name");
                        System.out.println("6.Exit");
                        int s=scanner.nextInt();
             
                        System.out.println("\n\n\nPlease provide teacher ID you want to update:");
                        System.out.println("Teacher Id:");
                        String tsid = scanner.next();
                        try
                        {
                        switch(s)
                        {
                            case 1:
                                System.out.println("Enter new id:");
                                String new_id=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher_subject set teacher_id = '" + new_id +"' WHERE teacher_id = '" +tsid+ "'");
                                break;
                            case 2:
                                System.out.println("Enter new subject_id:");
                                String sub_id=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher_subject set subject_id = '" + sub_id +"' WHERE teacher_id = '" +tsid+ "'");
                                break;
                            case 3:
                                System.out.println("Enter new Firstname:");
                                String new_Fname=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher_subject set F_name = '" + new_Fname +"' WHERE teacher_id = '" +tsid+ "'");
                                statement.executeUpdate("UPDATE teacher set F_name = '" + new_Fname +"' WHERE id = '" +tsid+ "'");
                                statement.executeUpdate("UPDATE teacher_class set F_name = '" + new_Fname +"' WHERE teacher_id = '" +tsid+ "'");
                                 break;
                            case 4:
                                System.out.println("Enter new Lastname:");
                                String new_Lname=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher_subject set L_name = '" + new_Lname +"' WHERE teacher_id = '" +tsid+ "'");
                                statement.executeUpdate("UPDATE teacher set L_name = '" + new_Lname +"' WHERE id = '" +tsid+ "'");
                                statement.executeUpdate("UPDATE teacher_class set L_name = '" + new_Lname +"' WHERE teacher_id = '" +tsid+ "'");
                                break;
                             case 5:
                                System.out.println("Enter subject_name:");
                                String new_sname=scanner.next();
                                x=statement.executeUpdate("UPDATE teacher_subject set subject_name = '" + new_sname +"' WHERE teacher_id = '" +tsid+ "'");
                                statement.executeUpdate("UPDATE subject set subject_name = '" + new_sname +"' WHERE subject_id =(select subject_id from teacher_subject where teacher_id='"+tsid+"')");
                                break;
                            case 6:
                                break;
                            default:
                            System.out.println("Invalid Choice.......");
                        }
                        if (x > 0)           
                                System.out.println("One User Successfully Updated..");           
                            else
                                System.out.println("ERROR OCCURED :( Teacher_id not found...");
                        }
                        catch(Exception e)
                                {
                                    System.out.println("error occured"+e);
                                }  
                        UpdateTeacher();
                        break; 
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid Choice.......");
                        UpdateTeacher();
                } 
        }
    }

