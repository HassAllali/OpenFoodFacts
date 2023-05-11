package com.openfoodfact.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    
    @ManyToMany(mappedBy = "marques")
    private List<Produit> produits = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Produit> getProduit() {
        return produits;
    }

    public void setProduit(List<Produit> produit) {
        this.produits = produit;
    }

    @Override
    public String toString() {
        return "Marque id = " + id + ", nom = " + nom + ", produit = " + produits;
    }
    
}