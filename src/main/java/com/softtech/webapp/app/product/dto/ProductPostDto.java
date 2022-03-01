package com.softtech.webapp.app.product.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductPostDto {
    @NotNull(message = "Product Name cannot be null")
    @NotBlank(message = "Product Name cannot be blank")
    private String productName;
    @NotNull(message = "Price cannot be null")
    private BigDecimal price;
}
