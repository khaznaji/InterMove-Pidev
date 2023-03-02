package com.example.intermove.Entities.CandidatesAndCourses;

import com.example.intermove.Entities.Offer.Offer;
import com.example.intermove.Entities.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Candidacy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idC ;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @CreationTimestamp
    private Date dateCandidacy;

    @Enumerated(EnumType.STRING)
    private CandidacyStatus status = CandidacyStatus.Poor;


    public Candidacy(Integer idC, String firstName, String lastName, String email, String phoneNumber, Date dateCandidacy, CandidacyStatus status, Offer offer) {
        this.idC = idC;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateCandidacy = dateCandidacy;
        this.status = status;
        this.offer = offer;
    }

    //    @ManyToOne
//    @JsonIgnore
//    Offer offer;
    @ManyToOne(fetch = FetchType.EAGER)
    //@JsonIgnore
    @JoinColumn(name = "idoffre")
    private Offer offer;
    //(fetch = FetchType.LAZY)
    //@JoinColumn(name = "offer_id")


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private User user;
            //(fetch = FetchType.LAZY)
    //@JoinColumn(name = "student_id")


    @OneToMany(mappedBy = "candidacy",cascade = CascadeType.ALL)
    List<Document> documents;

}
