package com.microservice.productservice.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products {
    private long id;
    private String title;
    private double price;
    private Category category;
    private String description;

}
