package com.fulfilment.application.monolith.warehouses.domain.models;

public class Location {
  public String identification;

  public int maxNumberOfWarehouses;

  public Location(String identification, int maxNumberOfWarehouses) {
    this.identification = identification;
    this.maxNumberOfWarehouses = maxNumberOfWarehouses;
  }
}
