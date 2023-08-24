package com.example.application.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // SELECT * FROM student WHERE email = ?
    // @Query("SELECT s FROM Message s WHERE s.email = ?1") // this doesn't do anything, just explains the code
    // Optional<Message> getAllMessages(String email);
}
