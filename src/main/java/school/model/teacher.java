/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.model;


public class teacher {
    String id;
    String F_name;
    String L_name;
    String address;
    String gender;
    String contact;
    String subject_id;
    String class_id;

    public teacher(String id,String F_name,String L_name, String address, String gender, String contact, String subject_id, String class_id) {
        this.id = id;
        this.F_name = F_name;
        this.L_name=L_name;
        this.address = address;
        this.gender = gender;
        this.contact = contact;
        this.subject_id = subject_id;
        this.class_id = class_id;
    }

    @Override
    public String toString() {
        return "teacher{" + "id=" + id + ", F_name=" + F_name +", L_name=" + L_name  + ", address=" + address + ", gender=" + gender + ", contact=" + contact + ", subject_id=" + subject_id + ", class_id=" + class_id + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String student_id) {
        this.subject_id = student_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }
    
   
}
