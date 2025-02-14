-- Product database

DROP TABLE IF EXISTS Products;
CREATE TABLE Products (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    price REAL CHECK ( price >= 0 ),
    upc TEXT
);


DROP TABLE IF EXISTS Sku;
CREATE TABLE Sku (
    sku TEXT,
    upc TEXT
);
