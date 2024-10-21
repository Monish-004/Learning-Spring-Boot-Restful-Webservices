package com.Restful_Webservices.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class UserNotFound extends RuntimeException       // API REQUEST EXCEPTION
{
    public UserNotFound(Integer id)
    {
        super(String.format("User Not Found for your given id : '%s'" , id));
    }
}
