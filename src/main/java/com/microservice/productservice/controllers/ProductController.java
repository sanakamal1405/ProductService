package com.microservice.productservice.controllers;

import com.microservice.productservice.entities.Products;
import com.microservice.productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable("id") Long id)
    {
            return productService.getProductById(id);
    }
}
