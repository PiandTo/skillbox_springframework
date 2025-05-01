package ru.skillbox.webapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.skillbox.webapi.model.New.News;

public interface NewsRepository extends JpaRepository<News, UUID> {
    
}
