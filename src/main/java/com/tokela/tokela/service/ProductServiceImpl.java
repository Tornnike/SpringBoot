package com.tokela.tokela.service;

import com.tokela.tokela.model.Product;
import com.tokela.tokela.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("loanservice")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;



    @Override
    public Product createProduct(Product product) {

        return productRepository.save(product);

    }



    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }



    @Override
    public void deleteProduct(long productId) {

        Optional<Product> findProduct = productRepository.findById(productId);

        if(findProduct.isPresent()) {

            productRepository.delete(findProduct.get());
        }

        else {
            throw new RuntimeException("byeee");
        }


    }

    @Override
    public List<Product> findByPriceGreaterThanEqual(long price) {

        return productRepository.findByPriceGreaterThanEqual(price);
    }
}
