package com.jaya.springMVC_learning.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @Column(name = "user_name")
    private String username;
    @Column(name = "passcode")
    private String password;
    @Column(name = "role")
    private String role;

    public Member() {
    }

    public Member(Integer id, String username, String password, String role) {

        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Member(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
