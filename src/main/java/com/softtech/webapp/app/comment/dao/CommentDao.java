package com.softtech.webapp.app.comment.dao;

import com.softtech.webapp.app.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {
    List<Comment> findAllByUserId(Long userId);
    List<Comment> findAllByProductId(Long productId);
}
