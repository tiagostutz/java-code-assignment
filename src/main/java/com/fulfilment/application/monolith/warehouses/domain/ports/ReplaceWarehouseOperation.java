package com.fulfilment.application.monolith.warehouses.domain.ports;

import com.fulfilment.application.monolith.warehouses.domain.models.Warehouse;
import com.fulfilment.application.monolith.warehouses.domain.usecases.DomainValidationException;

public interface ReplaceWarehouseOperation {
  Warehouse replace(Warehouse warehouse) throws DomainValidationException;
}
