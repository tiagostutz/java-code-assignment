package com.fulfilment.application.monolith.stores;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@ApplicationScoped
public class StoreService {

  @Transactional(value = TxType.REQUIRES_NEW)
  public Store create(Store store) {
    store.persist();
    return store;
  }

  @Transactional(value = TxType.REQUIRES_NEW)
  public Store update(Long id, Store updatedStore) {
    Store entity = Store.findById(id);

    if (entity == null) {
      return null;
    }
    entity.name = updatedStore.name;
    entity.quantityProductsInStock = updatedStore.quantityProductsInStock;

    entity.persist();
    return entity;
  }

  @Transactional(value = TxType.REQUIRES_NEW)
  public Store patch(Long id, Store updatedStore) {

    Store entity = Store.findById(id);

    if (entity == null) {
      return null;
    }

    if (entity.name != null) {
      entity.name = updatedStore.name;
    }

    if (entity.quantityProductsInStock != 0) {
      entity.quantityProductsInStock = updatedStore.quantityProductsInStock;
    }

    entity.persist();
    return entity;
  }

  @Transactional(value = TxType.REQUIRES_NEW)
  public Store delete(Long id) {
    Store store = Store.findById(id);
    if (store == null) {
      return null;
    }
    store.delete();
    return store;
  }
}
