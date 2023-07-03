package dao;

import java.util.List;

import com.openfoodfact.model.Allergene;
import com.openfoodfact.test.JPAUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;


public class DAOAllergene implements IDAO<Allergene>{
    
    Allergene allergene = null;
    private EntityManager em = JPAUtils.getInstance().getEntityManager();
    
    public Allergene findByName(String nom) {
        TypedQuery<Allergene> query = em.createQuery("SELECT a FROM Allergene a WHERE a.nom = :nom", Allergene.class);
        query.setParameter("nom", nom);
        try {
            allergene = query.getSingleResult();
        } 
        catch (NoResultException e) {
        }
        return allergene;
    }
    
    @Override
    public List<Allergene> readAll() {
        TypedQuery<Allergene> query = em.createQuery("SELECT a FROM Categorie a", Allergene.class);
        return query.getResultList();
    }



    @Override
    public void create(Allergene allergene) {
    	em.getTransaction().begin();
    	em.persist(allergene);
    	em.getTransaction().commit();
    }

    @Override
    public void update(Allergene entity) {
    }
    
    @Override
    public void delete(Allergene entity) {
  
    }
    

    public Allergene findById(Long id) {
        return null;
    }

	@Override
	public Allergene read(Long id) {
		return null;
	}
}