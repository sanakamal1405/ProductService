package com.microservice.productservice.controllers;

import com.microservice.productservice.entities.Products;
import com.microservice.productservice.exceptions.InvalidID;
import com.microservice.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<Products> create(@RequestBody Products product)
    {
        return new ResponseEntity<Products>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable("id") Long id) throws InvalidID {
        if(id<=0)
        {
            throw new InvalidID("Invalid Product id", id);
        }
        else if(id>20)
        {
            throw new RuntimeException();
        }
        else
        {
            Products product=productService.getProductById(id);

            return new ResponseEntity<Products>(product, HttpStatus.OK);
        }
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Products product)
    {
        productService.deleteProduct(product);
    }

    @PutMapping
    public ResponseEntity<Products> updateProduct(@RequestBody Products product)
    {
        Products p= productService.replaceProduct(product);

        return new ResponseEntity<Products>(p,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAllProduct()
    {
        List<Products> list=productService.getAllProducts();
        return new ResponseEntity<List<Products>>(list,HttpStatus.OK);
    }
}
