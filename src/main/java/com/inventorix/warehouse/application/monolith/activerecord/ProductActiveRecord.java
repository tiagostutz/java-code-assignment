package com.inventorix.warehouse.application.monolith.activerecord;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Cacheable
public class ProductActiveRecord extends PanacheEntity {

  @Column(length = 40, unique = true)
  public String name;

  public ProductActiveRecord() {}

  public ProductActiveRecord(String name) {
    this.name = name;
  }
}
