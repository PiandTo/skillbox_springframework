package ru.skillbox.webapi.service;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.skillbox.webapi.model.IModel;

public abstract class AbstractCrudService<S, O, E extends IModel> implements ICrudService<S, O, E> {

    @Override
    public O create(S s) {
        return mapToSearch(getRepository().save(mapToEntity(s)));
    }

    @Override
    public O read(String id) {
        return mapToSearch(getRepository().findById(UUID.fromString(id)).orElseThrow());
    }

    @Override
    public O update(String id, S s) {
        E e = getRepository().findById(UUID.fromString(id)).get();
        if (e == null)
            return null;
        E newE = mapToEntity(s);
        newE.setId(e.getId());
        return mapToSearch(getRepository().save(newE));
    }

    @Override
    public void delete(String id) {
        E e = getRepository().getReferenceById(UUID.fromString(id));
        getRepository().delete(e);
    }

    protected abstract JpaRepository<E, UUID> getRepository();

    protected abstract E mapToEntity(S s);

    protected abstract O mapToSearch(E e);
}
