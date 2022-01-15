
package school.model;

public class student_class {
    String student_id;
    String class_id;
    String F_name;
    String L_name;
    int grade;
    String section;

    public student_class(String student_id, String class_id, String F_name,String L_name, int grade, String section) {
        this.student_id = student_id;
        this.class_id = class_id;
        this.F_name = F_name;
        this.L_name = L_name;
        this.grade = grade;
        this.section = section;
    }

    @Override
    public String toString() {
        return "student_class{" + "student_id=" + student_id + ", class_id=" + class_id + ", F_name=" + F_name + ", L_name=" + L_name + ", grade=" + grade + ", section=" + section + '}';
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String F_name) {
        this.F_name = F_name;
    }
    public String getL_name() {
        return L_name;
    }

    public void setL_name(String L_name) {
        this.L_name = L_name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
    
    
}
