package fr.pizzeria.ihm.action;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class ListPizza extends Action {

	public ListPizza(IhmUtil ihmUtil) {
		super("Lister les pizzas", ihmUtil);
	}

	@Override
	public void doAction() {
		this.afficheTitre();
		if(ihmUtil.getPizzaDaoList().getNbPizza()==0){
			System.out.println("\nAucune pizza dans la liste\n");
		} else {
			for(Pizza pizza : ihmUtil.getPizzaDaoList().findAllPizzas()) {
				getIhmUtil().affichePizza(pizza, false);
			}
		}
	}

}
