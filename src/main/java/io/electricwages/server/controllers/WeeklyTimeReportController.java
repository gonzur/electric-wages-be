package io.electricwages.server.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeeklyTimeReportController {
  private String something;

  @GetMapping("/weeklyReport")
  public String getWeeklyReport(@RequestParam ArrayList<Date> range) {
    return "";
  }
}
