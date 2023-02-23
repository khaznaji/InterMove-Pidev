package com.example.intermove.Forum.Repositoryy;

import com.example.intermove.Entities.Forum.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}


