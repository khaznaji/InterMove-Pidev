package com.example.intermove.Entities.CandidatesAndCourses;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  Integer idCandidacy;
    private String NameDoc;



}
