package com.example.smartcampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartcampus.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
