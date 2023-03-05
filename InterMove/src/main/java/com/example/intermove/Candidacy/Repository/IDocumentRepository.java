package com.example.intermove.Candidacy.Repository;

import com.example.intermove.Entities.CandidatesAndCourses.Courses;
import com.example.intermove.Entities.CandidatesAndCourses.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentRepository extends JpaRepository<Document, Integer> {
}
