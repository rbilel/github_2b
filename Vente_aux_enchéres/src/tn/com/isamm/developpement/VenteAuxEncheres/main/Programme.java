package tn.com.isamm.developpement.VenteAuxEncheres.main;

import tn.com.isamm.developpement.VenteAuxEncheres.dao.MembreDao;
import tn.com.isamm.developpement.VenteAuxEncheres.daoImp.MembreDaoImp;
import tn.com.isamm.developpement.VenteAuxEncheres.model.Membre;

public class Programme {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MembreDao membreDao = new MembreDaoImp();
		Membre membre = new Membre();
		membre.setIdMbr(1);
		membre.setNom("ELBEJI");
		membre.setPrenom("Mohamed Salah");
		membreDao.ajouterMembre(membre);
	}

}
