package pl.roman.mysan.contacts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String PACKAGE_NAME = "pl.roman.mysan.contacts.person.domain.";

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(Exception ex) {
        return ex.getMessage().replaceAll(PACKAGE_NAME,"");
    }

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleInvalidFormatException(Exception ex) {
        return ex.getMessage();
    }
}