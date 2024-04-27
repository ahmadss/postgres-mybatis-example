package com.snpc.mybatispostgres.service.impl;

import com.snpc.mybatispostgres.entity.Product;
import com.snpc.mybatispostgres.exception.ProductException;
import com.snpc.mybatispostgres.repo.ProductMapper;
import com.snpc.mybatispostgres.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }

    @Override
    public List<Product> findAllDynamic(Product product) {
        return productMapper.findAllDynamic(product);
    }

    @Override
    public Product insert(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public Product update(Integer id, Product product) {
        Boolean exist = productMapper.exist(id);
        if(exist) {
            product.setId(id);
            return productMapper.update(product);
        }
        throw new ProductException("Product id is not exist");
    }

    @Override
    public Integer delete(Integer id) {
        Boolean exist = productMapper.exist(id);
        if(exist) {
            productMapper.delete(id);
            return id;
        }
        throw new ProductException("Product id is not exist");
    }
}
