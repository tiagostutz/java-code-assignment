# Code Assignment

You will have to implement some missing pieces on the code and answer some small questions about possible changes and improvements on code.

**Before starting the tasks, it is important to [read the brief overview](BRIEFING.md) that provides essential information about the domain, entities, business rules, and other relevant details.**

## 1. Location

> this code is located under package `com.fulfilment.application.monolith.location`

There's only one simple implementation to be done on class `LocationGateway`. It is the method `resolveByIdentifier`. We advise you to start by this one as this is the most simple and is a pre-requirement for the next tasks.

## 2. Warehouse

> this code is located under package `com.fulfilment.application.monolith.warehouse`

### Implement Warehouse Creation and Replacement logic

Locate and implement the use cases for Creating, Replacing and Archiving a Warehouse. The validations and constraints that apply are the following:

**Business Unit Code Verification**

Ensure the specified business unit code for the warehouse doesn't already exists.

**Location Validation**

Confirm the warehouse location is valid, meaning it must be an existing valid location.

**Warehouse Creation Feasibility**

Check if a new warehouse can be created at the specified location or if the maximum number of warehouses has already been reached.

**Capacity and Stock Validation** 

Validate the warehouse capacity, ensuring it does not exceed the maximum capacity associated with the location and that it can handle the stock informed.

### Additional Validations for Replacing a Warehouse

**Capacity Accommodation**

Ensure the new warehouse's capacity can accommodate the stock from the warehouse being replaced.

**Stock Matching**

Confirm that the stock of the new warehouse matches the stock of the previous warehouse.