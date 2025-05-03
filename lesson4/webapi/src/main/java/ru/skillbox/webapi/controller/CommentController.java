package ru.skillbox.webapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import ru.skillbox.webapi.model.Comment.Comment;
import ru.skillbox.webapi.model.Comment.CreateCommentDto;
import ru.skillbox.webapi.model.Comment.SearchCommentDto;
import ru.skillbox.webapi.service.CommentService;
import ru.skillbox.webapi.service.ICrudService;

@RequestMapping("/comments")
public class CommentController extends AbstractCrudController<CreateCommentDto, SearchCommentDto, Comment> {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    protected ICrudService<CreateCommentDto, SearchCommentDto, Comment> getCrudService() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCrudService'");
    }
    
}
