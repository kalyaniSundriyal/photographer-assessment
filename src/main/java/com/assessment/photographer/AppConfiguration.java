package com.assessment.photographer;

import com.assessment.photographer.constant.EventType;
import com.assessment.photographer.dao.PhotographerDao;
import com.assessment.photographer.dao.PhotographerDaoJsonImpl;
import com.assessment.photographer.service.PhotographerService;
import com.assessment.photographer.util.PhotographerJsonParser;
import com.assessment.photographer.vo.Photographer;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AppConfiguration {

  @Value("${photographer.json.path}")
  private String photographerJsonPath;

  @Bean
  public PhotographerDao photographerJsonDao() {
    log.info("json {}", photographerJsonPath);
    PhotographerJsonParser jsonParser = new PhotographerJsonParser();
    List<Photographer> photographers = jsonParser.parseAllPhotographer(photographerJsonPath);
    log.info("photographer.photographerJsonDao.photographers {} " , photographers);
    Map photographerIdMap = generatePhotographerIdMap(photographers);
    log.info("photographer.photographerJsonDao.photographerIdMap {} " , photographerIdMap);
    Map photographerEventTypeMap = generatePhotographerEventTypeMap(photographers);
    log.info("photographer.photographerJsonDao.photographerEventTypeMap {} " , photographerEventTypeMap);
    return new PhotographerDaoJsonImpl(photographerIdMap, photographerEventTypeMap, photographers);
  }

  @Bean
  public PhotographerService service() {
    return new PhotographerService(photographerJsonDao());
  }

  private Map<EventType, List<Photographer>> generatePhotographerEventTypeMap(List<Photographer> photographers) {
    return photographers.stream().collect(Collectors.groupingBy(Photographer::getEventType));
  }

  private Map<String, Photographer> generatePhotographerIdMap(List<Photographer> photographers) {
    return photographers.stream().collect(Collectors.toMap(Photographer::getId, Function.identity()));
  }
}
