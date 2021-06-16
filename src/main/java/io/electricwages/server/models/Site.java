package io.electricwages.server.models;


import javax.persistence.*;

@Entity
@Table(name = "site")
public class Site {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;
  private String address;
  private String shortName;
  private String type;
  private String generalNote;

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public String getGeneralNote() {
    return generalNote;
  }
  public void setGeneralNote(String generalNote) {
    this.generalNote = generalNote;
  }
  public String getShortName() {
    return shortName;
  }
  public void setShortName(String shortName) {
    this.shortName = shortName;
  }
}