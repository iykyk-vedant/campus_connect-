
package com.campusconnect.campusconnect.model;

import jakarta.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;        // e.g., "CS101"
    private String title;       // e.g., "Introduction to Computer Science"
    private Integer credits;    // e.g., 3

    // Relations (optional): you can add ManyToOne to Faculty, ManyToMany to Student later

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getCredits() { return credits; }
    public void setCredits(Integer credits) { this.credits = credits; }
}
