package menuService;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Dao.PizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza.Pizza;

public class SupprimerPizzaService extends MenuService {

	private Scanner question;

	@Override
	public void executeUC(Scanner scanner, PizzaDao dao) throws DeletePizzaException{
		question = new Scanner(System.in);
		System.out.println("Supprimer une pizza");
//il semblerait que detruire est plus facile que de construire.... c'est pas toujours le cas. parfois, detruire demande des heures de reflexions :-)
		System.out.println("Quelle est le code de la pizza que vous voulez supprimer ?");
		String reponsesupprimer = question.nextLine();
		
//Création d'une instance d'EntityManagerFactory
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

//notre unité de travail
				EntityManager entitymanager1 = emf.createEntityManager();
// transaction
				EntityTransaction transaction = entitymanager1.getTransaction();
				transaction.begin();
//ici nous effectuons une requête en mettant en paramètre la réponse de l'utilisateur
				TypedQuery<Pizza> query = entitymanager1.createQuery("SELECT a FROM Pizza a WHERE code=:reference", Pizza.class);
				query.setParameter("reference",reponsesupprimer);
//nous récupérons la pizza selectionné par l'utilisateur, mais cela m'est apparu insuffisant pour pouvoir la supprimer				
				Pizza pizzaSelectionne = (Pizza) query.getSingleResult();
				
//nous cherchons à tenir la pizza à supprimer entre nos mains grace à l'id de la pizza selectionnée pour être sûr qu'on va supprimer la bonne pizza et non une autre				
				Pizza pizzaASupprimer = entitymanager1.find(Pizza.class, pizzaSelectionne.getId());
//nous verifions que cette pizza existe vraiment				
				if(pizzaASupprimer != null) {
					
					//l'acte de destruction arrive enfin, en passant par des chemins detournés :-)
					entitymanager1.remove(pizzaASupprimer);
				}
				
//fin de la transaction
				transaction.commit();
		
		
		

		
		
	}

}
