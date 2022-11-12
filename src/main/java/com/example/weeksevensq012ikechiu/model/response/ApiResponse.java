package com.example.weeksevensq012ikechiu.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class ApiResponse<T> {
    private int httpStatusCode;
    private HttpStatus status;
    private String message;
    private boolean success;
    private T data;
}
