package com.example.smartcampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.smartcampus.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
