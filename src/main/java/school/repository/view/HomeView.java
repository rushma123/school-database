/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.repository.view;

import java.sql.SQLException;
import java.util.Scanner;
import school.controller.studentController;
import school.controller.teacherController;
import school.controller.adminController;
/**
 *
 * @author dell
 */
public class HomeView {

    public void showMainPage() throws SQLException {
        System.out.println("Welcome to our school");
        System.out.println("Login as:");
        System.out.println("1 Admin");
        System.out.println("2 Student");
        System.out.println("3 Teacher");
        System.out.println("4 Exit.");
        AdminView adminView = new AdminView();
        StudentView studentView = new StudentView();
        TeacherView teacherView = new TeacherView();
        studentController studentLogin=new studentController();
        teacherController teacherLogin=new teacherController();
        adminController adminLogin=new adminController();
        Scanner scanner = new Scanner(System.in);
        int selectedOption = scanner.nextInt();
        
        switch (selectedOption) {
            case 1:
                System.out.println("Login as admin:\n");
                System.out.println("username=");
                String id=scanner.next();
                System.out.println("password=");
                String pw=scanner.next();
                int ad=adminLogin.login(id,pw);
                if(ad == 1)
                {    
                adminView.showAdminPage();
                }
                else
                {
                    System.out.println("Incorrect username or password");
                }  
                
                showMainPage();
                break;
            case 2:
                System.out.println("Login as student:\n");
                System.out.println("username=");
                String stu_id=scanner.next();
                System.out.println("password=");
                String stu_pw=scanner.next();
                int a=studentLogin.login(stu_id,stu_pw);
                if(a == 1)
                {    
                studentView.showStudentPage(stu_id);
                }
                else
                {
                    System.out.println("Incorrect username or password");
                }  
                showMainPage();
                
                break;
            case 3:
                 System.out.println("Login as teacher:\n");
                System.out.println("username=");
                String tea_id=scanner.next();
                System.out.println("password=");
                String tea_password=scanner.next();
                int b=teacherLogin.login(tea_id,tea_password);
                if(b == 1)
                {    
                teacherView.showTeacherPage(tea_id);
                }
                 else
                {
                    System.out.println("Incorrect username or password");
                }  
                showMainPage();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid Choice.......");
                showMainPage();
        }
    }
    
}
