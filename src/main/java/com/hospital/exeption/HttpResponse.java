package com.hospital.exeption;

import java.sql.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HttpResponse {
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss", timezone = "America/Lima")
    private Date timeStamp;
    private int code; // 200, 201, 400, 500
    private HttpStatus httpStatus;
    private String reason;
    private String message;

    public HttpResponse() {}

    public HttpResponse(int code, HttpStatus httpStatus, String reason, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.reason = reason;
        this.message = message;
    }

   
}
