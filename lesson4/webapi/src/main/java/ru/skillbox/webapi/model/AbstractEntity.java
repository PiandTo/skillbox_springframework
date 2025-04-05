package ru.skillbox.webapi.model;

import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
	@Id
	private UUID id;
}
