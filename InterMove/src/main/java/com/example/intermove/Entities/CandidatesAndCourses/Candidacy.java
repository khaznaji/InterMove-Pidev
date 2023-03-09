package com.example.intermove.Entities.CandidatesAndCourses;

import com.example.intermove.Entities.Offer.Offer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Candidacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idC ;
    private Integer idEtudiant ;
    private Integer idUniversite;
    private Date Delai;
    private String DepotDoc;


    @ManyToOne
    @JsonIgnore
    Offer offer;

    @OneToMany(mappedBy = "candidacy")
    List<Document> documents;

}
