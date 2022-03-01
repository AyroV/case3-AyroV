package com.softtech.webapp.app.product.service;

import com.softtech.webapp.app.gen.service.BaseEntityService;
import com.softtech.webapp.app.product.dao.ProductDao;
import com.softtech.webapp.app.product.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductDao> {
    public ProductEntityService(ProductDao dao) {
        super(dao);
    }

    public Product findByProductNameUpper(String productName) {
        return getDao().findByProductNameUpper(productName);
    }
}
