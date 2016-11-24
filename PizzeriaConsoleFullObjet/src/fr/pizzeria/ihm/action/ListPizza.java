package fr.pizzeria.ihm.action;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class ListPizza extends Action {
	
	public ListPizza(IhmUtil ihmUtil) {
		super("Lister les pizzas", ihmUtil);
	}

	@Override
	public void doAction() {
		for(Pizza p : this.getIhmUtil().getPizzaDaoList().findAllPizzas()) {
			getIhmUtil().affichePizza(p);
		}
	}

}
