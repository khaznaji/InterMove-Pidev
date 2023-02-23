package com.example.intermove.Entities.Forum;

import com.example.intermove.Entities.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int postID;
    private String title;
    private String postdescription;
    private String postimage;
    private int nbrLIKE;
    @Temporal(TemporalType.DATE)
    private Date created_at;
 @ManyToOne
 @JsonIgnore
 private User user;
@OneToMany(mappedBy = "posts")
    @JsonIgnore
   List<Comment> commentaires;

}
