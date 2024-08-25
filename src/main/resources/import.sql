INSERT INTO storeActiveRecord(id, name, quantityProductsInStock) VALUES (1, 'TONSTAD', 10);
INSERT INTO storeActiveRecord(id, name, quantityProductsInStock) VALUES (2, 'KALLAX', 5);
INSERT INTO storeActiveRecord(id, name, quantityProductsInStock) VALUES (3, 'BESTÅ', 3);
ALTER SEQUENCE storeActiveRecord_seq RESTART WITH 4;

-- force using the same if for entity and repository to facilitate testing
INSERT INTO product(id, name, stock) VALUES (1, 'TONSTAD', 10);
INSERT INTO product(id, name, stock) VALUES (2, 'KALLAX', 5);
INSERT INTO product(id, name, stock) VALUES (3, 'BESTÅ', 3);
ALTER SEQUENCE product_seq RESTART WITH 4;
