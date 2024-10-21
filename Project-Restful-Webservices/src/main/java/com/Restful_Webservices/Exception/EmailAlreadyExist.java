package com.Restful_Webservices.Exception;

import com.Restful_Webservices.Entity.UserEntity;

public class EmailAlreadyExist extends RuntimeException
{
    public EmailAlreadyExist(String message , String email)
    {
        super(String.format("%s %s",message,email));
    }
}
