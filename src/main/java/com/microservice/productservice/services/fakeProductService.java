package com.microservice.productservice.services;

import com.microservice.productservice.dtos.ProductDto;
import com.microservice.productservice.entities.Category;
import com.microservice.productservice.entities.Products;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
//@Primary
@Service
public class fakeProductService implements ProductService {

    private RestTemplate restTemplate;

    fakeProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Products getProductById(Long id) {
        ProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        ProductDto.class);

        return convertDtoToProduct(fakeStoreProductDto);
    }

    private Products convertDtoToProduct(ProductDto productDto) {

        Products products = new Products();
        products.setId(productDto.getId());
        products.setTitle(productDto.getTitle());
        products.setPrice(productDto.getPrice());

        // Mapping Category string to Category object
        Category category = new Category();
        category.setId(0L);
        category.setTitle(productDto.getCategory());
        products.setCategory(category);

        products.setDescription(productDto.getDescription());
        return products;
    }

    @Override
    public List<Products> getAllProducts() {
        ProductDto[] fakeStoreProductDtoList =
                restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class);

        //convert result
        List<Products> products = new ArrayList<>();
        for (ProductDto fakeStoreProductDto : fakeStoreProductDtoList) {
            products.add(convertDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Products updateProduct(Products product) {
        return null;
    }

    @Override
    public Products replaceProduct(Products product) {
        return null;
    }

    @Override
    public Products createProduct(Products product) {
        return null;
    }


    @Override
    public void deleteProduct(Products product) {


    }
}
