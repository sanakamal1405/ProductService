package com.microservice.productservice.services;


import com.microservice.productservice.entities.Products;

import java.util.List;


public interface ProductService {


    Products getProductById(Long id);

    List<Products> getAllProducts();

    Products updateProduct(Products product);

    Products replaceProduct(Products product);

    Products createProduct(Products product);

    void deleteProduct(Products product);
}
