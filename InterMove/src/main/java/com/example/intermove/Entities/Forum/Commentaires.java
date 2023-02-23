package com.example.intermove.Entities.Forum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.geometry.Pos;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Commentaires implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int commentID;
    private String comment;
    @Temporal(TemporalType.DATE)
    private Date created_at;
@ManyToOne
    @JsonIgnore
    private Post posts ;
}