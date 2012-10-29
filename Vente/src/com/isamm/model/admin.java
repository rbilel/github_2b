package com.isamm.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;

/**
 * Entity implementation class for Entity: admin
 *
 */
@Entity(name = "admin")
@Table(name="admin")
public class admin implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	@Column(name = "nom")
	private String nom;
	private static final long serialVersionUID = 1L;

	public admin() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
   
}
