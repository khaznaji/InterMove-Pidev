package com.example.intermove.Entities.Accomodation;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
@Entity
public class Houses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Enumerated(EnumType.STRING)
    private com.example.intermove.Entities.Accomodation.TypeHouses TypeHouses;
    private String adress;
    private Boolean available;
    private Integer nbrOfRooms;

    @ManyToOne
    @JsonIgnore
    public Agency agency;


}
