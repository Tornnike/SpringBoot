package com.tokela.tokela.controller;


import com.tokela.tokela.model.Product;
import com.tokela.tokela.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private @Qualifier("loanservice")ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){

        return ResponseEntity.ok().body(productService.getAll());
    }


    @PostMapping("/products")
    public ResponseEntity<Product> addProduct (@RequestBody Product product) {
        return ResponseEntity.ok().body(productService.createProduct(product));
    }


    @DeleteMapping("/products/{productId}")
    public HttpStatus deleteProduct (@PathVariable long productId){
        productService.deleteProduct(productId);
        return HttpStatus.OK;

    }

    @GetMapping("/products/findbyprice/{price}")
    public ResponseEntity<List<Product>> getProductByPrice(@PathVariable long price){

        return ResponseEntity.ok().body(productService.findByPriceGreaterThanEqual(price));
    }























}
