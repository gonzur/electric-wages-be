package io.electricwages.server.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.electricwages.server.models.Site;

@RestController
public class SiteController {
  @PostMapping("/site")
  public void createSite(@RequestBody Site site) {
    
  }

  @GetMapping("/site")
  public Site getSite(@RequestParam Optional<String> id, @RequestParam Optional<String> address, @RequestParam Optional<String> shortName) {

    return new Site(); // placeholder
  }
  
}
