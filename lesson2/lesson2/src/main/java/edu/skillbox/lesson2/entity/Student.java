package edu.skillbox.lesson2.entity;

import java.util.UUID;

import lombok.Data;

@Data
public class Student {
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private Integer age;

    public String toString() {
        return "ID: " + this.getId() + " | Name: " + this.firstName + " | Last name: " + this.lastName + " | Age: " + this.age + ".";
    }
}
