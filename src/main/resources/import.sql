INSERT INTO productActiveRecord(id, name) VALUES (1, 'TONSTAD');
INSERT INTO productActiveRecord(id, name) VALUES (2, 'KALLAX');
INSERT INTO productActiveRecord(id, name) VALUES (3, 'BESTÅ');
ALTER SEQUENCE productActiveRecord_seq RESTART WITH 4;

-- force using the same if for entity and repository to facilitate testing
INSERT INTO product(id, name) VALUES (1, 'TONSTAD');
INSERT INTO product(id, name) VALUES (2, 'KALLAX');
INSERT INTO product(id, name) VALUES (3, 'BESTÅ');
ALTER SEQUENCE product_seq RESTART WITH 4;
