package com.softtech.webapp.app.gen.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @CreatedDate
    private String createDate;

    @LastModifiedDate
    private String updateDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String updatedBy;
}
