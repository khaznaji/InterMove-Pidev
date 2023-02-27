package com.example.intermove.Candidacy.Services;


import com.example.intermove.Candidacy.Repository.ICourseRepository;
import com.example.intermove.Entities.CandidatesAndCourses.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CourseServices implements ICourseServices{
    @Autowired
    ICourseRepository courseRepository;


    @Override
    public Courses addCourse(Courses courses) {
        return courseRepository.save(courses);
    }

    @Override
    public Iterable<Courses> listAllcourses() {
        return courseRepository.findAll();
    }

    @Override
    public Iterable<Courses> listcoursesbydomain(String domain) {
        return courseRepository.findALLByDomainCourse(domain);
    }

    @Override
    public Courses getCourseById(Integer id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Courses updateCourse(Courses courses, Integer idC) {

        if (Objects.nonNull(courses.getName()) ) {
            courses.setName(courses.getName());
        }
        if (Objects.nonNull(courses.getDomainCourse()) ) {
            courses.setDomainCourse(courses.getDomainCourse());
        }
        return courseRepository.save(courses);
    }

    @Override
    public void deleteCourse(Integer id) {
    courseRepository.deleteById(id);
    }


}
