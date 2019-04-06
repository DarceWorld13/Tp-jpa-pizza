package fr.pizzeria.model.Pizza;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // obligatoire
@Table(name="toutes_les_pizzas")
public class Pizza {
	
	
	//attributs 
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		protected Integer id; 
		
		@Column(name="code")
			protected String code;
		@Column(name="libelle")
			protected String libelle;
		
		@Column(name="prix")
			protected double prix;
		
		public void setId(Integer id) {
			this.id = id;
		}
		@Enumerated
		@Column(name="categorie")
			protected Categorie categorie;

	private static int count=0;
	
	//constructeur
	public Pizza() {
		
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Pizza.count = count;
	}
	
	
	

	
	
	
	
	
	
	

}
