package com.myserieslist.serieslist.Repository;

import java.util.Optional;

import com.myserieslist.serieslist.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findUserByEmail(String email);

    User findBySurname(String surname);
}