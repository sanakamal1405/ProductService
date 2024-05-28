CREATE TABLE category
(
    id    BIGINT NOT NULL,
    title VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE identifier
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NULL,
    updated_at datetime NULL,
    CONSTRAINT pk_identifier PRIMARY KEY (id)
);

CREATE TABLE products
(
    id            BIGINT NOT NULL,
    title         VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    category_id   BIGINT NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

ALTER TABLE category
    ADD CONSTRAINT FK_CATEGORY_ON_ID FOREIGN KEY (id) REFERENCES identifier (id);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_ID FOREIGN KEY (id) REFERENCES identifier (id);