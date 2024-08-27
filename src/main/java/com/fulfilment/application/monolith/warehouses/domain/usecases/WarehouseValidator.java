package com.fulfilment.application.monolith.warehouses.domain.usecases;

import com.fulfilment.application.monolith.warehouses.domain.models.Warehouse;
import com.fulfilment.application.monolith.warehouses.domain.ports.LocationResolver;
import com.fulfilment.application.monolith.warehouses.domain.ports.WarehouseStore;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class WarehouseValidator {

  @Inject private LocationResolver locationResolver;
  @Inject private WarehouseStore warehouseStore;

  public List<ValidationOccurence> validate(Warehouse warehouse) {
    List<ValidationOccurence> occurences = validateLocation(warehouse);
    occurences.addAll(validateBusinessUnitCode(warehouse.businessUnitCode));
    occurences.addAll(validateCapacity(warehouse));

    return occurences;
  }

  private List<ValidationOccurence> validateBusinessUnitCode(String businessUnitCode) {
    List<ValidationOccurence> occurences = new ArrayList<>();

    if (businessUnitCode == null || businessUnitCode.isBlank()) {
      ValidationOccurence occurence = new ValidationOccurence();
      occurence.details = "Business unit code is required";
      occurences.add(occurence);
    }

    // check whether the business unit code is unique
    var existingWarehouse = warehouseStore.findByBusinessUnitCode(businessUnitCode);
    if (existingWarehouse != null) {
      ValidationOccurence occurence = new ValidationOccurence();
      occurence.details = "Business unit code must be unique";
      occurences.add(occurence);
    }

    return occurences;
  }

  private List<ValidationOccurence> validateLocation(Warehouse warehouse) {
    List<ValidationOccurence> occurences = new ArrayList<>();

    var locationIdentifier = warehouse.location;
    var newWarehouseCapacity = warehouse.capacity;

    if (locationIdentifier == null || locationIdentifier.isBlank()) {
      ValidationOccurence occurence = new ValidationOccurence();
      occurence.details = "Location is required";
      occurences.add(occurence);
    }

    // check whether the location exists
    var existingLocation = locationResolver.resolveByIdentifier(locationIdentifier);
    if (existingLocation == null) {
      ValidationOccurence occurence = new ValidationOccurence();
      occurence.details = String.format("Location %s doesn't exist", locationIdentifier);
      occurences.add(occurence);
    } else {
      // check whether the number of warehouses in that location is already at the maximum
      var existingWarehouses = warehouseStore.findByLocation(locationIdentifier);
      if (existingWarehouses.size() >= existingLocation.maxNumberOfWarehouses) {
        ValidationOccurence occurence = new ValidationOccurence();
        occurence.details =
            String.format(
                "Location %s already has the maximum number of warehouses", locationIdentifier);
        occurences.add(occurence);
      }

      // check whether the maximum capacity of the location is exceeded
      var currentTotalCapacity = existingWarehouses.stream().mapToInt(w -> w.capacity).sum();
      if ((currentTotalCapacity + newWarehouseCapacity) >= existingLocation.maxCapacity) {
        ValidationOccurence occurence = new ValidationOccurence();
        occurence.details =
            String.format(
                "Location %s has exceeded its maximum capacity of %d",
                locationIdentifier, existingLocation.maxCapacity);
        occurences.add(occurence);
      }
    }

    return occurences;
  }

  private List<ValidationOccurence> validateCapacity(Warehouse warehouse) {
    var capacity = warehouse.capacity;
    var stock = warehouse.stock;

    List<ValidationOccurence> occurences = new ArrayList<>();

    if (capacity == null || capacity <= 0) {
      ValidationOccurence occurence = new ValidationOccurence();
      occurence.details = "Capacity can't be negative";
      occurences.add(occurence);
    }

    // check whether the capacity can accommodate the stock
    if (capacity != null && capacity > 0) {
      if (capacity < stock) {
        ValidationOccurence occurence = new ValidationOccurence();
        occurence.details = "Capacity can't be less than stock";
        occurences.add(occurence);
      }
    }

    return occurences;
  }
}
