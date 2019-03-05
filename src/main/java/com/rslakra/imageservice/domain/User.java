package com.rslakra.imageservice.domain;

import com.rslakra.imageservice.utils.Utils;

import javax.persistence.*;
import java.security.MessageDigest;

/**
 * Author: Rohtash Singh Lakra
 * Created: 2019-03-05 10:19
 */
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private Role role;

    public User() {

    }


    public User(String userName, String password, Role role) {
        this.userName = userName;
        setPassword(password);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null)
            this.password = Utils.toSHA256(password);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
