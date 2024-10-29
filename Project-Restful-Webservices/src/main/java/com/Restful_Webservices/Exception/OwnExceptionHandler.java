package com.Restful_Webservices.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class OwnExceptionHandler extends ResponseEntityExceptionHandler      // IT WILL HANDLE THE BOTH, CUSTOM AS WELL AS GLOBAL EXCEPTION
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

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<PayloadContainer> handleGlobalException(Exception exception ,
                                                                             WebRequest webRequest)
    {
        PayloadContainer payloadContainer = new PayloadContainer(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL SERVER ERROR, NO DATAS ARE THERE TO STORE IN DB SERVER"
        );

        return new ResponseEntity<>(payloadContainer, HttpStatus.BAD_GATEWAY);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request)
    {
        Map<String,String> validationErrorMessage = new HashMap<String,String>();

        // WE CAN GET ALL THE VALIDATION ERROR MESSAGES FROM MethodArgumentNotValidException OBJECT
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
        errorList.forEach( (error) ->{
            // TYPE CASTING INVOLVES HERE
            String fieldName = ( (FieldError) error).getField();
            String message = error.getDefaultMessage();
            validationErrorMessage.put(fieldName,message);
        });
        return new ResponseEntity<>(validationErrorMessage, HttpStatus.BAD_REQUEST);

    }
}
