package tn.com.isamm.developpement.VenteAuxEncheres.jpaUtil;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static final EntityManagerFactory emf;
	static {
		try {
			emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		} catch (Throwable e) {
			System.err.println(e);
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}