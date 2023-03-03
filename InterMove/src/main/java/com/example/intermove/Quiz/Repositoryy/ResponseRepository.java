package com.example.intermove.Quiz.Repositoryy;

import com.example.intermove.Entities.Quizz.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Response,Integer> {
}
