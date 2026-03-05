-- Nettoyage
DROP TABLE IF EXISTS dish_ingredient;
DROP TABLE IF EXISTS ingredient;
DROP TABLE IF EXISTS dish;
DROP TYPE IF EXISTS unit_type;
DROP TYPE IF EXISTS dish_type;

-- Types pour les menus et les mesures
CREATE TYPE dish_type AS ENUM ('START', 'MAIN', 'DESSERT', 'SIDE');
CREATE TYPE unit_type AS ENUM ('KG', 'L', 'PCS');

-- TABLE 1 : Les Plats
CREATE TABLE dish (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      type dish_type NOT NULL,
                      unit_price DOUBLE PRECISION -- Prix de vente au client
);

-- TABLE 2 : Les Ingrédients
CREATE TABLE ingredient (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL,
                            unit_price DOUBLE PRECISION NOT NULL -- Prix d'achat de l'ingrédient
);

-- TABLE 3 : La Liaison (ManyToMany)
CREATE TABLE dish_ingredient (
                                 id_dish INT REFERENCES dish(id),
                                 id_ingredient INT REFERENCES ingredient(id),
                                 quantity_required DOUBLE PRECISION NOT NULL,
                                 unit unit_type NOT NULL,
                                 PRIMARY KEY (id_dish, id_ingredient)
);