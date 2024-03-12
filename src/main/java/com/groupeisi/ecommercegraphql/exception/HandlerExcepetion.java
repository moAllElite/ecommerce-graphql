package com.groupeisi.ecommercegraphql.exception;


import jakarta.persistence.EntityExistsException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class HandlerExcepetion {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({EntityExistsException.class})
    public @ResponseBody ErrorEntityException handleEntityAlreadyException(EntityExistsException  e){
        return  new ErrorEntityException(
              HttpStatus.CONFLICT,
                e.getMessage()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class})
    public ErrorEntityException  handleIllegalArgumentException(IllegalArgumentException e){
        return new ErrorEntityException(
                HttpStatus.BAD_REQUEST,
                e.getMessage()
        );
    }
}
