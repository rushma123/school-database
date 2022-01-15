/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.model;


public class teacher_subject {
    String teacher_id;
    String subject_id;
    String F_name;
    String L_name;
    String subject_name;

    public teacher_subject(String teacher_id, String subject_id, String F_name, String L_name, String subject_name) {
        this.teacher_id = teacher_id;
        this.subject_id = subject_id;
        this.F_name = F_name;
        this.L_name = L_name;
        this.subject_name = subject_name;
    }

    @Override
    public String toString() {
        return "teacher_subject{" + "teacher_id=" + teacher_id + ", subject_id=" + subject_id + ", F_name=" + F_name + ", L_name=" + L_name + ", subject_name=" + subject_name + '}';
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
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

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
    
   
}
