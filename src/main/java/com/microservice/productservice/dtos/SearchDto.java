package com.microservice.productservice.dtos;

import lombok.Data;

@Data
public class SearchDto {

    private String keyword;
    private int pageNumber; //these are sent by front end by user's selection webpage
    private int pageSize;   //these are sent by front end by user's selection webpage
}
