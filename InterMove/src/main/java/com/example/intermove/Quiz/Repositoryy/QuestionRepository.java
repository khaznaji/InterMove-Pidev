package com.example.intermove.Quiz.Repositoryy;


import com.example.intermove.Entities.Quizz.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
