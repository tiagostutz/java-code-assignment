package com.fulfilment.application.monolith.warehouses.adapters.database;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Cacheable
public class DbWarehouse {

  @Id @GeneratedValue public Long id;

  public String businessUnitCode;

  public String location;

  public Integer capacity;

  public Integer stock;

  public LocalDateTime creationAt;

  public LocalDateTime archivedAt;

  public DbWarehouse() {}
}
