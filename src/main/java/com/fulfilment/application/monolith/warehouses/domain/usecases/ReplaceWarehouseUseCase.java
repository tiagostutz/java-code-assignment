package com.fulfilment.application.monolith.warehouses.domain.usecases;

import com.fulfilment.application.monolith.warehouses.domain.models.Warehouse;
import com.fulfilment.application.monolith.warehouses.domain.ports.ReplaceWarehouseOperation;
import com.fulfilment.application.monolith.warehouses.domain.ports.WarehouseStore;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReplaceWarehouseUseCase implements ReplaceWarehouseOperation {

  private final WarehouseStore warehouseStore;
  private final WarehouseValidator warehouseValidator;

  public ReplaceWarehouseUseCase(
      WarehouseStore warehouseStore, WarehouseValidator warehouseValidator) {
    this.warehouseStore = warehouseStore;
    this.warehouseValidator = warehouseValidator;
  }

  @Override
  public Warehouse replace(Warehouse newWarehouse) throws DomainValidationException {

    // validate the warehouse basic information
    var occurences = warehouseValidator.validate(newWarehouse);

    // validate whether the new warehouse has a capacity can handle the existing stock
    var existingWarehouse = warehouseStore.findByBusinessUnitCode(newWarehouse.businessUnitCode);
    if (existingWarehouse != null) {
      if (existingWarehouse.capacity < newWarehouse.stock) {
        ValidationOccurence occurence = new ValidationOccurence();
        occurence.details = "Warehouse capacity must be greater than or equal to the current stock";
        occurences.add(occurence);
      }

      // validate whether the new warehouse has the same stock as the existing warehouse
      if (existingWarehouse.stock != newWarehouse.stock) {
        ValidationOccurence occurence = new ValidationOccurence();
        occurence.details = "Warehouse stock must be the same as the existing warehouse";
        occurences.add(occurence);
      }
    }

    if (!occurences.isEmpty()) {
      throw new DomainValidationException(occurences);
    }

    return warehouseStore.update(newWarehouse);
  }
}
