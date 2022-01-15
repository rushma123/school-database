/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.model;

public class student {
    String student_id;
    String F_name;
    String L_name;
    String gender;
    String DOB;
    String address;
    String contact_number;
    String class_id;

    public student(String student_id, String F_name,String L_name, String gender, String DOB, String address, String contact_number, String class_id) {
        this.student_id = student_id;
        this.F_name = F_name;
        this.L_name=L_name;
        this.gender = gender;
        this.DOB = DOB;
        this.address = address;
        this.contact_number = contact_number;
        this.class_id = class_id;
    }

    @Override
    public String toString() {
        return "student{" + "student_id=" + student_id + ", F_name=" + F_name +", L_name=" + L_name +", gender=" + gender + ", DOB=" + DOB + ", address=" + address + ", contact_number=" + contact_number + ", class_id=" + class_id + '}';
    }
    
    

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

   

   
}
