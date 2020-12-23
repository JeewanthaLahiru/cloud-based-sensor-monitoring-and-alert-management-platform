package com.monitor.monitorapp;

public interface UserRepository {
    User getUser(String id);

    void addUser(User user);
}
