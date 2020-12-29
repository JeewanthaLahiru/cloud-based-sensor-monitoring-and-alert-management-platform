package com.monitor.authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users_login")
public class User {
    @Id
    private String id;

    private String name;
    private String password;
    private String email;
    private String number;
    private String notificationMethod;

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getNotificationMethod() {
        return notificationMethod;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
