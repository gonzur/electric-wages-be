package io.timetable.server.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

@RestController
public class WeeklyTimeReportController {
  private FluxSink<String> something;
  @GetMapping
  public Mono<String> getWeeklyReport(@RequestParam ArrayList<Date> range) {
    Flux.<String>push((sink)->{
      this.something = sink;
    });

    this.something.next("hello");
    return Mono.just("placeholder");
  }
}
