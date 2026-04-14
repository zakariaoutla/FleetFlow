CREATE TABLE client (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(100) NOT NULL,
                        email VARCHAR(150) UNIQUE NOT NULL,
                        telephone VARCHAR(15) UNIQUE NOT NULL,
                        ville VARCHAR(255) NOT NULL
);

CREATE TABLE vehicule (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          matricule VARCHAR(50) UNIQUE NOT NULL,
                          type VARCHAR(50) NOT NULL,
                          capacite INT NOT NULL,
                          status VARCHAR(50) NOT NULL
);

CREATE TABLE chauffeur (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nom VARCHAR(100) NOT NULL,
                           telephone VARCHAR(15) UNIQUE NOT NULL,
                           permis_type VARCHAR(20) NOT NULL,
                           disponible BOOLEAN NOT NULL
);

CREATE TABLE livraison (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           date_livraison DATE NOT NULL,
                           adresse_depart VARCHAR(100) NOT NULL,
                           adresse_destination VARCHAR(100) NOT NULL,
                           client_id BIGINT,
                           vehicule_id BIGINT,
                           chauffeur_id BIGINT,
                           statut VARCHAR(50)
);
