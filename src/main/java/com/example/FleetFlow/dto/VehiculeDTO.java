package com.example.FleetFlow.dto;



public class VehiculeDTO {
    private long id;
    private String matricule;
    private String type;
    private int capacite;
    private String status;

    public long getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getType() {
        return type;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
