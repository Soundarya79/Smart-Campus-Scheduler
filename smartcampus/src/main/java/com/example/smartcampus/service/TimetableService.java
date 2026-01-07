package com.example.smartcampus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.smartcampus.entity.Faculty;
import com.example.smartcampus.entity.Room;
import com.example.smartcampus.entity.Schedule;
import com.example.smartcampus.entity.TimeSlot;
import com.example.smartcampus.repository.FacultyRepository;
import com.example.smartcampus.repository.RoomRepository;
import com.example.smartcampus.repository.ScheduleRepository;
import com.example.smartcampus.repository.TimeSlotRepository;

@Service
public class TimetableService {

    private final ScheduleRepository scheduleRepo;
    private final FacultyRepository facultyRepo;
    private final RoomRepository roomRepo;
    private final TimeSlotRepository timeSlotRepo;

    public TimetableService(
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

    public void generateTimetable(String section) {

        List<Faculty> faculties = facultyRepo.findAll();
        List<Room> rooms = roomRepo.findAll();
        List<TimeSlot> slots = timeSlotRepo.findAll();

        int facultyIndex = 0;
        int roomIndex = 0;

        for (TimeSlot slot : slots) {

            Faculty faculty = faculties.get(facultyIndex % faculties.size());
            Room room = rooms.get(roomIndex % rooms.size());

            Schedule schedule = new Schedule();
            schedule.setSection(section);
            schedule.setSubject(faculty.getSubject());
            schedule.setFaculty(faculty);
            schedule.setRoom(room);
            schedule.setTimeSlot(slot);

            scheduleRepo.save(schedule);

            facultyIndex++;
            roomIndex++;
        }
    }
}
