package ru.skillbox.webapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.skillbox.webapi.model.Category.Category;

public interface CategoruRepository extends JpaRepository<Category, UUID>{
    
}
