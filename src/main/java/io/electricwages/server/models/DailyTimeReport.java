package io.electricwages.server.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "daily_time_report")
public class DailyTimeReport {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;
  private Date date;
  private double hours;
  @ManyToOne
  private Site site;

  @OneToMany(mappedBy = "report")
  private Set<EmployeeHour> crewHours;

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
  public Set<EmployeeHour> getCrewHours() {
    return crewHours;
  }
  public void setCrewHours(Set<EmployeeHour> crewHours) {
    this.crewHours = crewHours;
  }
}
