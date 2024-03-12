package com.groupeisi.ecommercegraphql.exception;



import jakarta.persistence.EntityExistsException;


import jakarta.persistence.EntityNotFoundException;
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
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EntityNotFoundException.class})
    public @ResponseBody ErrorEntityException handleEntityNotFoundException(EntityNotFoundException e){
        return new ErrorEntityException(
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                LocalDateTime.now()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ NumberFormatException.class})
    public @ResponseBody ErrorEntityException handleNumberFormatException(NumberFormatException e){
        return new ErrorEntityException(
                HttpStatus.BAD_REQUEST,
                e.getMessage(),
                LocalDateTime.now()
        );
    }
}
