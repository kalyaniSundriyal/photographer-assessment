package com.assessment.photographer.controller;

import com.assessment.photographer.service.PhotographerService;
import com.assessment.photographer.vo.Photographer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/photographers"})
public class PhotographerController {

  @Autowired
  private final PhotographerService photographerService;

  /**
   * Preferring constructor over setter for auto-wiring
   * @param photographerService
   */
  @Autowired
  public PhotographerController(PhotographerService photographerService) {
    this.photographerService = photographerService;
  }

  @GetMapping
  public ResponseEntity<List<Photographer>> getProducts() {
    List<Photographer> products = photographerService.getAllPhotographers();
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  @GetMapping("/{photographerID}")
  public ResponseEntity<Photographer> getPhotographerById(@PathVariable String photographerID) {
    Photographer photographer = photographerService.findById(photographerID);
    return new ResponseEntity<>(photographer, HttpStatus.OK);
  }

  @GetMapping("/event/{eventType}")
  public ResponseEntity<List<Photographer>> getPhotographerByEventType(@PathVariable String eventType) {
    List<Photographer> photographerList = photographerService.findByEventType(eventType);
    return new ResponseEntity<>(photographerList, HttpStatus.OK);
  }
}
