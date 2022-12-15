package com.src.application.urlshortener.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ErrorResponse {
        private String errorMessage;

        private Integer statusCode;
        public ErrorResponse(){

        }
}
