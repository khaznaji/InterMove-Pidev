package com.example.intermove.Candidacy.Repository;

import com.example.intermove.Entities.CandidatesAndCourses.Candidacy;
import com.example.intermove.Entities.CandidatesAndCourses.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ICondidacyRepository extends JpaRepository<Candidacy, Integer> {
}
