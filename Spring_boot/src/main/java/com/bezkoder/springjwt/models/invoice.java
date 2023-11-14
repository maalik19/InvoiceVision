package com.bezkoder.springjwt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class invoice {
    public String getClient() {
        return client;
    }

    public String getDesignation() {
        return Designation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getTelFournisseur() {
        return telFournisseur;
    }

    public void setTelFournisseur(String telFournisseur) {
        this.telFournisseur = telFournisseur;
    }

    public String getTelClient() {
        return telClient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public double getTotalTTC() {
        return totalTTC;
    }

    public void setTotalTTC(double totalTTC) {
        this.totalTTC = totalTTC;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id")
    private Long id;
    private String client;
    private String fournisseur;
    private Date date;
    private double totalTTC;
    private String telClient;
    private String telFournisseur;
    private String Designation;





}

