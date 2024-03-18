package com.assessment.photographer.service;

import com.assessment.photographer.constant.EventType;
import com.assessment.photographer.dao.PhotographerDao;
import com.assessment.photographer.exception.NoSuchEventExistException;
import com.assessment.photographer.exception.NoSuchPhotographerExistsException;
import com.assessment.photographer.vo.Photographer;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PhotographerService {

  private PhotographerDao photographerDao;

  public PhotographerService(PhotographerDao photographerDao) {
    this.photographerDao = photographerDao;
  }

  public List<Photographer> getAllPhotographers() {
    return photographerDao.photographerList();
  }

  public Photographer findById(String id) {
    Photographer photographer = photographerDao.photographerById(id);
    log.info("photographer.service.findById {}", photographer);
    if (photographer == null) throw new NoSuchPhotographerExistsException("No photographer exists with ID ["+ id +"] ");
    return photographer;
  }

  public List<Photographer> findByEventType(String eventType) {
    validate(eventType);
    List<Photographer> photographers = photographerDao.photographerListByEventType(eventType);
    log.info("photographer.service.findByEventType {}",photographers);
    if (photographers == null) throw new NoSuchPhotographerExistsException("No photographer exists for event ["+ eventType +"] ");
    return photographers;
  }

  public static void validate(String eventType){
    try {
      EventType.valueOf(eventType);
    }catch (IllegalArgumentException ex){
      throw new NoSuchEventExistException("INVALID EventType. Please select from event type list" + Arrays.asList(EventType.values())) ;
    }
  }
}
