package com.example.projekt.repository;

import com.example.projekt.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    public Optional<User> findByUsername(String username);
}