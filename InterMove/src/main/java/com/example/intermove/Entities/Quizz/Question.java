package com.example.intermove.Entities.Quizz;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String text;
    private String type;
    private int score;
    private Boolean reponse;




}
