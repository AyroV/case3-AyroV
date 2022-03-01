package com.softtech.webapp.app.comment.entity;

import com.softtech.webapp.app.gen.entity.BaseEntity;
import com.softtech.webapp.app.user.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Getter
@Setter
public class Comment extends BaseEntity {
    @Id
    @SequenceGenerator(name = "CommentGen" , sequenceName = "COMMENT_ID_SEQ")
    @GeneratedValue(generator = "CommentGen")
    private Long id;
    private String commentText;
    private Long userId;
    private Long productId;
}
