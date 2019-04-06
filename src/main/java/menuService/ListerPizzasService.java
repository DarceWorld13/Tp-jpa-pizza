package menuService;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Dao.PizzaDao;
import fr.pizzeria.model.Pizza.Categorie;
import fr.pizzeria.model.Pizza.Pizza;

public class ListerPizzasService extends MenuService {
	
	public
	void executeUC (Scanner question, PizzaDao dao) {
		
		System.out.println("liste des pizzas");

		// Création d'une instance d'EntityManagerFactory
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

		//notre unité de travail
				EntityManager entitymanager2 = emf.createEntityManager();
		//notre requête
				Query query = entitymanager2.createQuery("select p from Pizza p");
				List<Pizza> toutes = query.getResultList(); 
				
		//la liste de pizza qui va arriver en résultat doit être parcouru pour obtenir la liste dans son intégralité		
				for (Pizza pizza : toutes) {
					
					System.out.println(pizza.getId() + "---"+ pizza.getCode()+"--"+ pizza.getLibelle() + "--"+ pizza.getPrix());
				}
				
				
		
		
	}
		


}