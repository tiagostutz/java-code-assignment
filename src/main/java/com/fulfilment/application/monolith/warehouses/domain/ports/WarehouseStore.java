package com.fulfilment.application.monolith.warehouses.domain.ports;

import com.fulfilment.application.monolith.warehouses.domain.models.Warehouse;
import java.util.List;

public interface WarehouseStore {
  Warehouse create(Warehouse warehouse);

  Warehouse update(Warehouse warehouse);

  Warehouse remove(Warehouse warehouse);

  Warehouse findByBusinessUnitCode(String buCode);

  List<Warehouse> findByLocation(String location);
}
