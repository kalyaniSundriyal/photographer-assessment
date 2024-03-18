package com.assessment.photographer.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorsResponse {

  private int statusCode;
  private String message;

  public ErrorsResponse(String message)
  {
    super();
    this.message = message;
  }
}
