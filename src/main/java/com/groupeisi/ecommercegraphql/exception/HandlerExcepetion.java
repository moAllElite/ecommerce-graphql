package com.groupeisi.ecommercegraphql.exception;



import jakarta.persistence.EntityExistsException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerExcepetion {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({EntityExistsException.class})
    public @ResponseBody ErrorEntityException handleEntityAlreadyException(EntityExistsException  e){
        return  new ErrorEntityException(
              HttpStatus.CONFLICT,
                e.getMessage(),
                LocalDateTime.now()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class})
    public @ResponseBody  ErrorEntityException  handleIllegalArgumentException(IllegalArgumentException e){
        return new ErrorEntityException(
                HttpStatus.BAD_REQUEST,
                e.getMessage(),
                LocalDateTime.now()
        );
    }
}
