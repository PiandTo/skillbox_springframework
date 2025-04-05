package ru.skillbox.webapi.model;

import jakarta.persistence.Entity;

@Entity
public class User extends AbstractEntity {
	private String name;
}
