package com.example.intermove.Candidacy.Services;

import com.example.intermove.Entities.CandidatesAndCourses.Courses;

public interface ICourseServices {
    Courses addCourse(Courses courses);
    Iterable<Courses> listAllcourses();


    Courses getCourseById(Integer id);
    Courses updateCourse(Courses courses , Integer idC);
    void deleteCourse(Integer id);
}
