package com.Restful_Webservices.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayloadContainer       // IT WILL HOLD CLIENT NEEDS MESSAGES
{

    private LocalDateTime timeStamp;
    private String message;
    private String path;
    private String error_code;

}
