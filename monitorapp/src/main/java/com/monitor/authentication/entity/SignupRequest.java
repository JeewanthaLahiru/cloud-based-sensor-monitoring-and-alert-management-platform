package com.monitor.authentication.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection ="user" )
public class SignupRequest {

    @Id
    private String id;

    private String email;
    private String password;
    private String number;
    private String notificationMethod;
    private String name;

    public String getName() {
        return name;
    }
}
