package com.microservice.productservice.repos;

import com.microservice.productservice.entities.Products;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long> {

    List<Products> findAllByTitle(String title, Pageable p);

//    default List<Products> findAllByTitleDebug(String title, Pageable p) {
//        System.out.println("Searching for title: " + title);
//        List<Products> products = findAllByTitle(title,p);
//        System.out.println("Found " + products.size() + " products with title: " + title);
//        return products;
//    }

}
