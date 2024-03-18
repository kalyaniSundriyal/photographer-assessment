package com.assessment.photographer.util;

import com.assessment.photographer.constant.EventType;
import com.assessment.photographer.vo.Address;
import com.assessment.photographer.vo.Photographer;
import java.util.ArrayList;
import java.util.List;

public class PhotographerDummyData {
  public static List<Photographer> getPhotographers(){
    List<Photographer> photographers = new ArrayList<>();
    photographers.add(new Photographer("1","Mark","David", EventType.WEDDING,new Address("San Jose","California","1234")));
    photographers.add(new Photographer("2","Nick","White",EventType.WEDDING,new Address("Santa Clara","California","2345")));
    photographers.add(new Photographer("3","Celina","Gomz",EventType.BIRTHDAYS,new Address("Lucknow","Uttar Pradesh","1235")));
    photographers.add(new Photographer("4","Catalina","Rush",EventType.BIRTHDAYS,new Address("Cupertino","California","1435")));
    return photographers;
  }
}
