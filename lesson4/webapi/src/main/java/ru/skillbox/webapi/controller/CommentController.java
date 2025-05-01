package ru.skillbox.webapi.controller;

import org.hibernate.grammars.hql.HqlParser.SearchClauseContext;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.skillbox.webapi.model.Comment.Comment;
import ru.skillbox.webapi.model.Comment.CommentDto;
import ru.skillbox.webapi.model.Comment.SearchCommentDto;
import ru.skillbox.webapi.service.ICrudService;

@RequestMapping("/comments")
public class CommentController extends AbstractCrudController<CommentDto, SearchCommentDto, Comment> {

    @Override
    protected ICrudService<CommentDto, SearchCommentDto, Comment> getCrudService() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCrudService'");
    }
    
}
