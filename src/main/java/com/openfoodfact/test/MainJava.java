package com.openfoodfact.test;



import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.openfoodfact.model.*;

import jakarta.persistence.EntityManager;
import service.Lire;

public class MainJava {

    public static void main(String[] args) throws IOException {
        
        
        Lire liree = new Lire();
        liree.parseFile();
        
        
        JPAUtils.getInstance().getEntityManager().close();
    }

}