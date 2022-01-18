package com.example.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository repository;
    ArrayList<Course> courses = new ArrayList<>();

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findCourseByid(Integer.parseInt(id)));
    }

    @PostMapping("/course")
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
        repository.save(course);
        return ResponseEntity.status(HttpStatus.OK).body("Course added");
    }
}
