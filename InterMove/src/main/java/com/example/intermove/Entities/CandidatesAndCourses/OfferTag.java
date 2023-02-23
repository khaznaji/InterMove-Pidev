package com.example.intermove.Entities.CandidatesAndCourses;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OfferTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idO;
    private Integer idT;


}
