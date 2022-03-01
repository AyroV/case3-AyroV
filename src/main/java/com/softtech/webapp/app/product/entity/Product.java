package com.softtech.webapp.app.product.entity;

import com.softtech.webapp.app.gen.entity.BaseEntity;
import com.softtech.webapp.app.user.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product extends BaseEntity {
    @Id
    @SequenceGenerator(name = "ProductGen" , sequenceName = "PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "ProductGen")
    private Long id;
    private String productName;
    private String productNameUpper;
    private BigDecimal price;
}
