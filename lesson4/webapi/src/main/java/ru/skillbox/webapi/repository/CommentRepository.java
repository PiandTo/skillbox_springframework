package ru.skillbox.webapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.skillbox.webapi.model.Comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID>{
    
}
