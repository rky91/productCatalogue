INSERT INTO SELLER(NAME)
VALUES ('AMAZON'),
       ('FLIPKART');

INSERT INTO BRAND(NAME)
VALUES ('ADIDAS'),
       ('PUMA'),
       ('NIKE'),
       ('FILA'),
       ('SEVEN');

INSERT INTO COLOR(NAME, CODE)
VALUES ('RED', 'F30D09'),
       ('ORANGE', 'F48E05'),
       ('WHITE', 'FFFFFF'),
       ('BLACK', '000000'),
       ('GREEN', '33FF41'),
       ('BLUE', '055AF4');

INSERT INTO PRODUCT_CATEGORY(NAME)
VALUES ('SHIRT'),
       ('Trousers'),
       ('Jeans'),
       ('T-Shirt'),
       ('Jacket');

INSERT INTO PRODUCT(NAME, QUANTITY, SIZE, PRICE, BRAND_ID, SKU, COLOR_ID, PRODUCT_CATEGORY_ID, SELLER_ID)
VALUES ('Men RED Solid Round Neck T-shirt', 10, 'M', 2000, 1, 'SKUTS1', 1, 3, 1),
       ('Men ORANGE Solid Round Neck T-shirt', 15, 'M', 1200, 2, 'SKUTS2', 2, 3, 1),
       ('Men WHITE Solid POLO T-shirt', 1, 'XL', 500, 3, 'SKUTS3', 3, 3, 1),
       ('Men Black Solid Round Neck T-shirt', 4, 'S', 3500, 4, 'SKUTS4', 4, 3, 2),
       ('Men GREEN Solid POLO T-shirt', 9, 'XXL', 1100, 5, 'SKUTS5', 5, 3, 1),
       ('WHITE JEANS', 20, 'S', 2900, 4, 'SKUJN1', 3, 3, 1),
       ('BLACK JEANS', 20, 'M', 5900, 3, 'SKUJN2', 4, 3, 2),
       ('BLUE JEANS', 20, 'L', 3500, 1, 'SKUJN3', 6, 3, 1),
       ('WINDCHEATER JACKET', 19, 'S', 3000, 4, 'SKUJK1', 2, 2, 2),
       ('Men RED SHIRT', 200, 'XL', 3000, 1, 'SKUSH1', 1, 1, 1),
       ('Men ORANGE SHIRT', 200, 'L', 1000, 2, 'SKUSH2', 2, 1, 2),
       ('Men WHITE SHIRT', 200, 'XXL', 2000, 3, 'SKUSH3', 3, 1, 2),
       ('Men BLACK SHIRT', 200, 'M', 4000, 4, 'SKUSH4', 4, 1, 1),
       ('Men BLUE SHIRT', 200, 'S', 700, 5, 'SKUSH5', 5, 1, 2);