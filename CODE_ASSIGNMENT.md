# Code Assignment

Your assignment is to implement some missing pieces on this code base and answer some small questions about possible changes and improvements on code. Those implementations are listed below.

Usually, this assignment takes 1h-2h to be completed by a senior, but with the help of an AI assistant, you could do it even faster 🤖

Some parts of the code contain methods that are already defined but currently throw `UnsupportedOperationException`. Other methods are implemented but incomplete, and there may be some missing pieces. Your goal is to fill in all these gaps, ensuring the code works correctly with all the specified endpoints, while respecting the constraints and validations outlined in this file.

Also, just a minimum set of tests are present, feel free to bring more as well to craft the tests related to the implementations you will work on.

**Before starting the tasks, it is important to [read the brief overview](BRIEFING.md) that provides essential information about the domain, entities, business rules, and other relevant details.**

## Tasks

### 1. Location

> this code is located under package `com.fulfilment.application.monolith.location`

On the class `LocationGateway`, implement the method `resolveByIdentifier`. We advise you to start by this one as this is the most simple and is a pre-requirement for the next tasks. This is just a warm-up task 😃

### 2. Store

> this code is located under package `com.fulfilment.application.monolith.stores`

Adjust the `StoreResource` operations to make sure that the `LegacyStoreManagerGateway` calls that happens there takes place after the changes on the **are commited to the database**, to guarantee the downstream legacy system is receiving a confirmed data from us.

If you check the `StoreResource` class and methods, you notice that it uses `LegacyStoreManagerGateway` instance. This is simulating the integration with a legacy system with which we would keep syncing the `Stores` register handled on our system. Although the initial implementation is working properly, we need a implementation that **guarantees** that the changes on the `Store` entity is propagated only after it is effectively stored on database.

### 3. Warehouse

> this code is located under package `com.fulfilment.application.monolith.warehouse`

#### Implement Warehouse Creation and Replacement logic

Locate and implement the use cases for Creating, Replacing and Archiving a Warehouse. The validations and constraints that apply are the following:

**Business Unit Code Verification**

Ensure the specified business unit code for the warehouse doesn't already exists.

**Location Validation**

Confirm the warehouse location is valid, meaning it must be an existing valid location.

**Warehouse Creation Feasibility**

Check if a new warehouse can be created at the specified location or if the maximum number of warehouses has already been reached.

**Capacity and Stock Validation** 

Validate the warehouse capacity, ensuring it does not exceed the maximum capacity associated with the location and that it can handle the stock informed.

#### Additional Validations for Replacing a Warehouse

**Capacity Accommodation**

Ensure the new warehouse's capacity can accommodate the stock from the warehouse being replaced.

**Stock Matching**

Confirm that the stock of the new warehouse matches the stock of the previous warehouse.

## BONUS task

Implement the feature of associating `Warehouses` as fullfilment units of certain `Products` to determined `Stores`.

Constraints:

1. Each `Product` can be fulfilled by maximum of 2 different `Warehouses` per `Store`

2. Each `Store` can be fulfilled by maximum of 3 different `Warehouses`

3. Each `Warehouse` can store maxium 5 types of `Products`