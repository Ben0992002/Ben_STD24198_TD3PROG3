-- On remplit les ingrédients
INSERT INTO ingredient (name, unit_price) VALUES
                                              ('Laitue', 800.0),
                                              ('Tomate', 600.0),
                                              ('Poulet', 5000.0),
                                              ('Chocolat', 4000.0);

-- On remplit les plats
INSERT INTO dish (name, type, unit_price) VALUES
                                              ('Salade fraîche', 'START', 2000.0),
                                              ('Poulet grillé', 'MAIN', 15000.0),
                                              ('Gâteau au chocolat', 'DESSERT', 8000.0),
                                              ('Salade de fruits', 'DESSERT', NULL);

-- On lie les ingrédients aux plats (Les recettes)
-- Salade fraîche (ID 1) : 0.2kg Laitue (ID 1) + 0.15kg Tomate (ID 2)
INSERT INTO dish_ingredient VALUES (1, 1, 0.2, 'KG'), (1, 2, 0.15, 'KG');

-- Poulet grillé (ID 2) : 0.9kg Poulet (ID 3)
INSERT INTO dish_ingredient VALUES (2, 3, 0.9, 'KG');

-- Gâteau au chocolat (ID 3) : 0.35kg Chocolat (ID 4)
INSERT INTO dish_ingredient VALUES (3, 4, 0.35, 'KG');