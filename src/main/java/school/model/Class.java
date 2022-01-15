
package school.model;


public class Class {
   
    String class_id;
   int grade;
    String section;

    public Class( String class_id, int grade,String section) {
        
        this.class_id = class_id;
        this.grade = grade;
        this.section = section;
    }

    @Override
    public String toString() {
        return "Class{" + " class_id=" + class_id +  ", grade=" + grade + ", section=" + section +'}';
    }


    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
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
