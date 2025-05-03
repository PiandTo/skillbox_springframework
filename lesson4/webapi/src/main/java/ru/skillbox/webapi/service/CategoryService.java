package ru.skillbox.webapi.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ru.skillbox.webapi.model.Category.Category;
import ru.skillbox.webapi.model.Category.CreateCategoryDto;
import ru.skillbox.webapi.model.Category.SearchCategoryDto;
import ru.skillbox.webapi.repository.CategoryRepository;

@Service
public class CategoryService extends AbstractCrudService<CreateCategoryDto, SearchCategoryDto, Category> {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<Category, UUID> getRepository() {
        return this.categoryRepository;
    }

    @Override
    protected Category mapToEntity(CreateCategoryDto s) {
        return mapper.map(s, Category.class);
    }

    @Override
    protected SearchCategoryDto mapToSearch(Category e) {
        return mapper.map(e, SearchCategoryDto.class);
    }
    
}
