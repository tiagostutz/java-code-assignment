package com.fulfilment.application.monolith.location;

import com.fulfilment.application.monolith.warehouses.domain.models.Location;
import com.fulfilment.application.monolith.warehouses.domain.ports.LocationResolver;
import java.util.ArrayList;
import java.util.List;

public class LocationGateway implements LocationResolver {

  private static final List<Location> locations = new ArrayList<>();

  static {
    locations.add(new Location("ZWOLLE-001", 1));
    locations.add(new Location("ZWOLLE-002", 2));
    locations.add(new Location("AMSTERDAM-001", 5));
    locations.add(new Location("AMSTERDAM-002", 3));
    locations.add(new Location("TILBURG-001", 1));
    locations.add(new Location("HELMOND-001", 1));
    locations.add(new Location("EINDHOVEN-001", 2));
    locations.add(new Location("VETSBY-001", 1));
  }

  @Override
  public Location resolveByIdentifier(String identifier) {
    return locations.stream()
        .filter(location -> location.identification.equals(identifier))
        .findFirst()
        .orElse(null);
  }
}
