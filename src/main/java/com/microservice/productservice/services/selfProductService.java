package com.microservice.productservice.services;

import com.microservice.productservice.entities.Category;
import com.microservice.productservice.entities.Products;
import com.microservice.productservice.repos.CategoryRepo;
import com.microservice.productservice.repos.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Primary
@Service
public class selfProductService implements ProductService {

    ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public selfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }


    @Override
    public Products getProductById(Long id) {
        return null;
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Products updateProduct(Products product) {
        return null;
    }

    @Override
    public Products replaceProduct(Products product) {
        return productRepo.save(product);
    }

    @Override
    public Products createProduct(Products product) {

        Category category = product.getCategory();
        if (category.getId() == null) {
            Category savedCategory = categoryRepo.save(category);
            product.setCategory(savedCategory);
        }


        return productRepo.save(product);
    }

    @Transactional
    @Override
    public void deleteProduct(Products product) {
        System.out.println("in service deleting product");
        productRepo.deleteById(product.getId());
    }
}
