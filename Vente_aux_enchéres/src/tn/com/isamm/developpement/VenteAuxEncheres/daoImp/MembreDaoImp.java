package tn.com.isamm.developpement.VenteAuxEncheres.daoImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tn.com.isamm.developpement.VenteAuxEncheres.dao.MembreDao;
import tn.com.isamm.developpement.VenteAuxEncheres.model.Membre;

public class MembreDaoImp implements MembreDao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

	private static EntityManager em = emf.createEntityManager();

	@Override
	public void ajouterMembre(Membre membre) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
        em.persist(membre);
        em.getTransaction().commit();
	}

}
