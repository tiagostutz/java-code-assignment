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
    List<ValidationOccurence> occurences = validateLocation(warehouse.location);
    occurences.addAll(validateBusinessUnitCode(warehouse.businessUnitCode));
    occurences.addAll(validateCapacity(warehouse.capacity));

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

  private List<ValidationOccurence> validateLocation(String location) {
    List<ValidationOccurence> occurences = new ArrayList<>();

    if (location == null || location.isBlank()) {
      ValidationOccurence occurence = new ValidationOccurence();
      occurence.details = "Location is required";
      occurences.add(occurence);
    }

    // check whether the location exists
    var existingLocation = locationResolver.resolveByIdentifier(location);
    if (existingLocation == null) {
      ValidationOccurence occurence = new ValidationOccurence();
      occurence.details = String.format("Location %s doesn't exist", location);
      occurences.add(occurence);
    } else {
      // check whether the number of warehouses in that location is already at the maximum
      var existingWarehouses = warehouseStore.findByLocation(location);
      if (existingWarehouses.size() >= existingLocation.maxNumberOfWarehouses) {
        ValidationOccurence occurence = new ValidationOccurence();
        occurence.details =
            String.format("Location %s already has the maximum number of warehouses", location);
        occurences.add(occurence);
      }
    }

    // check whether the number of warehouses in that location is already at the maximum

    return occurences;
  }

  private List<ValidationOccurence> validateCapacity(Integer capacity) {
    List<ValidationOccurence> occurences = new ArrayList<>();

    if (capacity == null || capacity <= 0) {
      ValidationOccurence occurence = new ValidationOccurence();
      occurence.details = "Capacity can't be negative";
      occurences.add(occurence);
    }

    return occurences;
  }
}
