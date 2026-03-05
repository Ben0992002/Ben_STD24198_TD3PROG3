-- 1. Création de la base de données
CREATE DATABASE restaurant_db;

-- 2. Création d'un utilisateur spécifique pour l'application
-- avec son mot de passe
CREATE USER restaurant_user WITH ENCRYPTED PASSWORD '123456';

-- 3. Donner tous les privilèges sur cette base à notre utilisateur
GRANT ALL PRIVILEGES ON DATABASE restaurant_db TO restaurant_user;

-- 4. Connexion à la base pour donner les droits sur le schéma (Important !)
\c restaurant_db;

-- Donner les droits sur le schéma 'public'
GRANT ALL ON SCHEMA public TO restaurant_user;

-- Autoriser l'usage des séquences (pour les IDs auto-incrémentés SERIAL)
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO restaurant_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO restaurant_user;