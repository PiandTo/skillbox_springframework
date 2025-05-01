package ru.skillbox.webapi.model;

import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
public class BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
}
