
package school.repository.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import school.model.Class;
import school.repository.ClassRepository;
import school.repository.view.AdminClassDetail;

public class AdminClassView {
    public void showAdminClassPage() throws SQLException {
        System.out.println("Class:");
        System.out.println("Please select:");
        System.out.println("1 Display class");
        System.out.println("2 Add class");
        System.out.println("3 Delete class");
        System.out.println("4 Update class");
        System.out.println("5 Exit.");
   
        Scanner scanner = new Scanner(System.in);
        int selectedOption = scanner.nextInt();
        AdminClassDetail ad=new AdminClassDetail();
        switch (selectedOption) {
            case 1:
                ad.displayClass();
                showAdminClassPage();
                break;
            case 2:
                ad.addClass();
                showAdminClassPage();
                break;
            case 3:
                ad.deleteClass();
                showAdminClassPage();
                break;
            case 4:
                ad.UpdateClass();
                showAdminClassPage();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid Choice.......");
                showAdminClassPage();
    }
}
}

