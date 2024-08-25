package com.warehouse.application.monolith.activerecord;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Cacheable
public class StoreActiveRecord extends PanacheEntity {

  @Column(length = 40, unique = true)
  public String name;

  public int quantityProductsInStock;

  public StoreActiveRecord() {}

  public StoreActiveRecord(String name) {
    this.name = name;
  }
}
