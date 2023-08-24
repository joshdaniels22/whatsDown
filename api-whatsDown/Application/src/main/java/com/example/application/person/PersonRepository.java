package com.example.application.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    // SELECT * FROM student WHERE email = ?
    @Query("SELECT s FROM Person s WHERE s.email = ?1") // this doesn't do anything, just explains the code
    Optional<Person> findPersonByEmail(String email);
}
