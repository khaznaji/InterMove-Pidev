package com.example.intermove.Entities.User;

import com.example.intermove.Entities.EventsAndComplaints.Claim;
import com.example.intermove.Entities.EventsAndComplaints.Events;
import com.example.intermove.Entities.Forum.Message;
import com.example.intermove.Entities.Forum.Post;
import com.example.intermove.Entities.Offer.Offer;
import com.example.intermove.Entities.Quizz.Response;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class User implements Serializable {
    public User(int userid) {
        this.userid = userid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    private int cin;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int phone;
    private String address;
    @Nullable
    private String profilepicture;

    @ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    @JsonIgnore
    private Set<Role> roles;





    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    @JsonIgnore
    public List<Claim> complaints ;
    @ManyToOne
    @JsonIgnore
    private Events events;
    @ManyToOne
    @JsonIgnore
    private Offer offers;
    @OneToMany (mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Response> responseList;
    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> posts;
    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Message> messages;








}
