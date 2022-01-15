/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.repository.view;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminStudentView {
      public void showAdminStudentPage() throws SQLException {
        System.out.println("Students:");
        System.out.println("Please select:");
        System.out.println("1 Display ");
        System.out.println("2 Add ");
        System.out.println("3 Delete ");
        System.out.println("4 Update");
        System.out.println("5 Exit.");
        AdminStudentDetail adminStudentDetail = new AdminStudentDetail();
        Scanner scanner = new Scanner(System.in);
        int selectedOption = scanner.nextInt();
        switch (selectedOption) {
            case 1:
                adminStudentDetail.displayStudents();
                showAdminStudentPage();
                break;
            case 2:
                adminStudentDetail.addStudent();
                showAdminStudentPage();
                break;
            case 3:
                adminStudentDetail.deleteStudent();
                showAdminStudentPage();
                break;
            case 4:
                adminStudentDetail.updateStudent();
                showAdminStudentPage();
                break;
            case 5:
                break;  
            default:
                System.out.println("Invalid Choice.......");
                showAdminStudentPage();
        }
    }
}
