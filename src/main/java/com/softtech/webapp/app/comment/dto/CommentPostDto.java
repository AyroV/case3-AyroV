package com.softtech.webapp.app.comment.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CommentPostDto {
    @NotNull(message = "Comment cannot be null")
    @NotBlank(message = "Comment cannot be blank")
    private String commentText;
    @NotNull(message = "User Id cannot be null")
    private Long userId;
    @NotNull(message = "Product Id cannot be null")
    private Long productId;
}
