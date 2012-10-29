package tn.com.isamm.developpement.VenteAuxEncheres.model;


import java.io.Serializable;
import java.lang.Enum;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Objet
 * 
 */
@Entity
@Table(name = "Objet")
public class Objet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idObjet;
	private long idVendeur;
	private long idCat;
	private String description;
	//private Enum etat;
	private String prixDep;
	private String prixAchatImmediat;
	private long idAcheteur;
	private String montantEnchereActuel;
	//private Date dateDeb;
	//private Date dateFin;
	@OneToOne(cascade = CascadeType.MERGE)
	private Membre membre;
	private static final long serialVersionUID = 1L;

	public Objet() {
		super();
	}

	public long getIdObjet() {
		return this.idObjet;
	}

	public void setIdObjet(long idObjet) {
		this.idObjet = idObjet;
	}

	public long getIdVendeur() {
		return this.idVendeur;
	}

	public void setIdVendeur(long idVendeur) {
		this.idVendeur = idVendeur;
	}

	public long getIdCat() {
		return this.idCat;
	}

	public void setIdCat(long idCat) {
		this.idCat = idCat;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Enum getEtat() {
//		return this.etat;
//	}
//
//	public void setEtat(Enum etat) {
//		this.etat = etat;
//	}

	public String getPrixDep() {
		return this.prixDep;
	}

	public void setPrixDep(String prixDep) {
		this.prixDep = prixDep;
	}

	public String getPrixAchatImmediat() {
		return this.prixAchatImmediat;
	}

	public void setPrixAchatImmediat(String prixAchatImmediat) {
		this.prixAchatImmediat = prixAchatImmediat;
	}

	public long getIdAcheteur() {
		return this.idAcheteur;
	}

	public void setIdAcheteur(long idAcheteur) {
		this.idAcheteur = idAcheteur;
	}

	public String getMontantEnchereActuel() {
		return this.montantEnchereActuel;
	}

	public void setMontantEnchereActuel(String montantEnchereActuel) {
		this.montantEnchereActuel = montantEnchereActuel;
	}

//	public Date getDateDeb() {
//		return this.dateDeb;
//	}
//
//	public void setDateDeb(Date dateDeb) {
//		this.dateDeb = dateDeb;
//	}
//
//	public Date getDateFin() {
//		return this.dateFin;
//	}
//
//	public void setDateFin(Date dateFin) {
//		this.dateFin = dateFin;
//	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

}
