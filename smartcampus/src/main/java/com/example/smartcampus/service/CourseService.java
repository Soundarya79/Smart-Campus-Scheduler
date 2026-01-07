package com.example.smartcampus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.smartcampus.entity.Course;
import com.example.smartcampus.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Save a new course
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
}
