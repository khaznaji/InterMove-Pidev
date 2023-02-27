package com.example.intermove.Entities.CandidatesAndCourses;

import com.example.intermove.Entities.Offer.Offer;
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
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idTags;
    private String NameTag;

//    @ManyToMany(mappedBy = "tags")
//    @JsonIgnore
//    List<Courses> courses;
@OneToMany(mappedBy = "tags")
List<CourseTag> courseTags;

    @ManyToMany(mappedBy = "tags")
    List<Offer> offers;
}
