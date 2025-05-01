package ru.skillbox.webapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICrudController<CreateDto, SearchDto, Entity> {
    @PostMapping
    SearchDto create (@RequestBody CreateDto s);

    @GetMapping("/{id}")
    SearchDto read (@PathVariable String id);

    @PutMapping("/{id}")
    SearchDto update (@PathVariable String id, @RequestBody CreateDto s);

    @DeleteMapping("/{id}")
    void delete (@PathVariable String id);
}
