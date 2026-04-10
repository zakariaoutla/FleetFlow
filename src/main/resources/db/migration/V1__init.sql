CREATE TABLE client(
    id long PRIMARY KEY AUTO_INCREMENT,
    nom varchar(20) NOT NULL,
    email varchar(50) UNIQUE NOT NULL,
    telephone varchar(10) NOT NULL,
    ville varchar(10) NOT NULL
);

CREATE table vehicule(
    id long primary key  AUTO_INCREMENT,
    capacite INT NOT NULL,
    matricule varchar(40) UNIQUE NOT NULL ,
    status enum('DISPONIBLE', 'EN_LIVRAISON', 'MAINTENANCE') DEFAULT 'DISPONIBLE' NOT NULL,
    type varchar(20) NOT NULL
);

CREATE TABLE chauffeur(
    id long primary key AUTO_INCREMENT,
    nom varchar(20) NOT NULL ,
    telephone varchar(10) UNIQUE NOT NULL ,
    permisType varchar(30) NOT NULL ,
    disponible boolean DEFAULT 'true'
);

CREATE table livraison(
    id long primary key AUTO_INCREMENT,
    dateLivraison DATE not null ,
    adresseDepart varchar(30) not null ,
    adresseDestination varchar(30) not null,
    statut enum ('ENATTENTE', 'ENCOURS', 'LIVREE') DEFAULT 'ENATTENTE' ,
    client_id long,
    vehicule_id long,
    chauffeur_id long
);


