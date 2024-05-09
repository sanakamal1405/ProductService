package com.microservice.productservice.controllers;

import com.microservice.productservice.entities.Products;
import com.microservice.productservice.exceptions.InvalidID;
import com.microservice.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Products> getProductById(@PathVariable("id") Long id) throws InvalidID {
        if(id<=0)
        {
            throw new InvalidID("Invalid Product id", id);
        }
            Products product=productService.getProductById(id);

            return new ResponseEntity<Products>(product, HttpStatus.OK);
    }
}
