package com.fulfilment.application.monolith.warehouses.domain.usecases;

import java.util.List;

public class DomainValidationException extends Exception {
  public List<ValidationOccurence> occurences;

  public DomainValidationException(List<ValidationOccurence> occurences) {
    this.occurences = occurences;
  }
}
