package com.softtech.webapp.app.product.controller;

import com.softtech.webapp.app.product.dto.ProductGetDto;
import com.softtech.webapp.app.product.dto.ProductPostDto;
import com.softtech.webapp.app.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ProductGetDto> productGetDtoList = productService.findAll();
        return ResponseEntity.ok().body(productGetDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        ProductGetDto productGetDto = productService.findById(id);
        return ResponseEntity.ok().body(productGetDto);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ProductPostDto productPostDto) {
        ProductGetDto productGetDto = productService.save(productPostDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productGetDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestParam BigDecimal price) {
        ProductGetDto productGetDto = productService.update(price, id);
        return ResponseEntity.ok().body(productGetDto);
    }
}
