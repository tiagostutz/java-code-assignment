package com.fulfilment.application.monolith.stores;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class StoreEndpointTest {

  @Test
  public void testCreateStore() {
    final String path = "stores";

    // Delete the TONSTAD:
    Store createRequest = new Store();
    createRequest.name = "HENGELO";
    createRequest.quantityProductsInStock = 10;

    // post and capture the returned id to update and delete later
    var createdStoreId =
        given()
            .contentType(ContentType.JSON)
            .body(createRequest)
            .when()
            .post(path)
            .then()
            .statusCode(201)
            .extract()
            .as(Store.class)
            .id;

    assertNotNull(createdStoreId);

    // Update the store:
    Store updateRequest = new Store();
    updateRequest.name = "HENGELO";
    updateRequest.quantityProductsInStock = 20;

    given()
        .contentType(ContentType.JSON)
        .body(updateRequest)
        .when()
        .put(path + "/" + createdStoreId)
        .then()
        .statusCode(200);

    // Delete the store:
    given().when().delete(path + "/" + createdStoreId).then().statusCode(204);
  }
}
