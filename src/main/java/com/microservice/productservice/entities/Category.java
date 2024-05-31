package com.microservice.productservice.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends identifier {


    private String title;
    //private int dummy2; commenting dummy changes

}
