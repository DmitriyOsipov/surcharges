package com.surcharges.model;

import com.surcharges.service.IdGenerator;

import java.util.List;

/**
 * Created by mtzadmin on 10.05.2017.
 */
public class User {
    private String id;
    private String name;
    private String workPlace;
    private List<UserRole> roles;

    private IdGenerator idGenerator;

    public User(String name, String workPlace) {
        this.name = name;
        this.workPlace = workPlace;

        this.id = idGenerator.generateId();
    }

    public void addRole(UserRole role){
        if (!roles.contains(role)){
            roles.add(role);
        }
    }

    public void removeRole(UserRole role){
        roles.remove(role);
    }

    public enum UserRole{
        AUTHOR,
        EDITOR,
        REPORT_VIEWER,
        ADMIN;
    }
}
