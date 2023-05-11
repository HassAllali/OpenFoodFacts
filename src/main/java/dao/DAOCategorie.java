package dao;

import java.util.List;

import com.openfoodfact.model.Categorie;
import com.openfoodfact.test.JPAUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class DAOCategorie implements IDAO<Categorie> {

    private EntityManager em = JPAUtils.getInstance().getEntityManager();

    
    public Categorie findByName(String nom) {
        Categorie categorie = null;
   
        TypedQuery<Categorie> query = em.createQuery("SELECT c FROM Categorie c WHERE c.nom = :nom", Categorie.class);
        query.setParameter("nom", nom);
        try {
            categorie = query.getSingleResult();
        } catch (NoResultException e) {
        }       
        
        return categorie;
    }

    
    public List<Categorie> readAll() {
        TypedQuery<Categorie> query = em.createQuery("SELECT c FROM Categorie c", Categorie.class);
        return query.getResultList();
    }

    @Override
    public void create(Categorie categorie) {
    	em.getTransaction().begin();
    	em.persist(categorie);
    	em.getTransaction().commit();
    }

    @Override
    public void update(Categorie categorie) {
    	em.getTransaction().begin();
    	em.merge(categorie);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Categorie categorie) {
    	em.getTransaction().begin();
    	em.remove(categorie);
    	em.getTransaction().commit();
    }

    public Categorie findById(Long id) {
        return em.find(Categorie.class, id);
    }

	@Override
	public Categorie read(Long id) {
		return null;
	}

}