package com.example.smartcampus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String section;   // ✅ REQUIRED
    private String subject;   // ✅ REQUIRED

    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private Room room;

    @ManyToOne
    private TimeSlot timeSlot;

    // getters & setters
    public Long getId() {
        return id;
    }

    public String getSection() {
        return section;
    }

    public String getSubject() {
        return subject;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Room getRoom() {
        return room;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSection(String section) {   // ✅ REQUIRED
        this.section = section;
    }

    public void setSubject(String subject) {   // ✅ REQUIRED
        this.subject = subject;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
}
