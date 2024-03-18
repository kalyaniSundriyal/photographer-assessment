package com.assessment.photographer.dao;


import com.assessment.photographer.constant.EventType;
import com.assessment.photographer.vo.Photographer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * To cover
 */
@Slf4j
public class PhotographerDaoJsonImpl implements PhotographerDao {

  private final Map<String, Photographer>  photographerIdMap;
  private final Map<EventType, List<Photographer>>  photographerEventTypeMap;
  private final List<Photographer>  photographers;

  public PhotographerDaoJsonImpl(Map<String, Photographer> photographerIdMap, Map<EventType, List<Photographer>> photographerEventTypeMap,
      List<Photographer> photographers) {
    this.photographers = photographers;
    this.photographerIdMap = photographerIdMap;
    this.photographerEventTypeMap = photographerEventTypeMap;
  }

  @Override
  public List<Photographer> photographerList() {
    return photographers;
  }

  @Override
  public List<Photographer> photographerListByEventType(String eventType) {
    log.info("photographer.dao.photographerListByEventType {} ", eventType);
    return photographerEventTypeMap.get(EventType.valueOf(eventType));
  }

  @Override
  public Photographer photographerById(String id) {
    log.info("photographer.dao.photographerById {} ", id);
    return photographerIdMap.get(id);
  }

}
