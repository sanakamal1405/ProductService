package com.microservice.productservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Products extends identifier{
    private String title;
    private double price;
    @ManyToOne
    private Category category;
    private String description;

}
