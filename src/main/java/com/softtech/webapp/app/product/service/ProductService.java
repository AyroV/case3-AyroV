package com.softtech.webapp.app.product.service;

import com.softtech.webapp.app.gen.exceptions.BusinessException;
import com.softtech.webapp.app.product.dto.ProductGetDto;
import com.softtech.webapp.app.product.dto.ProductPostDto;
import com.softtech.webapp.app.product.entity.Product;
import com.softtech.webapp.app.product.enums.ProductErrorMessage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductEntityService productEntityService;
    private final ModelMapper mapper;

    public List<ProductGetDto> findAll() {
        List<Product> productList = productEntityService.findAll();
        List<ProductGetDto> productGetDtoList = productList.stream().map(product -> mapper.map(product, ProductGetDto.class)).collect(Collectors.toList());
        return productGetDtoList;
    }

    public ProductGetDto findById(Long id) {
        Product product = productEntityService.getByIdWithControl(id);
        return mapper.map(product, ProductGetDto.class);
    }

    public ProductGetDto save(ProductPostDto productPostDto) {
        isProductNameUnique(productPostDto.getProductName().toUpperCase());

        Product product = mapper.map(productPostDto, Product.class);
        product.setProductNameUpper(product.getProductName().toUpperCase());
        product = productEntityService.save(product, false);
        return mapper.map(product, ProductGetDto.class);
    }

    public void delete(Long id) {
        Product product = productEntityService.getByIdWithControl(id);
        productEntityService.delete(product);
    }

    public ProductGetDto update(BigDecimal price, Long id) {
        Product product = productEntityService.getByIdWithControl(id);

        if(price.compareTo(BigDecimal.valueOf(0)) < 0)
            throw new BusinessException(ProductErrorMessage.PRODUCT_PRICE_BELOW_ZERO);

        product.setPrice(price);
        product = productEntityService.save(product, true);
        return mapper.map(product, ProductGetDto.class);
    }

    private void isProductNameUnique(String productName) {
        Product product = productEntityService.findByProductNameUpper(productName);
        if(product != null)
            throw new BusinessException(ProductErrorMessage.PRODUCT_NAME_ALREADY_TAKEN);
    }
}
