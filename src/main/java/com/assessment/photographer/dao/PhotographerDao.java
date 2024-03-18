package com.assessment.photographer.dao;

import com.assessment.photographer.vo.Photographer;
import java.util.List;
import java.util.Optional;

public interface PhotographerDao {
  List<Photographer> photographerList();
  List<Photographer> photographerListByEventType(String eventType);
  Photographer photographerById(String id);



}
