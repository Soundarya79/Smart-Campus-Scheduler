package com.example.smartcampus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartcampus.dto.TimetableRequest;
import com.example.smartcampus.entity.Schedule;
import com.example.smartcampus.service.TimetableService;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController {

    private final TimetableService service;

    public TimetableController(TimetableService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public List<Schedule> generate(@RequestBody TimetableRequest request) {
        return service.generateTimetable(request);
    }
}
