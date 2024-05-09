package com.microservice.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidID extends RuntimeException{

    Long ID;
    public InvalidID(String m,Long id)
    {
        super(m);
        this.ID=id;

    }
}
