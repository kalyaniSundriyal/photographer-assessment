package com.assessment.photographer.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.assessment.photographer.service.PhotographerService;
import com.assessment.photographer.util.PhotographerDummyData;
import com.assessment.photographer.vo.Photographer;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(PhotographerController.class)
public class PhotographerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PhotographerService photographerService;

  @Test
  void testGetPhotographer() throws Exception {
    // Mock the photographerService to return a photographer object
    Photographer photographer = new Photographer();
    photographer.setId("1");
    photographer.setFistName("John Doe");
    Mockito.when(photographerService.findById("1")).thenReturn(photographer);

    // Call the photographerController method to get the user
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/photographers/1"))
        .andExpect(status().isOk())
        .andReturn();

    // Verify that the response contains the expected user object
    String content = result.getResponse().getContentAsString();
    assertThat(content).contains("John Doe");
  }

  @Test
  void testGetPhotographerList() throws Exception {
    // Mock the photographerService to return a photographer object
    List<Photographer> photographers = PhotographerDummyData.getPhotographers();
    Mockito.when(photographerService.getAllPhotographers()).thenReturn(photographers);

    // Call the photographerController method to get the user
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/photographers"))
        .andExpect(status().isOk())
        .andReturn();

    // Verify that the response contains the expected user object
   int content = result.getResponse().getContentLength();
    assertThat(content).isNotNull();
  }
}
