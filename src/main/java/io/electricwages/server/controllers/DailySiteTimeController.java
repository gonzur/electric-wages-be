package io.electricwages.server.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.electricwages.server.models.DailyTimeReport;

@RestController("/dailySiteTime/")
public class DailySiteTimeController {
  @PostMapping("/submit")
  public void submitTime(@RequestBody ArrayList<DailyTimeReport> reports) {
    
  }
}
