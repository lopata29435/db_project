INSERT INTO category (name, parent_category_id) VALUES ('Electronics', NULL);
INSERT INTO category (name, parent_category_id) VALUES ('Food', NULL);
INSERT INTO category (name, parent_category_id) VALUES ('Furniture', NULL);

INSERT INTO category (name, parent_category_id) VALUES ('Laptops', (SELECT id FROM category WHERE name = 'Electronics'));
INSERT INTO category (name, parent_category_id) VALUES ('Fruits', (SELECT id FROM category WHERE name = 'Food'));

INSERT INTO location (name) VALUES ('Living Room');
INSERT INTO location (name) VALUES ('Kitchen');
INSERT INTO location (name) VALUES ('Warehouse');

INSERT INTO supplier (name, contact_info) VALUES ('BestBuy', 'support@bestbuy.com');
INSERT INTO supplier (name, contact_info) VALUES ('Whole Foods', 'contact@wholefoods.com');
INSERT INTO supplier (name, contact_info) VALUES ('IKEA', 'help@ikea.com');

INSERT INTO item (name, description, quantity, expiry_date, category_id, location_id, supplier_id)
VALUES (
    'MacBook Pro',
    'M1 Pro 16-inch',
    5,
    NULL,
    (SELECT id FROM category WHERE name = 'Laptops'),
    (SELECT id FROM location WHERE name = 'Warehouse'),
    (SELECT id FROM supplier WHERE name = 'BestBuy')
);

INSERT INTO item (name, description, quantity, expiry_date, category_id, location_id, supplier_id)
VALUES (
    'Apple',
    'Red Delicious',
    50,
    CURRENT_DATE + INTERVAL '14 days',
    (SELECT id FROM category WHERE name = 'Fruits'),
    (SELECT id FROM location WHERE name = 'Kitchen'),
    (SELECT id FROM supplier WHERE name = 'Whole Foods')
);

INSERT INTO inventory_history (item_id, change_type, quantity_changed, change_date)
VALUES (
    (SELECT id FROM item WHERE name = 'MacBook Pro'),
    'ADD',
    5,
    CURRENT_TIMESTAMP
);

