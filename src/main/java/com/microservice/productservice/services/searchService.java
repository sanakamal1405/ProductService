package com.microservice.productservice.services;

import com.microservice.productservice.entities.Products;
import com.microservice.productservice.repos.ProductRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class searchService {

    ProductRepo productRepo;

    public searchService(ProductRepo productRepo)
    {
        this.productRepo=productRepo;
    }

    public List<Products> search(String keyword, int pageNumber, int pageSize)
    {
        //System.out.println("******here 2"+ keyword + pageNumber + pageSize);
        return productRepo.findAllByTitle(keyword, PageRequest.of(pageNumber, pageSize));
    }
}
