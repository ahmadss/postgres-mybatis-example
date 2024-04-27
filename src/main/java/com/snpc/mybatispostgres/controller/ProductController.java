package com.snpc.mybatispostgres.controller;

import com.snpc.mybatispostgres.entity.Product;
import com.snpc.mybatispostgres.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping("/dynamic")
    public ResponseEntity<?> findAllDynamic(@RequestBody Product product) {
        return ResponseEntity.ok(productService.findAllDynamic(product));
    }

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody Product product) {
        Product pAfterInsert = productService.insert(product);
        if(pAfterInsert != null) {
            return ResponseEntity.ok(pAfterInsert);
        }
        return ResponseEntity.badRequest().body("Insert error");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id , @RequestBody Product product) {
        Product pAfterUpdate = productService.update(id,product);
        if(pAfterUpdate != null) {
            return ResponseEntity.ok(pAfterUpdate);
        }
        return ResponseEntity.badRequest().body("Update error");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        Integer idAfterDelete = productService.delete(id);
        if(idAfterDelete != null) {
            return ResponseEntity.ok(idAfterDelete);
        }
        return ResponseEntity.badRequest().body("Delete error");
    }
}
