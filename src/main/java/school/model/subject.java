
package school.model;


public class subject {
    String subject_id;
    String subject_name;
    int grade;

    public subject(String subject_id, String subject_name, int grade) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "subject{" + "subject_id=" + subject_id + ", subject_name=" + subject_name + ", grade=" + grade + '}';
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
   
}
