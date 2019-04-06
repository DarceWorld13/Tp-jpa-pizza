package Dao;

import fr.pizzeria.model.Pizza.Pizza;

//on crée une interface pour pouvoir lui donner une fille 

public interface PizzaDao {
	
	void findAllPizzas();

	void saveNewPizza(Pizza pizza);

	void updatePizza(String codePizza, Pizza pizza);

	void deletePizza(String codePizza);

	Pizza findPizzaByCode(String codePizza);

	boolean pizzaExists(String codePizza);

}
