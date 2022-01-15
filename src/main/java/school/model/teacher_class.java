/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.model;


public class teacher_class {
    String teacher_id;
    String class_id;
    String F_name;
    String L_name;
    int grade;
    String section;
    
    public teacher_class(String teacher_id, String class_id,String F_name, String L_name, int grade, String section) {
        this.teacher_id = teacher_id;
        this.class_id = class_id;
        this.F_name = F_name;
        this.L_name = L_name;
        this.grade = grade;
        this.section=section;
    }

    @Override
    public String toString() {
        return "teacher_class{" + "teacher_id=" + teacher_id + ", class_id=" + class_id + ", F_name=" + F_name + ", L_name=" + L_name + ", grade=" + grade + ", section=" + section + '}';
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
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
