package org.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    /*Todo Native SQL
       @Query(value = "select * from users where email = :email", nativeQuery = true)
       User findByEmail(String email);*/

    @Query
    Optional<Student> findByLogin(String login);
}
