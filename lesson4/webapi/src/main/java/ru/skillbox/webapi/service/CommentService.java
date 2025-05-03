package ru.skillbox.webapi.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ru.skillbox.webapi.model.Comment.Comment;
import ru.skillbox.webapi.model.Comment.CreateCommentDto;
import ru.skillbox.webapi.model.Comment.SearchCommentDto;
import ru.skillbox.webapi.repository.CommentRepository;

@Service
public class CommentService extends AbstractCrudService<CreateCommentDto, SearchCommentDto, Comment> {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public CommentService(CommentRepository commentRepository, ModelMapper mapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = mapper;
    }

    @Override
    protected JpaRepository<Comment, UUID> getRepository() {
        return this.commentRepository;
    }

    @Override
    protected Comment mapToEntity(CreateCommentDto s) {
        return modelMapper.map(s, Comment.class);
    }

    @Override
    protected SearchCommentDto mapToSearch(Comment e) {
        return modelMapper.map(e, SearchCommentDto.class);
    }
    
}
