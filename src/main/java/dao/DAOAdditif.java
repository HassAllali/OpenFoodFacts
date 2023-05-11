package dao;

import java.util.List;

import com.openfoodfact.model.Additif;
import com.openfoodfact.test.JPAUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class DAOAdditif {
	
	private EntityManager em = JPAUtils.getInstance().getEntityManager();
    Additif additif = null;

    
    public void create(Additif additif) {
    	em.getTransaction().begin();
    	em.persist(additif);
    	em.getTransaction().commit();
        
    }
    public Additif findByName(String nom) {
        TypedQuery<Additif> query = em.createQuery("SELECT a FROM Additif a WHERE a.nom = :nom", Additif.class);
        query.setParameter("nom", nom);
        try {
            additif = query.getSingleResult();
        } 
        catch (NoResultException e) {
        }
        return additif;
    }
    public Additif findByCode(String code) {
        TypedQuery<Additif> query = em.createQuery("SELECT a FROM Additif a WHERE a.code = :code", Additif.class);
        query.setParameter("code", code);
        try {
            additif = query.getSingleResult();
        } 
        catch (NoResultException e) {
        }
        return additif;
    }
    
    public List<Additif> readAll() {
        TypedQuery<Additif> query = em.createQuery("SELECT a FROM Categorie a", Additif.class);
        return query.getResultList();
    }

}
