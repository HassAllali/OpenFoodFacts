package dao;

import java.util.List;

import com.openfoodfact.model.Categorie;
import com.openfoodfact.model.Ingredient;
import com.openfoodfact.test.JPAUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class DAOIngredient {
    private EntityManager em = JPAUtils.getInstance().getEntityManager();
    
    public Ingredient findByName(String nom) {
        Ingredient ingredient = null;
   
        TypedQuery<Ingredient> query = em.createQuery("SELECT i FROM Ingredient i WHERE i.nom = :nom", Ingredient.class);
        query.setParameter("nom", nom);
        try {
            ingredient = query.getSingleResult();
        } catch (NoResultException e) {
        }       
        
        return ingredient;
    }

    
    public List<Ingredient> readAll() {
        TypedQuery<Ingredient> query = em.createQuery("SELECT i FROM Ingredient i", Ingredient.class);
        return query.getResultList();
    }
    
    public Categorie findById(Long id) {
        return em.find(Categorie.class, id);
    }

    
    public void create(Ingredient ingredient) {
        em.getTransaction().begin();
        em.persist(ingredient);
        em.getTransaction().commit();
    }
    
    
    
}