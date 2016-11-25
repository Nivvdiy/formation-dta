package fr.pizzeria.ihm;

import java.util.ArrayList;

import fr.pizzeria.ihm.action.Action;
import fr.pizzeria.ihm.action.AddPizza;
import fr.pizzeria.ihm.action.ListPizza;
import fr.pizzeria.ihm.action.RemovePizza;
import fr.pizzeria.ihm.action.UpdatePizza;
import fr.pizzeria.ihm.action.exitApp;

public class MainMenu {

	private ArrayList<Action> menu = new ArrayList<Action>();
	private IhmUtil ihmUtil;
	boolean error;
	int option;

	public MainMenu(IhmUtil ihmUtil) {
		this.menu.add(new ListPizza(ihmUtil));
		this.menu.add(new AddPizza(ihmUtil));
		this.menu.add(new UpdatePizza(ihmUtil));
		this.menu.add(new RemovePizza(ihmUtil));
		this.menu.add(new exitApp(ihmUtil));
		this.ihmUtil = ihmUtil;
		ihmUtil.initialize();
	}

	public void run() {
		boolean running = true;
		while(running){
			System.out.println("***** Bienvenue sur le terminal de la pizzeria DTA *****");
			for(Action a : menu) {
				System.out.print(menu.indexOf(a)+1+". ");
				a.describeAction();
			}
			System.out.println("***** Veuillez choisir une option *****");
			error = true;
			while(error){
				String temp = ihmUtil.getScanner().next();
				try{
					option = Integer.parseInt(temp);
					if(0<option&option<menu.size()+1){
						error = false;
					} else {
						System.out.println("Saisie incorrect veuillez entrez une option valide...");
					}
				} catch(NumberFormatException e){
					System.out.println("Saisie incorrect veuillez entrez un nombre...");
				}
			}
			menu.get(option-1).doAction();
		}
	}

}
