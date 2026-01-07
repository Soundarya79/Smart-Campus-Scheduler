package com.example.smartcampus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartcampus.entity.Faculty;
import com.example.smartcampus.entity.Room;
import com.example.smartcampus.entity.Schedule;
import com.example.smartcampus.entity.TimeSlot;
import com.example.smartcampus.repository.FacultyRepository;
import com.example.smartcampus.repository.RoomRepository;
import com.example.smartcampus.repository.ScheduleRepository;
import com.example.smartcampus.repository.TimeSlotRepository;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final ScheduleRepository scheduleRepo;
    private final FacultyRepository facultyRepo;
    private final RoomRepository roomRepo;
    private final TimeSlotRepository timeSlotRepo;

    public ScheduleController(
            ScheduleRepository scheduleRepo,
            FacultyRepository facultyRepo,
            RoomRepository roomRepo,
            TimeSlotRepository timeSlotRepo
    ) {
        this.scheduleRepo = scheduleRepo;
        this.facultyRepo = facultyRepo;
        this.roomRepo = roomRepo;
        this.timeSlotRepo = timeSlotRepo;
    }

    // CREATE schedule
    @PostMapping("/create")
    public Schedule createSchedule(
            @RequestParam String section,
            @RequestParam String subject,
            @RequestParam Long facultyId,
            @RequestParam Long roomId,
            @RequestParam Long timeSlotId
    ) {
        Faculty faculty = facultyRepo.findById(facultyId).orElseThrow();
        Room room = roomRepo.findById(roomId).orElseThrow();
        TimeSlot timeSlot = timeSlotRepo.findById(timeSlotId).orElseThrow();

        Schedule schedule = new Schedule();
        schedule.setSection(section);
        schedule.setSubject(subject);
        schedule.setFaculty(faculty);
        schedule.setRoom(room);
        schedule.setTimeSlot(timeSlot);

        return scheduleRepo.save(schedule);
    }

    // VIEW timetable
    @GetMapping("/all")
    public List<Schedule> getAllSchedules() {
        return scheduleRepo.findAll();
    }
}
