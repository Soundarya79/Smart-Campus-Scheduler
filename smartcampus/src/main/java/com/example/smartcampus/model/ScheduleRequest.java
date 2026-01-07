package com.example.smartcampus.model;

import java.util.List;
import java.util.Map;

public class ScheduleRequest {
    public List<Course> courses;
    public List<Room> rooms;
    public List<String> timeSlots;
    public Map<String, List<String>> conflicts;
}
