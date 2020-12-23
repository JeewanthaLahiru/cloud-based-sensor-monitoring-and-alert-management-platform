package com.monitor.monitorapp;

public class User {
    private String name;
    private String password;
    private String email;
    private String phone;
    private String notification;

    public User( String name, String email, String password, String phone,String notification) {
        this.name = name;
        this.password=password;
        this.phone = phone;
        this.email=email;
        this.notification=notification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
