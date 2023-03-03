package com.example.intermove.Entities.Quizz;

import javax.persistence.*;
import java.util.List;

import com.example.intermove.Entities.Domain;
import lombok.*;
import org.hibernate.type.StringType;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String nom;
    private String description ;
    @Enumerated(EnumType.STRING)
    private Domain domain;
    private int timelimit ;
    private int score ;
    @Enumerated(EnumType.STRING)
    private EtatQ etat;
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions;




}
