package com.example.smartcampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartcampus.entity.TimeSlot;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
}
