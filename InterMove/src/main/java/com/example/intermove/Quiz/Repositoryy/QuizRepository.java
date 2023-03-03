package com.example.intermove.Quiz.Repositoryy;

import com.example.intermove.Entities.Domain;
import com.example.intermove.Entities.Quizz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {
    List<Quiz> findAllByDomain(Domain domain);
}
