package com.microservice.productservice.services;

import com.microservice.productservice.config.RedisTemplateConfig;
import com.microservice.productservice.dtos.ProductDto;
import com.microservice.productservice.entities.Category;
import com.microservice.productservice.entities.Products;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Primary
@Service
public class fakeProductService implements ProductService {


    private RestTemplate restTemplate;
    private RedisTemplate<String, Object> redisTemplate;

    public fakeProductService(RestTemplate restTemplate, RedisTemplate redisTemplate) {

        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Products getProductById(Long id) {
        Products product = (Products) redisTemplate.opsForHash().get("PRODUCTS", "PRODUCTS_"+id);
        if(product!=null)
            return product;
        ProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        ProductDto.class);

        Products p= convertDtoToProduct(fakeStoreProductDto);

        redisTemplate.opsForHash().put("PRODUCTS","PRODUCTS_"+p.getId(),p);

        return p;
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
