/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.repository.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import school.controller.studentController;
import school.model.student;
import school.model.result;
import school.repository.studentRepository;
import school.repository.resultRepository;
import school.repository.student_classRepository;
import school.model.student_class;

public class StudentDetail {

    public void DisplayStudents(String id) throws SQLException {
        studentRepository student = new studentRepository();
        List<student> students = student.getstudents();
        for (student stu : students) {
            if(stu.getStudent_id().equals(id))
            System.out.println(stu.toString());
        }
        //statement.executeQuery("select * from student");
         
    }

    public void ViewClass(String id) throws SQLException {
         student_classRepository student_class = new student_classRepository();
        List<student_class> student_classes = student_class.getstudent_class();
        
        for (student_class stu : student_classes) {
            if(stu.getStudent_id().equals(id))
            System.out.println(stu.toString());
           
        }
    }

    void ViewResult(String id) throws SQLException {
        int check=1;
        resultRepository result = new resultRepository();
        List<result> results = result.getresults();
        for (result r : results) 
        {
            if(r.getStudent_id().equals(id)){
            System.out.println(r.toString());
            if(r.getMarks_obtained()<40)
           {
               check=0;
           }
        }
        }
        if(check==0)
        {
            System.out.println("\nSorry you have Failed....... \n");
        }
        else
        {
            System.out.println("\nCongratulations You Have Passed.......\n");
        }
    }
}

