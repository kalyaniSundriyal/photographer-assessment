package com.assessment.photographer.exception;

public class NoSuchEventExistException extends RuntimeException {

  private String message;

  public NoSuchEventExistException() {}

  public NoSuchEventExistException(String msg) {
    super(msg);
    this.message = msg;
  }

}
