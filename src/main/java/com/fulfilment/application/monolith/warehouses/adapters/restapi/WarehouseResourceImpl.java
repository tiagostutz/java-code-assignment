package com.fulfilment.application.monolith.warehouses.adapters.restapi;

import com.warehouse.api.WarehouseResource;
import com.warehouse.api.beans.Warehouse;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class WarehouseResourceImpl implements WarehouseResource {

  @Override
  public List<Warehouse> listAllWarehousesUnits() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listAllWarehousesUnits'");
  }

  @Override
  public Warehouse createANewWarehouseUnit(@NotNull Warehouse data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createANewWarehouseUnit'");
  }

  @Override
  public Warehouse getAWarehouseUnitByID(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAWarehouseUnitByID'");
  }
}
