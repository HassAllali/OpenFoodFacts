package dao;

import java.util.List;

import com.openfoodfact.model.Produit;
import com.openfoodfact.test.JPAUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class DAOProduit implements IDAO<Produit> {

    private EntityManager em = JPAUtils.getInstance().getEntityManager();
    

    public Produit findById(int id) {
        return em.find(Produit.class, id);
    }

    
    public List<Produit> readAll() {
        TypedQuery<Produit> query = em.createQuery("SELECT p FROM Produit p", Produit.class);
        return query.getResultList();
    }

    
    public void create(Produit produit) {
        em.getTransaction().begin();
        em.persist(produit);
        em.getTransaction().commit();
    }
    
    
	@Override
	public Produit read(Long id) {
		return null;
	}


	@Override
	public void update(Produit entity) {	
	}


	@Override
	public void delete(Produit entity) {	
	}
	

}