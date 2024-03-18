package com.assessment.photographer.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.assessment.photographer.constant.EventType;
import com.assessment.photographer.dao.PhotographerDao;
import com.assessment.photographer.exception.NoSuchEventExistException;
import com.assessment.photographer.exception.NoSuchPhotographerExistsException;
import com.assessment.photographer.vo.Address;
import com.assessment.photographer.vo.Photographer;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class PhotographerServiceTest {
  @Mock
  private PhotographerDao photographerDao;
  @InjectMocks
  private PhotographerService photographerService;

  @Test
  public void photographerByIdNotNull() {
    Photographer photographer = new Photographer("1","Mark","David", EventType.WEDDING,new Address("San Jose","California","1234"));
    Mockito.when(photographerDao.photographerById("1")).thenReturn(photographer);
    Photographer photographer1 = photographerService.findById("1");
    assertThat(photographer1).isNotNull();
  }

  @Test
  public void photographerByIdNull() {
    Mockito.when(photographerDao.photographerById("2")).thenReturn(null);
    Exception exception = assertThrows(NoSuchPhotographerExistsException.class, () -> {photographerService.findById("2");});
    String expectedMessage = "No photographer exists with ID [2]";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void photographerByEventTypeNotNull() {
    Photographer photographer = new Photographer("1","Mark","David", EventType.WEDDING,new Address("San Jose","California","1234"));
    Mockito.when(photographerDao.photographerListByEventType("WEDDING")).thenReturn(Arrays.asList(photographer));
    List<Photographer> photographers = photographerService.findByEventType("WEDDING");
    assertThat(photographers.size()).isEqualTo(1);
  }

  @Test
  public void photographerNotExistForEventType() {
    Mockito.when(photographerDao.photographerListByEventType("WEDDING")).thenReturn(null);
    Exception exception = assertThrows(NoSuchPhotographerExistsException.class, () -> {photographerService.findByEventType("WEDDING");});
    String expectedMessage = "No photographer exists for event [WEDDING]";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void photographerForEventTypeNull() {
    Mockito.when(photographerDao.photographerListByEventType("WEDDING1")).thenReturn(null);
    Exception exception = assertThrows(NoSuchEventExistException.class, () -> {photographerService.findByEventType("WEDDING1");});
    String expectedMessage = "INVALID EventType. Please select from event type list";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

}
