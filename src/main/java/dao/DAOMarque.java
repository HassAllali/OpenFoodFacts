package dao;

import java.util.List;

import com.openfoodfact.model.Marque;
import com.openfoodfact.test.JPAUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;


public class DAOMarque implements IDAO<Marque> {

    private EntityManager em = JPAUtils.getInstance().getEntityManager();

    @Override
    public List<Marque> readAll() {
        TypedQuery<Marque> query = em.createQuery("SELECT m FROM Marque m", Marque.class);
        return query.getResultList();
    }

    
    public Marque findById(Long id) {
        return em.find(Marque.class, id);
    }
    
    public Marque findByNom(String nom) {
        Marque marque = null;
        
        TypedQuery<Marque> query = em.createQuery("SELECT m FROM Marque m WHERE m.nom = :nom", Marque.class);
        query.setParameter("nom", nom);
        try {
            marque = query.getSingleResult();
        } catch (NoResultException e) {
        }
        
        return marque;
        
    }

    @Override
    public void create(Marque marque) {
        em.getTransaction().begin();
        em.persist(marque);
        em.getTransaction().commit();
    }



	@Override
	public com.openfoodfact.model.Marque read(Long id) {
		return null;
	}


	@Override
	public void update(Marque entity) {	
	}


	@Override
	public void delete(Marque entity) {	
	}


}