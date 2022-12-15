package com.src.application.urlshortener.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
   // int id;
    String inputURL;
    String outputURL;
}
