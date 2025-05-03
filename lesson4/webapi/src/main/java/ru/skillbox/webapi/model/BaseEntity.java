package ru.skillbox.webapi.model;

import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity extends IModel {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Override
	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public UUID getId() {
		return this.id;
	}
}
