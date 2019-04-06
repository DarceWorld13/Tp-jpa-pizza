package menuService;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Dao.PizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza.Categorie;
import fr.pizzeria.model.Pizza.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner question, PizzaDao dao) throws SavePizzaException {

		System.out.println("Ajout d’une nouvelle pizza");
//la liste des questions que nous posons à l'utilisateur et des réponses que nous allons récupérer
		System.out.println("Veuillez saisir le code :");
		String reponseCode = question.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace):");
		String reponseNom = question.nextLine();
		System.out.println("Veuillez saisir le prix:");
		String reponsePrix = question.nextLine();
		double prix = Double.parseDouble(reponsePrix);
		//je demande à l'utilisateur d'entrer spécifiquement AVEC_VIANDE, SANS_VIANDE en majuscule, car j'ai un petit problème avec l'énumération catégorie. mais ça marche lol
		System.out.println("votre pizza est elle (AVEC_VIANDE) ou (SANS_VIANDE), merci de le préciser en majuscule ?");

		String avecOuSansViande = question.nextLine();

		System.out.println("liste des pizzas");

	// Création d'une instance d'EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

	// notre  unité de travail
		EntityManager entitymanager1 = emf.createEntityManager();

 //la transaction qui nous permettra d'ajouter un nouveau produit
		EntityTransaction transaction = entitymanager1.getTransaction();
		transaction.begin();

		Pizza nouvelle = new Pizza();
		nouvelle.setCode(reponseCode);
		nouvelle.setLibelle(reponseNom);
		nouvelle.setPrix(prix);
		nouvelle.setCategorie(Categorie.valueOf(avecOuSansViande));
		
		//un petit persist pour l'enregistrer dans la base
		entitymanager1.persist(nouvelle);

		//fermeture de la transaction
		transaction.commit();

	}
}
