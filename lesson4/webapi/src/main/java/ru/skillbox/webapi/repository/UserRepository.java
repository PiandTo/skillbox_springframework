package ru.skillbox.webapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.skillbox.webapi.model.User.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
}
