CREATE DATABASE microcommerce;

\c microcommerce;

CREATE TABLE product (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         stock INTEGER NOT NULL
);

CREATE TABLE "order" (
                         id SERIAL PRIMARY KEY,
                         product_id BIGINT NOT NULL,
                         quantity INTEGER NOT NULL,
                         FOREIGN KEY (product_id) REFERENCES product (id)
);

CREATE TABLE stock (
                       id SERIAL PRIMARY KEY,
                       product_id BIGINT NOT NULL,
                       quantity INTEGER NOT NULL,
                       FOREIGN KEY (product_id) REFERENCES product (id)
);


-- Örnek Veri Eklemek İçin
INSERT INTO product (name, stock) VALUES ('Product 1', 100);
INSERT INTO product (name, stock) VALUES ('Product 2', 200);

INSERT INTO stock (product_id, quantity) VALUES (1, 100);
INSERT INTO stock (product_id, quantity) VALUES (2, 200);

INSERT INTO "order" (product_id, quantity) VALUES (1, 5);
INSERT INTO "order" (product_id, quantity) VALUES (2, 10);

