package com.fulfilment.application.monolith.warehouses.domain.ports;

import com.fulfilment.application.monolith.warehouses.domain.models.Location;
import java.util.List;

public interface LocationResolver {
  List<Location> resolveByIdentifier(String identifier);
}
