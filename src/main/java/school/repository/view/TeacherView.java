/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.repository.view;
import school.repository.view.TeacherDetail;
import java.sql.SQLException;
import java.util.Scanner;


public class TeacherView {
    public void showTeacherPage(String id) throws SQLException {
        System.out.println("Teachers:");
        System.out.println("Please select:");
        System.out.println("1 Display");
        System.out.println("2 class");
        System.out.println("3 Subjects");
        System.out.println("4 Exit.");
        TeacherDetail teacherDetail = new TeacherDetail();
		Scanner scanner = new Scanner(System.in);
		int selectedOption = scanner.nextInt();
		switch(selectedOption){
			case 1:
				teacherDetail.DisplayTeachers(id);
                                showTeacherPage(id);
				break;
			case 2:
				teacherDetail.ViewClass(id);
                                showTeacherPage(id);
				break;
                        case 3:
                                teacherDetail.ViewSubject(id);
                                showTeacherPage(id);
				break;
                                
                        case 4:
                                break;
			 default:
                            System.out.println("Invalid Choice.......");
                             showTeacherPage(id);
        }
    }
}
