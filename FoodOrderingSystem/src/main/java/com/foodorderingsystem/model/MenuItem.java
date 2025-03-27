package com.foodorderingsystem.model;

public class MenuItem {
  //attributes.
  private String name;
  private double price;


  //Parameterized Constructor
  public MenuItem(String name, double price) {
      this.name = name;
      this.price = price;
  }

  //getters
  public String getName() {
      return name;
  }

  public double getPrice() {
      return price;
  }

  //method for displaying items.
  @Override
  public String toString() {
      return name + " : INR " + price;
  }

}
