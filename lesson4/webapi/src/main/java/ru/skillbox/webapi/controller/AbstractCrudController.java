package ru.skillbox.webapi.controller;

import org.springframework.web.bind.annotation.RestController;

import ru.skillbox.webapi.service.ICrudService;

public abstract class AbstractCrudController<CreateDto, SearchDto, Entity>
        implements ICrudController<CreateDto, SearchDto, Entity> {

    protected abstract ICrudService<CreateDto, SearchDto, Entity> getCrudService();

    @Override
    public SearchDto create(CreateDto s) {
        return getCrudService().create(s);
    }

    @Override
    public SearchDto read(String id) {
        return getCrudService().read(id);
    }

    @Override
    public SearchDto update(String id, CreateDto s) {
        return getCrudService().update(id, s);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
