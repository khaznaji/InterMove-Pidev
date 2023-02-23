package com.example.intermove.Entities.CandidatesAndCourses;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Candidacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idC ;
    private Integer idEtudiant ;
    private Integer idUniversite;
    private Date Delai;
    private String DepotDoc;
}
