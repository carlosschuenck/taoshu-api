package br.com.taoshu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;

/**
 * Created by Avell 1513 on 17/05/2018.
 */
@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionMessage> generciException(Exception exception){
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setMessage("Deu ruin no baguio.");
        exceptionMessage.setDetail(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionMessage);
    }


    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ExceptionMessage> constraintViolation(ValidationException exception){
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setMessage("(ValidationException) Deu ruin no baguio.");
        exceptionMessage.setDetail(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionMessage);
    }
}
