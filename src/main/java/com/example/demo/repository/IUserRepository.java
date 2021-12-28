package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username = :username and u.deleteAt is null ")
    User findUserExistByUsername(@Param("username") String username);
}
