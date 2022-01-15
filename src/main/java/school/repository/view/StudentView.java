/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.repository.view;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentView {

    public void showStudentPage(String username) throws SQLException {
        System.out.println("Students:");
        System.out.println("Please select:");
        System.out.println("1 Display details");
        System.out.println("2 View class");
        System.out.println("3 View result");
        System.out.println("4 Exit.");
        StudentDetail studentDetail = new StudentDetail();
        Scanner scanner = new Scanner(System.in);
        int selectedOption = scanner.nextInt();
        switch (selectedOption) {
            case 1:
                studentDetail.DisplayStudents(username);
                 showStudentPage(username);
                break;
            case 2:
                studentDetail.ViewClass(username);
                 showStudentPage(username);
                break;
            case 3:
                studentDetail.ViewResult(username);
                 showStudentPage(username);
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid Choice.......");
                showStudentPage(username);
        }
    }
}
