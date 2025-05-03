package ru.skillbox.webapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.skillbox.webapi.model.Category.Category;
import ru.skillbox.webapi.model.Category.CreateCategoryDto;
import ru.skillbox.webapi.model.Category.SearchCategoryDto;
import ru.skillbox.webapi.service.CategoryService;
import ru.skillbox.webapi.service.ICrudService;
@RestController
@RequestMapping("/category")
public class CategoryController extends AbstractCrudController<CreateCategoryDto, SearchCategoryDto, Category>{

    private final CategoryService categoryService;

    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    @Override
    protected ICrudService<CreateCategoryDto, SearchCategoryDto, Category> getCrudService() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCrudService'");
    }
    
}
