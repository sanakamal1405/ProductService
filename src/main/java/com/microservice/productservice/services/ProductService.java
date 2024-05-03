package com.microservice.productservice.services;


import com.microservice.productservice.entities.Products;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {


    Products getProductById(Long id);
    List<Products> getAllProducts();
    Products updateProduct();
    Products replaceProduct();
    Products createProduct();
    Products deleteProduct();
}
