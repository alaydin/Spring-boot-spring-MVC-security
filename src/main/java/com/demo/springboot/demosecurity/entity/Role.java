package com.demo.springboot.demosecurity.entity;

import jakarta.persistence.*;

@Entity(name = "roles")
public class Role {
    @Id
    @Column(name = "user_id")
    private String user_id;
    private String role;

    // Getters and setters
    // Constructors
    // Other methods if needed

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private Member member;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
