package com.microservice.productservice.services;

import com.microservice.productservice.dtos.ProductDto;
import com.microservice.productservice.entities.Category;
import com.microservice.productservice.entities.Products;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeProductService implements ProductService{

    private RestTemplate restTemplate;

    FakeProductService(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
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
        category.setId(0);
        category.setTitle(productDto.getCategory());
        products.setCategory(category);

        products.setDescription(productDto.getDescription());
        return products;
    }

    @Override
    public List<Products> getAllProducts() {
        return null;
    }

    @Override
    public Products updateProduct() {
        return null;
    }

    @Override
    public Products replaceProduct() {
        return null;
    }

    @Override
    public Products createProduct() {
        return null;
    }

    @Override
    public Products deleteProduct() {
        return null;
    }
}
