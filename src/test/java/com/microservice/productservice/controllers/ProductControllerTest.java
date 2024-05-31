package com.microservice.productservice.controllers;

import com.microservice.productservice.entities.Products;
import com.microservice.productservice.exceptions.InvalidID;
import com.microservice.productservice.services.ProductService;
import com.microservice.productservice.services.fakeProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @MockBean
    private fakeProductService ps;
    @Autowired
    private ProductController pc;

    void create() {
    }

    @Test
    void getProductById() {

        //Arrange
        Long id1 = 1l; //positive
        Long id2 = 0l; //negative
        Long id3 = 21l;   //edgecase


        when(ps.getProductById(any(Long.class))).thenCallRealMethod();


        //Actid2;
        ResponseEntity<Products> p1 = pc.getProductById(id1);



        //Assert
        assertThrows(InvalidID.class, () -> pc.getProductById(id2));
     //ssertEquals(1, p1.getBody().getId());
        assertThrows(RuntimeException.class, () -> pc.getProductById(id3));
    }

    @Test
    void updateProduct() {
    }

    @Test
    void getAllProduct() {
    }
}