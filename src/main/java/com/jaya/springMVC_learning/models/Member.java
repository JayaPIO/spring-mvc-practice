package com.jaya.springMVC_learning.models;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;
    @Column(name = "user_name")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    public Member() {
    }

    public Member(int memberId, String username, String password, String role) {
        this.memberId=memberId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Member(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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
