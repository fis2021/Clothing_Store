package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class User {
   /* @Id
    private String username;
    private String password;
   // private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
       // this.role = role;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   // public String getRole() {
    //    return role;
   // }

    //public void setRole(String role) {
        //this.role = role;
    //}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        return password != null ? !password.equals(user.password) : user.password != null;

        //return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        //result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }*/

   @Id
   private String username;
    private String password;
    private String passwordconfirm;
    private String firstname;
    private String secondname;
    private String phonenumber;
    private String address;
    private String email;
    private String role;

    public User(String username, String password,String passwordconfirm, String firstname,String secondname,String phonenumber,String address,String email,String role) {
        this.username = username;
        this.password = password;
        this.passwordconfirm = passwordconfirm;
        this.firstname = firstname;
        this.secondname = secondname;
        this.phonenumber = phonenumber;
        this.address = address;
        this.email = email;
        this.role = role;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordconfirm() {
        return passwordconfirm;
    }

    public void setPasswordconfirm(String passwordconfirm) {
        this.passwordconfirm = passwordconfirm;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) { this.secondname = secondname; }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole(){return role;}

    public void setRole(String role){ this.role = role;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

       // if (username != null ? !username.equals(user.username) : user.username != null) return false;
       // if (password != null ? !password.equals(user.password) : user.password != null) return false;
        //return role != null ? role.equals(user.role) : user.role == null;

        if (!Objects.equals(username, user.username)) return false;
        if (!Objects.equals(password, user.password)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
