package com.openfoodfact.test;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class JPAUtils {
	
	
	
	private final static JPAUtils INSTANCE = new JPAUtils();
	private JPAUtils() {}
	public static JPAUtils getInstance() {
		return INSTANCE;
	}
	
	
	//JPA
	private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("OpenFoodFact");
	private final static EntityManager EM = EMF.createEntityManager();
	
	public EntityManager getEntityManager() {
		return EM;
	}

}
