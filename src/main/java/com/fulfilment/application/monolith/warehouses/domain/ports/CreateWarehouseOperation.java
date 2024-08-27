package com.fulfilment.application.monolith.warehouses.domain.ports;

import com.fulfilment.application.monolith.warehouses.domain.models.Warehouse;
import com.fulfilment.application.monolith.warehouses.domain.usecases.DomainValidationException;

public interface CreateWarehouseOperation {
  Warehouse create(Warehouse warehouse) throws DomainValidationException;
}
