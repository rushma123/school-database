/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import school.repository.studentRepository;
import school.model.student;


public class studentController {
    private student currentUser = null;
    
    public student getCurrentUser() {
        return currentUser;
    }
    public int login(String student_id,String pw) throws SQLException {
        int check=0;
        studentRepository student = new studentRepository();
        List<student> students = student.getstudents();
        
        for ( student stud: students) {
            if ( stud.getStudent_id().equals(student_id) && stud.getStudent_id().equals(pw)) {
                check++;
            }
        }
        return check;
    }
    
}
