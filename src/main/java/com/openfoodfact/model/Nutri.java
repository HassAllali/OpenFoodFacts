package com.openfoodfact.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public enum Nutri {
    A("a", "Très bonne qualité nutritionnelle"),
    B("b", "Bonne qualité nutritionnelle"),
    C("c", "Qualité nutritionnelle moyenne"),
    D("d", "Mauvaise qualité nutritionnelle"),
    E("e", "Très mauvaise qualité nutritionnelle");
    
    
    
    private final String code;
    private final String name;
    
    private Nutri(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
    
    
}