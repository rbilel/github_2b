package com.isamm.tp1;

public class Virement {

	private int idV;
	private int numeroCompte;
	private int benif;
	private int montant;

	public int getIdV() {
		return idV;
	}

	public void setIdV(int idV) {
		this.idV = idV;
	}

	public int getNumeroCompte() {
		return numeroCompte;
	}


	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}


	public int getBenif() {
		return benif;
	}


	public void setBenif(int benif) {
		this.benif = benif;
	}


	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	
	public Virement(int idV, int numeroCompte, int benif, int montant) {
		super();
		this.idV = idV;
		this.numeroCompte = numeroCompte;
		this.benif = benif;
		this.montant = montant;
	}
	
	
	
}
