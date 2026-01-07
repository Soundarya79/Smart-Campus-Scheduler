package com.example.smartcampus.service;

import com.example.smartcampus.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SchedulerService {

    private Map<String, String> schedule;
    private Map<String, Set<String>> roomAvailability;
    private Map<String, List<String>> conflictGraph;

    public Map<String, String> generateSchedule(ScheduleRequest req) {

        schedule = new HashMap<>();
        conflictGraph = req.conflicts;
        roomAvailability = new HashMap<>();

        for (Room room : req.rooms) {
            roomAvailability.put(room.roomId, new HashSet<>(req.timeSlots));
        }

        // Greedy heuristic: sort by student count
        req.courses.sort((a, b) -> b.studentCount - a.studentCount);

        boolean success = backtrack(req.courses, 0, req.rooms, req.timeSlots);

        if (!success) {
            throw new RuntimeException("No valid schedule possible");
        }

        return schedule;
    }

    private boolean backtrack(List<Course> courses, int index,
                              List<Room> rooms, List<String> slots) {

        if (index == courses.size()) {
            return true;
        }

        Course course = courses.get(index);

        for (String slot : slots) {

            if (hasConflict(course.courseId, slot)) continue;

            for (Room room : rooms) {

                if (room.capacity >= course.studentCount &&
                        roomAvailability.get(room.roomId).contains(slot)) {

                    // choose
                    schedule.put(course.courseId, room.roomId + " @ " + slot);
                    roomAvailability.get(room.roomId).remove(slot);

                    // explore
                    if (backtrack(courses, index + 1, rooms, slots)) {
                        return true;
                    }

                    // un-choose (backtrack)
                    schedule.remove(course.courseId);
                    roomAvailability.get(room.roomId).add(slot);
                }
            }
        }
        return false;
    }

    private boolean hasConflict(String courseId, String slot) {

        if (!conflictGraph.containsKey(courseId)) return false;

        for (String conflict : conflictGraph.get(courseId)) {
            if (schedule.containsKey(conflict) &&
                schedule.get(conflict).contains(slot)) {
                return true;
            }
        }
        return false;
    }
}
