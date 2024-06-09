package com.microservice.productservice.controllers;

import com.microservice.productservice.dtos.SearchDto;
import com.microservice.productservice.entities.Products;
import com.microservice.productservice.services.searchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/search")
public class searchController {

    private searchService sc;


    public searchController(searchService sc)
    {
        this.sc=sc;
    }

    @PostMapping
    public List<Products> search(@RequestBody SearchDto searchDto)
    {
        System.out.println("***here");
        return sc.search(searchDto.getKeyword(), searchDto.getPageNumber(),searchDto.getPageSize());
    }



}
