package com.example.smartcampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartcampus.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}

