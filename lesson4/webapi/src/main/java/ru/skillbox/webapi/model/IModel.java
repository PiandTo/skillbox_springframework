package ru.skillbox.webapi.model;

import java.util.UUID;

public abstract class IModel {
	public abstract UUID getId();

	public abstract void setId(UUID id);
}
