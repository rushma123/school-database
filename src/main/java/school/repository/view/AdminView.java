/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.repository.view;
import java.sql.SQLException;
import java.util.Scanner;


public class AdminView {
     public void showAdminPage() throws SQLException {
        System.out.println("you have logged in as admin:");
        System.out.println("Please select:");
        System.out.println("1 Students");
        System.out.println("2 Teachers");
         System.out.println("3.Class");
        System.out.println("4 Exit.");
        AdminStudentView adminStudentView = new AdminStudentView();
        AdminTeacherView adminTeacherView = new AdminTeacherView();
        AdminClassView adminClassView = new AdminClassView();
        Scanner scanner = new Scanner(System.in);
        int selectedOption = scanner.nextInt();
        switch (selectedOption) {
            case 1:
                adminStudentView.showAdminStudentPage();
                showAdminPage();
                break;
            case 2:
                adminTeacherView.showAdminTeacherPage();
                showAdminPage();
                break;
            case 3:
                adminClassView.showAdminClassPage();
                showAdminPage();
                break;
            case 4:
                
                break;
            default:
                System.out.println("Invalid Choice.......");
                showAdminPage();
        }
    }
}
