package com.example.intermove.Repositories.User;

import com.example.intermove.Entities.EventsAndComplaints.Claim;
import com.example.intermove.Entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

}
