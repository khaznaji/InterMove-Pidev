package com.example.intermove.Entities.EventsAndComplaints;

import com.example.intermove.Entities.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String title;
    private String description;
    private Date dateD;
    private Date dateF;
    private Integer nbreDePlaces;
    private String image;
    private String Speaker;
    @Enumerated(EnumType.STRING)
    private TypeEvent typeEvent;
    @Enumerated(EnumType.STRING)
    private ModaliteEvent modaliteEvent;
    @OneToMany(mappedBy="events")
    @JsonIgnore
    private Set<User> user;


}
