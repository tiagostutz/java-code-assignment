package com.inventorix.warehouse.application.monolith.repository;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Cacheable
public class Product {

  @Id @GeneratedValue public Long id;

  @Column(length = 40, unique = true)
  public String name;

  public Product() {}

  public Product(String name) {
    this.name = name;
  }
}
