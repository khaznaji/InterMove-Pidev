package com.example.intermove.Entities.Offer;

import com.example.intermove.Entities.Domain;

import javax.persistence.*;
import java.util.Date;

public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String title;
    private String description;
    private Date dateD;
    private Date dateF;
    @Enumerated(EnumType.STRING)
    private Domain domain;

}
