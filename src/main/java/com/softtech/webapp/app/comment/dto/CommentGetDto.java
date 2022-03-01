package com.softtech.webapp.app.comment.dto;

import lombok.Data;

@Data
public class CommentGetDto {
    private Long id;
    private String commentText;
    private Long userId;
    private Long productId;
}
