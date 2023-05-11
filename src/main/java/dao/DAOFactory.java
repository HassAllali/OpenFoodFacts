package dao;


import com.openfoodfact.test.JPAUtils;
import jakarta.persistence.EntityManager;

public class DAOFactory {
    
    private static DAOFactory INSTANCE = new DAOFactory();
    private EntityManager em = JPAUtils.getInstance().getEntityManager();
    
    private DAOFactory() {}
    
    public static DAOFactory getInstance() 
    {
        return INSTANCE ;
    }
    
    public DAOProduit getDAOProduit() 
    {
        return new DAOProduit();
    }
    
    public DAOCategorie getDAOCategorie() 
    {
        return new DAOCategorie();
    }
    
    public DAOMarque getDAOMarque() 
    {
        return new DAOMarque();
    }
    
    public DAOIngredient getDAOIngredient() 
    {
        return new DAOIngredient();
    }
    public DAOAllergene getDAOAllergene() 
    {
        return new DAOAllergene();
    }
    public DAOAdditif getDAOAdditif() 
    {
        return new DAOAdditif();
    }
    
    public void close() 
    {
        em.close();
    }

    
    
}