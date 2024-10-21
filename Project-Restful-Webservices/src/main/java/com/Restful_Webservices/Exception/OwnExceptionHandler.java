package com.Restful_Webservices.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class OwnExceptionHandler       // IT WILL HANDLE THE BOTH, CUSTOM AS WELL AS GLOBAL EXCEPTION
{

    @ExceptionHandler(value = UserNotFound.class)
    public ResponseEntity<PayloadContainer> handleUserNotFoundException(UserNotFound noUser ,
                                                                        WebRequest webRequest)
    {
        PayloadContainer payloadContainer = new PayloadContainer(
                LocalDateTime.now(),
                noUser.getMessage(),
                webRequest.getDescription(false),
                "USER NOT FOUND"
        );

        return new ResponseEntity<>(payloadContainer, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = EmailAlreadyExist.class)
    public ResponseEntity<PayloadContainer> handleEmailAlreadyExistException(EmailAlreadyExist exist ,
                                                                        WebRequest webRequest)
    {
        PayloadContainer payloadContainer = new PayloadContainer(
                LocalDateTime.now(),
                exist.getMessage(),
                webRequest.getDescription(false),
                "USER_EMAIL_ALREADY_EXIST"
        );

        return new ResponseEntity<>(payloadContainer, HttpStatus.BAD_REQUEST);
    }
}
