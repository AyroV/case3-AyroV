package com.softtech.webapp.app.comment.service;

import com.softtech.webapp.app.comment.dto.CommentGetDto;
import com.softtech.webapp.app.comment.dto.CommentPostDto;
import com.softtech.webapp.app.comment.entity.Comment;
import com.softtech.webapp.app.comment.enums.CommentErrorMessage;
import com.softtech.webapp.app.gen.exceptions.ItemNotFoundException;
import com.softtech.webapp.app.product.service.ProductEntityService;
import com.softtech.webapp.app.user.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentEntityService commentEntityService;
    private final UserEntityService userEntityService;
    private final ProductEntityService productEntityService;
    private final ModelMapper mapper;

    public List<CommentGetDto> findAll() {
        List<Comment> commentList = commentEntityService.findAll();
        List<CommentGetDto> commentGetDtoList = commentList.stream().map(comment -> mapper.map(comment, CommentGetDto.class)).collect(Collectors.toList());
        return commentGetDtoList;
    }

    public List<CommentGetDto> findAllByUserId(Long userId) {
        userEntityService.getByIdWithControl(userId);
        List<Comment> commentList = commentEntityService.findAllByUserId(userId);
        if(commentList.size() == 0)
            throw new ItemNotFoundException(CommentErrorMessage.NO_USER_COMMENT);
        List<CommentGetDto> commentGetDtoList = commentList.stream().map(comment -> mapper.map(comment, CommentGetDto.class)).collect(Collectors.toList());
        return commentGetDtoList;
    }

    public List<CommentGetDto> findAllByProductId(Long productId) {
        productEntityService.getByIdWithControl(productId);
        List<Comment> commentList = commentEntityService.findAllByProductId(productId);
        if(commentList.size() == 0)
            throw new ItemNotFoundException(CommentErrorMessage.NO_PRODUCT_COMMENT);
        List<CommentGetDto> commentGetDtoList = commentList.stream().map(comment -> mapper.map(comment, CommentGetDto.class)).collect(Collectors.toList());
        return commentGetDtoList;
    }

    public CommentGetDto save(CommentPostDto commentPostDto) {
        userEntityService.getByIdWithControl(commentPostDto.getUserId());
        productEntityService.getByIdWithControl(commentPostDto.getProductId());

        Comment comment = new Comment();
        comment.setCommentText(commentPostDto.getCommentText());
        comment.setUserId(commentPostDto.getUserId());
        comment.setProductId(commentPostDto.getProductId());
        comment = commentEntityService.save(comment, false);
        return mapper.map(comment, CommentGetDto.class);
    }

    public void delete(Long id) {
        Comment comment = commentEntityService.getByIdWithControl(id);
        commentEntityService.delete(comment);
    }
}
