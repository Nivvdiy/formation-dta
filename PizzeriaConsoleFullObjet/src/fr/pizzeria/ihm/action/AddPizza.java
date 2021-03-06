package fr.pizzeria.ihm.action;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class AddPizza extends Action {

	public AddPizza(IhmUtil ihmUtil) {
		super("Ajouter une pizza", ihmUtil);
	}

	@Override
	public void doAction() {
		this.afficheTitre();
		System.out.println("Veuillez saisir le code");
		String code = ihmUtil.getScanner().next();
		System.out.println("Veuillez saisir le nom");
		ihmUtil.getScanner().nextLine();
		String name = ihmUtil.getScanner().nextLine();
		System.out.println("Veuillez saisir le prix");
		double price = 0;
		boolean error = true;
		while(error){

			 String temp = ihmUtil.getScanner().next();

			try{
				price = Double.parseDouble(temp);
				error = false;
			} catch(NumberFormatException e){
				System.out.println("Saisie incorrect veuillez entrez un nombre...");
			}

		}
		try {
			ihmUtil.getPizzaDaoList().saveNewPizza(new Pizza(code, name, price, true));
		} catch (SavePizzaException e) {
			e.printStackTrace();
		}
	}

}
