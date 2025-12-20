CREATE TABLE category (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    parent_category_id BIGINT,
    CONSTRAINT fk_category_parent FOREIGN KEY (parent_category_id) REFERENCES category (id)
);

CREATE TABLE location (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE supplier (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact_info TEXT
);

CREATE TABLE item (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    quantity INTEGER NOT NULL DEFAULT 0,
    expiry_date DATE,
    category_id BIGINT,
    location_id BIGINT,
    supplier_id BIGINT,
    CONSTRAINT fk_item_category FOREIGN KEY (category_id) REFERENCES category (id),
    CONSTRAINT fk_item_location FOREIGN KEY (location_id) REFERENCES location (id),
    CONSTRAINT fk_item_supplier FOREIGN KEY (supplier_id) REFERENCES supplier (id)
);

CREATE TABLE inventory_history (
    id BIGSERIAL PRIMARY KEY,
    item_id BIGINT NOT NULL,
    change_type VARCHAR(50) NOT NULL,
    quantity_changed INTEGER NOT NULL,
    change_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_history_item FOREIGN KEY (item_id) REFERENCES item (id)
);

