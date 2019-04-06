package fr.pizzeria.console;

import java.util.Scanner;

//import Dao.PizzamemDao;

import Dao.TestJPA;
import fr.pizzeria.exception.DataAccessException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import menuService.AjouterPizzaService;
import menuService.ListerPizzasService;
import menuService.ModifierPizzaService;
import menuService.SupprimerPizzaService;

public class PizzeriaAdminConsoleApp {

	public static void main(String args[]) {

		// Nous allons instancier notre classe TestJPA 
		TestJPA dao = new TestJPA();
		
		//ici le scanner 
		Scanner question = new Scanner(System.in);

		// ici on affiche les choix 
		int reponse = 0;
		while (reponse != 99) {
			try {
				System.out.println("1.liste des pizzas");
				System.out.println("2.Ajouter une nouvelle pizza");
				System.out.println("3. Mettre à jour une pizza");
				System.out.println("4. Supprimer une pizza");
				System.out.println("99. Sortir");
				System.out.println("veuillez saisir votre choix s'il vous plait ");
				// on récupère le choix de l'utilisateur
				reponse = Integer.parseInt(question.nextLine());
				switch (reponse) {
				case 1:
					// lister toutes les pizzas
					ListerPizzasService liste = new ListerPizzasService();
					liste.executeUC(question, dao);

					break;
				case 2:
					// ici on choisit d'ajouter une nouvelle pizza
					AjouterPizzaService service = new AjouterPizzaService();
					// ici on gère l'exception
					try {
						service.executeUC(question, dao);
					} catch (SavePizzaException e) {
						System.err.println(e.getMessage());
					}
					break;
					//modif de pizza
				case 3:
					ModifierPizzaService modif = new ModifierPizzaService();
					try {
						modif.executeUC(question, dao);
					} catch (UpdatePizzaException e) {
						System.err.println(e.getMessage());
					}
					break;
					//suppression d'une pizza 
				case 4:
					SupprimerPizzaService suppr = new SupprimerPizzaService();
					try {

						suppr.executeUC(question, dao);
					} catch (Exception e) {

						System.err.println(e.getMessage());
					}
					break;
				case 99:
					System.out.println("Aurevoir ☹");
					break;

				default:
					System.out.println("pas de choix valide ! ");

				}
			}

			catch (DataAccessException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}

	}

}
