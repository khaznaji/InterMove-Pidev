package com.example.intermove.Candidacy.Controller;

import com.example.intermove.Candidacy.Services.ICandidacyServices;
import com.example.intermove.Candidacy.Services.ICourseServices;
import com.example.intermove.Entities.CandidatesAndCourses.Candidacy;
import com.example.intermove.Entities.CandidatesAndCourses.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    ICourseServices courseServices;

    @PostMapping("/create")
    public ResponseEntity<Courses> addCourse(@RequestBody Courses courses) {
        Courses createdCourses = courseServices.addCourse(courses);
        System.out.println(courses);
        return new ResponseEntity<>(createdCourses, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public Iterable<Courses> listAllcourses() {
        return courseServices.listAllcourses();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Courses> updateCourse( @RequestBody Courses courses,@PathVariable Integer id) {
        Courses updateCourse = courseServices.updateCourse(courses, id);
        return new ResponseEntity<>(updateCourse, HttpStatus.OK);

    }
}
