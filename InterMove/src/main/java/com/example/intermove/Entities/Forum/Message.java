package com.example.intermove.Entities.Forum;

import com.example.intermove.Entities.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Message {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int messageID ;
    private String content;
    @Temporal(TemporalType.DATE)
    private Date sent_at;
    @ManyToOne
    @JsonIgnore
    private User user;
}
