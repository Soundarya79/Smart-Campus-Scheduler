package com.example.smartcampus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String subject;   // ✅ REQUIRED

    // getters & setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {     // ✅ REQUIRED
        return subject;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {   // ✅ REQUIRED
        this.subject = subject;
    }
}
