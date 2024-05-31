package com.microservice.productservice.exceptionDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidIDExceptionDto {
    Long id;
    String message;

    public InvalidIDExceptionDto(Long number, String message) {
        this.id = number;
        this.message = message;
    }
}
