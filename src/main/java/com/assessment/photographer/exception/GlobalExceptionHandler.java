package com.assessment.photographer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = NoSuchPhotographerExistsException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public @ResponseBody ErrorsResponse handleException(NoSuchPhotographerExistsException ex) {
    return new ErrorsResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
  }

  @ExceptionHandler(value = NoSuchEventExistException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public @ResponseBody ErrorsResponse handleException(NoSuchEventExistException ex) {
    return new ErrorsResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
  }
}
