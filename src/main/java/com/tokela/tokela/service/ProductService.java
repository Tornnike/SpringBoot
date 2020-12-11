package com.tokela.tokela.service;

import com.tokela.tokela.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAll();

    void deleteProduct(long productId);

    List<Product> findByPriceGreaterThanEqual(long price);




}
