# Briefing

This application is a very simplified implementation of a Warehouse colocation management system.

Basically, we have 4 entities:
* `Location` represents a geographical place, a city
* `Store` represents a physical store, where `Products` are stored and sold
* `Warehouse` represents a place where `Products` are kept to eventually be distributed to the `Store`
* `Product` represent the goods actually sold to customers in the `Store`

This system is focused on the Warehouse and Store unit creation and management. So, this is not related to the internal operations of each, but, rather, to the basic creation and management of those and some operations related to how they relate to each other.

The implementation tasks for you to tackle can be [located at CODE_ASSINGMENT.md](CODE_ASSIGNMENT.md)