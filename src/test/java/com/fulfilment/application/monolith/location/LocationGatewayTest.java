package com.fulfilment.application.monolith.location;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fulfilment.application.monolith.warehouses.domain.models.Location;
import org.junit.jupiter.api.Test;

public class LocationGatewayTest {

  @Test
  public void testWhenResolveExistingLocationShouldReturn() {
    // given
    LocationGateway locationGateway = new LocationGateway();

    // when
    Location location = locationGateway.resolveByIdentifier("ZWOLLE-001");

    // then
    assertEquals(location.identification, "ZWOLLE-001");
  }

  @Test
  public void testWhenResolveNonExistingLocationShouldThrowException() {
    // given
    LocationGateway locationGateway = new LocationGateway();

    // when
    IllegalArgumentException exception =
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> locationGateway.resolveByIdentifier("NON-EXISTING"));

    // then
    assertEquals(exception.getMessage(), "Location not found");
  }
}
