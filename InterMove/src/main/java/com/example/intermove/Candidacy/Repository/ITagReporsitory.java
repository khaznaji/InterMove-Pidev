package com.example.intermove.Candidacy.Repository;

import com.example.intermove.Entities.CandidatesAndCourses.Courses;
import com.example.intermove.Entities.CandidatesAndCourses.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITagReporsitory extends JpaRepository<Tags,Integer> {

}
