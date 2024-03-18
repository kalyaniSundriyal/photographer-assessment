package com.assessment.photographer.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
  private String city;
  private String state;
  private String pinCode;

  public Address(){
    super();
  }

  public Address(String city, String state, String pinCode) {
    this.city=city;
    this.state=state;
    this.pinCode=pinCode;

  }

  @Override
  public String toString() {
    return "Address{" +
        "city='" + city + '\'' +
        ", state='" + state + '\'' +
        ", pinCode='" + pinCode + '\'' +
        '}';
  }
}
