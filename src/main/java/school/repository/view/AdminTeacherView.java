/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.repository.view;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminTeacherView {
     public void showAdminTeacherPage() throws SQLException {
        System.out.println("Teachers:");
        System.out.println("Please select:");
        System.out.println("1 Display");
        System.out.println("2 Add");
        System.out.println("3 Delete");
        System.out.println("4 Update");
        System.out.println("5 Exit.");
        AdminTeacherDetail adminTeacherDetail = new AdminTeacherDetail();
		Scanner scanner = new Scanner(System.in);
		int selectedOption = scanner.nextInt();
		switch(selectedOption){
			case 1:
				adminTeacherDetail.DisplayTeachers();
                                showAdminTeacherPage();
				break;
			case 2:
				adminTeacherDetail.AddTeacher();
                                showAdminTeacherPage();
				break;
                        case 3:
				adminTeacherDetail.DeleteTeacher();
                                showAdminTeacherPage();
				break;
                        case 4:
				adminTeacherDetail.UpdateTeacher();
                                showAdminTeacherPage();
				break;
                        case 5:
                              
				break;
			  default:
                                System.out.println("Invalid Choice.......");
                                showAdminTeacherPage();
        }
    }
}
