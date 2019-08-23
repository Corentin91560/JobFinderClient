package com.example.rh.models;

public class User {
    int idUser;
    String name;
    String firstname;
    String email;
    String password;
    String phone;

    public User(int idUser,String name, String firstname, String email, String password, String phone) {
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    public User(String name, String firstname, String email, String password, String phone) {
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
