package com.assessment.photographer.util;

import com.assessment.photographer.constant.EventType;
import com.assessment.photographer.vo.Address;
import com.assessment.photographer.vo.Photographer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PhotographerJsonParser {

  private ObjectMapper mapper = new ObjectMapper();

  public List<Photographer> parseAllPhotographer(String photographerJsonPath) {
    log.info("Parsing Exception from path {}", photographerJsonPath);
    List<Photographer> photographers = null;
    try {
      File file = new File(photographerJsonPath);
      photographers = mapper.readValue(file, mapper.getTypeFactory()
          .constructCollectionType(List.class, Photographer.class));
    } catch (JsonProcessingException e) {
      log.info("Error occurred while parsing JSON {} ", e.getMessage());
    } catch (IOException e) {
      log.info("Error occurred while reading file {} ", e.getMessage());
    }
    return photographers;
  }

  public void photographerToJson() throws JsonProcessingException {
    List<Photographer> photographers = new ArrayList<>();
    photographers.add(new Photographer("1", "Mark", "David", EventType.WEDDING, new Address("San Jose", "California", "1234")));
    photographers.add(new Photographer("2", "Nick", "White", EventType.WEDDING, new Address("Santa Clara", "California", "2345")));
    photographers.add(new Photographer("3", "Celina", "Gomz", EventType.BIRTHDAYS, new Address("Lucknow", "Uttar Pradesh", "1235")));
    photographers.add(new Photographer("4", "Catalina", "Rush", EventType.BIRTHDAYS, new Address("Cupertino", "California", "1435")));
    try {
      String json = mapper.writeValueAsString(photographers);
      File file = new File("photographer.json");
      mapper.writeValue(file, photographers);
    } catch (JsonProcessingException e) {
      log.info("Error occurred while parsing photographer to json {} ", e.getMessage());
    } catch (IOException e) {
      log.info("Error occurred while writing file {} ", e.getMessage());
    }
  }
}
