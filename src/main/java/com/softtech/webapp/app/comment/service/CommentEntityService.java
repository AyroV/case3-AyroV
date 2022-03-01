package com.softtech.webapp.app.comment.service;

import com.softtech.webapp.app.comment.dao.CommentDao;
import com.softtech.webapp.app.comment.entity.Comment;
import com.softtech.webapp.app.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentDao> {
    public CommentEntityService(CommentDao dao) {
        super(dao);
    }

    public List<Comment> findAllByUserId(Long userId) {
        return getDao().findAllByUserId(userId);
    }

    public List<Comment> findAllByProductId(Long productId) {
        return getDao().findAllByProductId(productId);
    }
}
