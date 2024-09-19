CREATE DATABASE orderdb;

\c microcommerce;

CREATE TABLE tbl_product (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         price INTEGER  NOT NULL
);

CREATE TABLE tbl_orders (
                         id SERIAL PRIMARY KEY,
                         product_id BIGINT NOT NULL,
                         quantity INTEGER NOT NULL,
                         FOREIGN KEY (product_id) REFERENCES product (id)
);

CREATE TABLE tbl_stock (
                       id SERIAL PRIMARY KEY,
                       product_id BIGINT NOT NULL,
                       quantity INTEGER NOT NULL,
                       FOREIGN KEY (product_id) REFERENCES product (id)
);


-- Örnek Veri Eklemek İçin
INSERT INTO tbl_product (name, price) VALUES ('Product 1', 100);
INSERT INTO tbl_product (name, price) VALUES ('Product 2', 200);

INSERT INTO tbl_stock (product_id, quantity) VALUES (1, 100);
INSERT INTO tbl_stock (product_id, quantity) VALUES (2, 200);

INSERT INTO tbl_orders (product_id, quantity) VALUES (1, 5);
INSERT INTO tbl_orders (product_id, quantity) VALUES (2, 10);

