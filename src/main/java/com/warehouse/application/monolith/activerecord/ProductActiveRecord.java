package com.warehouse.application.monolith.activerecord;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Cacheable
public class ProductActiveRecord extends PanacheEntity {

  @Column(length = 40, unique = true)
  public String name;

  @Column(nullable = true)
  public String description;

  @Column(precision = 10, scale = 2, nullable = true)
  public BigDecimal price;

  public int stock;

  public ProductActiveRecord() {}

  public ProductActiveRecord(String name) {
    this.name = name;
  }
}
