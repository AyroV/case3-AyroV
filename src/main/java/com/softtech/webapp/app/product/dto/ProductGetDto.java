package com.softtech.webapp.app.product.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductGetDto {
    private Long id;
    private String productName;
    private BigDecimal price;
    private String createDate;
    private String createdBy;
    private String updateDate;
    private String updatedBy;
}
