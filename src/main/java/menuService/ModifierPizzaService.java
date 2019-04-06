package menuService;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Dao.PizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza.Categorie;
import fr.pizzeria.model.Pizza.Pizza;

public class ModifierPizzaService extends MenuService {

	Scanner question = new Scanner(System.in);

	@Override
	public void executeUC(Scanner scanner, PizzaDao dao) throws UpdatePizzaException {
	
		
		System.out.println("Mettre à jour une pizza");
//nous voulons modifier une pizza à partir du choix de l'utilisateur et nous ciblons simplement le code de la pizza entré en majuscule
		System.out.println("Quelle est le code de la pizza que vous voulez modifier ?, veillez le préciser en majuscule s'il vous plait");
		String reponsemodif = question.nextLine();
//Création d'une instance d'EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

//notre une unité de travail
		EntityManager entitymanager1 = emf.createEntityManager();
// la transaction qui nous permettra de comparer de modifier la pizza qu'aura choisi l'utilisateur
		EntityTransaction transaction = entitymanager1.getTransaction();
		transaction.begin();
//ici nous récupérons la pizza choisie par l'utilisateur en mettant sa réponse en paramètre de notre requête
		TypedQuery<Pizza> query = entitymanager1.createQuery("SELECT a FROM Pizza a WHERE code=:reference",
				Pizza.class);
		query.setParameter("reference", reponsemodif);
//le résultat est enregistré ici 
		Pizza pizzaSelectionne = (Pizza) query.getSingleResult();
//notre série de question nous permttant de récolter des infos sur le devenir de la nouvelle pizza
		System.out.println("Veuillez saisir le code :");
		String reponseCode2 = question.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace):");
		String reponseNom2 = question.nextLine();
		System.out.println("Veuillez saisir le prix:");
		String reponsePrix2 = question.nextLine();
		double prix2 = Double.parseDouble(reponsePrix2);
		System.out.println("votre pizza est elle  AVEC_VIANDE ou SANS_VIANDE ? merci de le préciser en majuscule sans oublier le underscore, merci lol");
		String avecOuSans = question.nextLine();
//ici nous allons verifier que la pizza selectionné existe bien
		if (pizzaSelectionne != null) {
//si la pizza existe, nous allons créer une nouvelle pizza qui aura les caractéristiques choisis par l'utilisateur
			Pizza ajout = new Pizza();
//à partir du id, je décide de fusionner les deux pizzas
			ajout.setId(pizzaSelectionne.getId());
			ajout.setCode(reponseCode2);
			ajout.setCategorie(Categorie.valueOf(avecOuSans));
			ajout.setLibelle(reponseNom2);
			ajout.setPrix(prix2);
//un petit merge pour concrétiser tout ça
			entitymanager1.merge(ajout);

		}
//on ferme la transaction 
		transaction.commit();

	}
}
