package fr.pizzeria.ihm;

import java.util.ArrayList;

import fr.pizzeria.ihm.action.Action;
import fr.pizzeria.ihm.action.AddPizza;
import fr.pizzeria.ihm.action.ListPizza;
import fr.pizzeria.ihm.action.RemovePizza;
import fr.pizzeria.ihm.action.UpdatePizza;
import fr.pizzeria.ihm.action.exitApp;
import fr.pizzeria.model.Pizza;

public class MainMenu {

	private ArrayList<Action> menu = new ArrayList<Action>();

	public MainMenu(IhmUtil ihmUtil) {
		this.menu.add(new ListPizza(ihmUtil));
		this.menu.add(new AddPizza(ihmUtil));
		this.menu.add(new UpdatePizza(ihmUtil));
		this.menu.add(new RemovePizza(ihmUtil));
		this.menu.add(new exitApp(ihmUtil));
	}

	public void run() {
		for(Action a : menu) {
			System.out.print(menu.indexOf(a)+1+". ");
			a.describeAction();
		}
	}

}
