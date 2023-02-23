package com.example.intermove.Entities.Accomodation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Enumerated(EnumType.STRING)
    private TypeHouses TypeHouses;
    private String adress;
    private Boolean available;
    private Integer nbrOfRooms;

    @ManyToOne
    @JsonIgnore
    public Agency agency;


}
