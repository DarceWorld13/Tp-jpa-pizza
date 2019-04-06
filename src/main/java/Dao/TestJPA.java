package Dao;

import fr.pizzeria.model.Pizza.Pizza;

// class qui implémente l'interface pizzaDao qui nous servira dans le CRUD
public class TestJPA implements PizzaDao {

//ici comment lister toutes les pizzas
	public void findAllPizzas() {

	}

//comment ajouter une nouvelle pizza
	public void saveNewPizza(Pizza pizza) {

	}

//comment mettre à jour une pizza
	public void updatePizza(String codePizza, Pizza pizza) {

	}

//comment supprimer une pizza
	public void deletePizza(String codePizza) {

	}

	public Pizza findPizzaByCode(String codePizza) {

		return null;
	}

	public boolean pizzaExists(String codePizza) {

		return false;
	}

}
