package com.fiserv.spring.boot.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ErrorDetails {

    public ErrorDetails(LocalDateTime timeStamp, String message, String details, int status) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
        this.status = status;
    }

    private LocalDateTime timeStamp;
    private String message;
    private String details;
    private int status;
}
