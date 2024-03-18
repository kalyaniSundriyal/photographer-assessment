package com.assessment.photographer.exception;

public class NoSuchPhotographerExistsException extends RuntimeException {

  private String message;

  public NoSuchPhotographerExistsException() {}

  public NoSuchPhotographerExistsException(String msg) {
    super(msg);
    this.message = msg;
  }
}
