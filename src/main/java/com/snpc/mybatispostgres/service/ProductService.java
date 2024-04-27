package com.snpc.mybatispostgres.service;

import com.snpc.mybatispostgres.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
    List<Product> findAllDynamic(Product product);
    Product insert(Product product);
    Product update(Integer id, Product product);
    Integer delete(Integer id);
}
