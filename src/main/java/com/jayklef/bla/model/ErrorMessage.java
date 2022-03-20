package com.jayklef.bla.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private Timestamp timestamp;
    private String status;
    private String message;
}
