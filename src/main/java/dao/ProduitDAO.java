package dao;

import java.util.List;

import com.openfoodfact.model.Produit;
import com.openfoodfact.test.JPAUtils;

import jakarta.persistence.EntityManager;

public class ProduitDAO implements IDAO<Produit>{

	private EntityManager em = JPAUtils.getInstance().getEntityManager();	
	
	@Override
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

	@Override
	public List<Produit> readAll() {
		return null;
	}
	

}
