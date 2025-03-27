package com.foodorderingsystem.model;
//customer 
public class User {
  private String name;

//Constructor
  public User(String name) {
      this.name = name;
  }

  //getter 
  public String getName() {
      return name;
  }

  @Override
  public String toString() {
      return "User: " + name;
  }
}