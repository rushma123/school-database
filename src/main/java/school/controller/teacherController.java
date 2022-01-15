/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import school.repository.teacherRepository;
import school.model.teacher;


public class teacherController {
    private teacher currentUser = null;
    
    public teacher getCurrentUser() {
        return currentUser;
    }
    public int login(String id,String pw) throws SQLException {
        int check=0;
        teacherRepository teacher = new teacherRepository();
        List<teacher> teachers = teacher.getteachers();
        
        for ( teacher tea: teachers) {
            if ( tea.getId().equals(id) && tea.getId().equals (pw)){
                check++;
                
            }
        }
        return check;
    }
    
}
