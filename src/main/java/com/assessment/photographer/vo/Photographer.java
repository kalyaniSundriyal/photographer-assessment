package com.assessment.photographer.vo;

import com.assessment.photographer.constant.EventType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Photographer {
  private String id;
  private String fistName;
  private String lastName;
  private EventType eventType;
  private Address address;

  public Photographer(){
    super();
  }

  public Photographer(String id, String fistName, String lastName, EventType eventType, Address address) {
    this.id = id;
    this.fistName = fistName;
    this.lastName = lastName;
    this.eventType = eventType;
    this.address = address;
  }

  @Override
  public String toString() {
    return "Photographer{" +
        "id='" + id + '\'' +
        ", fistName='" + fistName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", eventType=" + eventType +
        ", address=" + address +
        '}';
  }
}
