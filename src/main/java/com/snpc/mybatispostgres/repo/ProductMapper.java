package com.snpc.mybatispostgres.repo;

import com.snpc.mybatispostgres.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> findAll();
    Product findById(@Param("id") Integer id);
    Boolean exist(@Param("id") Integer id);
    List<Product> findAllDynamic(Product product);
    Product insert(Product product);
    Product update(Product product);
    Integer delete(@Param("id") Integer id);
}
