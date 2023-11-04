package com.example.royalgambitapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND("Nie znaleziono", HttpStatus.NOT_FOUND);

    ErrorCode(String s, HttpStatus httpStatus) {
    }
}
