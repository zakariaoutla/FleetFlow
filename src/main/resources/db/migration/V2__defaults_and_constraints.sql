ALTER TABLE livraison
    ADD CONSTRAINT fk_liv_client FOREIGN KEY (client_id) REFERENCES client(id),
ADD CONSTRAINT fk_liv_vehicule FOREIGN KEY (vehicule_id) REFERENCES vehicule(id),
ADD CONSTRAINT fk_liv_chauffeur FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id);

ALTER TABLE vehicule
    ADD CONSTRAINT chk_capacite_positive CHECK (capacite > 0);


ALTER TABLE chauffeur
    ALTER COLUMN disponible SET DEFAULT TRUE;

ALTER TABLE livraison
    ALTER COLUMN statut SET DEFAULT 'EN_ATTENTE';