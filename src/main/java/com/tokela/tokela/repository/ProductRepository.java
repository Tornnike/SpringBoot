package com.tokela.tokela.repository;

import com.tokela.tokela.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByPriceGreaterThanEqual(long price);


}
