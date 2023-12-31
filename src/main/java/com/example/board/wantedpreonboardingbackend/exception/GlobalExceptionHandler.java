package com.example.board.wantedpreonboardingbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Request로 들어온 DTO의 field가 조건에 맞지 않을 때의 예외 처리
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> dtoValidation(final MethodArgumentNotValidException exception) {
        Map<String, List<String>> msg = new HashMap<>();
        msg.put("msg", new ArrayList<>());
        exception.getBindingResult().getAllErrors().forEach((e) -> {
            String errMsg = e.getDefaultMessage();
            msg.get("msg").add(errMsg);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> RequestParamValidation(final ConstraintViolationException exception) {
        Map<String, String> errors = new HashMap<>();

        for (ConstraintViolation<?> c : exception.getConstraintViolations()) {
            String field = c.getPropertyPath().toString();
            String errMsg = c.getMessage();
            errors.put(field, errMsg);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> RequestParamValidation(final IllegalArgumentException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
