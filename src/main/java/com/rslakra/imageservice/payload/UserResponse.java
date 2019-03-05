package com.rslakra.imageservice.payload;


import com.rslakra.imageservice.domain.Role;

import javax.persistence.GenerationType;
import java.util.Date;

/**
 * The User Response.
 */
public class UserResponse {

    private int id;
    private String userName;
    private Role role;

    public UserResponse(int id, String userName, Role role) {
        this.id = id;
        this.userName = userName;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
