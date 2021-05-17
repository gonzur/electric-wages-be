package io.electricwages.server.models;

public class Employee {
  private String id;
  private String firstName;
  private String lastName;
  private String postition;

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getPostition() {
    return postition;
  }
  public void setPostition(String postition) {
    this.postition = postition;
  }
}
