package com.example.intermove.Entities.User;

import com.example.intermove.Entities.EventsAndComplaints.Claim;
import com.example.intermove.Entities.EventsAndComplaints.Events;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String mail ;
    private String pass ;
    private String nom ;
    private String prenom ;
    private String region ;
    private String tel ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    @JsonIgnore
    public List<Claim> complaints ;






    @ManyToMany
    public List<Events> events;

    public void setEvents(List<Events> events) {
        this.events = events;
    }
    public List<Events> getEvents() {
        return events;
    }
}
