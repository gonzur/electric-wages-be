package io.electricwages.server.models;

import java.util.ArrayList;
import java.util.Date;

public class DailyTimeReport {
  private String id;
  private Date date;
  private double hours;
  private Site site;
  private ArrayList<Employee> crew;

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public double getHours() {
    return hours;
  }
  public void setHours(double hours) {
    this.hours = hours;
  }
  public Site getSite() {
    return site;
  }
  public void setSite(Site site) {
    this.site = site;
  }
  public ArrayList<Employee> getCrew() {
    return crew;
  }
  public void setCrew(ArrayList<Employee> crew) {
    this.crew = crew;
  }
}
