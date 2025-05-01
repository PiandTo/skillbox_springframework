package ru.skillbox.webapi.service;


public interface ICrudService<S, O, E> {
    O create(S s);
    O read(String id);
    O update(String id, S s);
    void delete(String id);
}
