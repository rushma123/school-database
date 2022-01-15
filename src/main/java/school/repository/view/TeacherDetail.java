/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.repository.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import school.controller.teacherController;
import school.repository.teacherRepository;
import school.model.teacher;
import school.model.teacher_subject;
import school.repository.teacher_subjectRepository;
import school.repository.teacher_classRepository;
import school.model.teacher_class;

public class TeacherDetail {
     public void DisplayTeachers(String id) throws SQLException{
		
		//teacherController tea = new teacherController();
		teacherRepository teacher = new teacherRepository(); 
		List<teacher> teachers = teacher.getteachers();
                                 
		for(teacher teac : teachers){
                        if(teac.getId().equals(id))
			System.out.println(teac.toString());
		}
               

	}
	public void ViewClass(String id) throws SQLException{
		teacher_classRepository teacher_class = new teacher_classRepository(); 
		List<teacher_class> teacher_classes = teacher_class.getteacher_class();
                                 
		for(teacher_class teac : teacher_classes){
                        if(teac.getTeacher_id().equals(id))
			System.out.println(teac.toString());
                       
		}
		
        }
	
       /* public void displayTeacher_class() throws SQLException{
		
		//teacherController tea = new teacherController();
		teacher_classRepository teacher = new teacher_classRepository(); 
		List<teacher_class> teacher_classes = teacher.getteachers();
		for(teacher teac : teachers){
			System.out.println(teac.toString());
		}
              
        }*/
         public void ViewSubject(String id) throws SQLException {
       
         //Connection connection = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6437997","sql6437997","WXN3xrTJ93");
          //Statement statement = connection.createStatement();    

        //studentController stud = new studentController();
        teacher_subjectRepository ts = new teacher_subjectRepository();
        List<teacher_subject> teacher_subjects = ts.getteacher_subject();
        for (teacher_subject tea_s : teacher_subjects) {
            if(tea_s.getTeacher_id().equals(id))
            System.out.println(tea_s.toString());
           
        }

    }
}
