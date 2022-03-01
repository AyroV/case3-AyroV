package com.softtech.webapp.app.comment.controller;

import com.softtech.webapp.app.comment.dto.CommentGetDto;
import com.softtech.webapp.app.comment.dto.CommentPostDto;
import com.softtech.webapp.app.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(required = false) Long userId, @RequestParam(required = false) Long productId) {
        List<CommentGetDto> commentGetDtoList = commentService.findAll();
        return ResponseEntity.ok().body(commentGetDtoList);
    }

    @GetMapping("/user-comments/{userId}")
    public ResponseEntity<?> findAllByUserId(@PathVariable Long userId) {
        List<CommentGetDto> commentGetDtoList = commentService.findAllByUserId(userId);
        return ResponseEntity.ok().body(commentGetDtoList);
    }

    @GetMapping("/product-comments/{productId}")
    public ResponseEntity<?> findAllByProductId(@PathVariable Long productId) {
        List<CommentGetDto> commentGetDtoList = commentService.findAllByProductId(productId);
        return ResponseEntity.ok().body(commentGetDtoList);
    }

    @PostMapping
    public ResponseEntity<?> save(CommentPostDto commentPostDto) {
        CommentGetDto commentGetDto = commentService.save(commentPostDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentGetDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
