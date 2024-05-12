package com.microservice.productservice.advices;


import com.microservice.productservice.exceptionDtos.InvalidIDExceptionDto;
import com.microservice.productservice.exceptions.InvalidID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice
{
    @ExceptionHandler(InvalidID.class)
    public ResponseEntity<InvalidIDExceptionDto> handleException(InvalidID id)
    {

        InvalidIDExceptionDto exception=new InvalidIDExceptionDto(id.getID(), "INVALID_PRODUCT_ID");
        return new ResponseEntity<InvalidIDExceptionDto>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException()
    {
        return new ResponseEntity<String>("Id out of range", HttpStatus.FORBIDDEN);

    }

}
