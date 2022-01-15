
package school.model;


public class result {
    String id;
    String student_id;
    String subject_id;
    String class_id;
    int fullmarks;
    int passmarks;
    Float marks_obtained;

    public result(String id, String student_id, String subject_id, String class_id, int fullmarks, int passmarks, Float marks_obtained) {
        this.id = id;
        this.student_id = student_id;
        this.subject_id = subject_id;
        this.class_id = class_id;
        this.fullmarks = fullmarks;
        this.passmarks = passmarks;
        this.marks_obtained = marks_obtained;
    }

    @Override
    public String toString() {
        return "result{" + "id=" + id + ", student_id=" + student_id + ", subject_id=" + subject_id + ", class_id=" + class_id + ", fullmarks=" + fullmarks + ", passmarks=" + passmarks + ", marks_obtained=" + marks_obtained + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public int getFullmarks() {
        return fullmarks;
    }

    public void setFullmarks(int fullmarks) {
        this.fullmarks = fullmarks;
    }

    public int getPassmarks() {
        return passmarks;
    }

    public void setPassmarks(int passmarks) {
        this.passmarks = passmarks;
    }

    public Float getMarks_obtained() {
        return marks_obtained;
    }

    public void setMarks_obtained(Float marks_obtained) {
        this.marks_obtained = marks_obtained;
    }

    
   
}
