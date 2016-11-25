package fr.pizzeria.ihm.action;

import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class UpdatePizza extends Action {

	public UpdatePizza(IhmUtil ihmUtil) {
		super("Mettre à jour une pizza", ihmUtil);
	}

	@Override
	public void doAction() {
		this.afficheTitre();
		int nbOption = ihmUtil.getPizzaDaoList().getNbPizza()+1;
		if(ihmUtil.getPizzaDaoList().getNbPizza()==0){
			System.out.println("\nAucune pizza dans la liste\n");
			return;
		} else {
			for(Pizza pizza : ihmUtil.getPizzaDaoList().findAllPizzas()) {
				getIhmUtil().affichePizza(pizza, true);
			}
		}
		System.out.println("Veuillez choisir la pizza à modifier.");
		System.out.println(nbOption+". Abandonner");
		int option = 0;
		boolean error = true;
		while(error){

			String temp = ihmUtil.getScanner().next();

			try{
				option = Integer.parseInt(temp);
			} catch(NumberFormatException e){
				System.out.println("Saisie incorrect veuillez entrez un nombre...");
			}
			if(0<option&option<=nbOption){
				error = false;
			} else {
				System.out.println("Saisie incorrect veuillez entrez une option valide...");
			}

		}
		if(option==nbOption){
			return;
		} else {
			Pizza updatedPizza = ihmUtil.getPizzaDaoList().findAllPizzas().get(option-1);
			System.out.println("Vous allez modifier la pizza "+updatedPizza.getName());
			modifyPizza(option);
			updatedPizza = ihmUtil.getPizzaDaoList().findAllPizzas().get(option-1);
			System.out.println("Pizza modifié "+updatedPizza.getName());
		}
	}

	private void modifyPizza(int index) {
		Pizza pizza = ihmUtil.getPizzaDaoList().findAllPizzas().get(index-1);
		System.out.println("Veuillez saisir le code");
		pizza.setCode(ihmUtil.getScanner().next()); 
		System.out.println("Veuillez saisir le nom");
		ihmUtil.getScanner().nextLine();
		pizza.setName(ihmUtil.getScanner().nextLine());
		System.out.println("Veuillez saisir le prix");
		boolean error = true;
		while(error){

			 String temp = ihmUtil.getScanner().next();

			try{
				pizza.setPrice(Double.parseDouble(temp));
				error = false;
			} catch(NumberFormatException e){
				System.out.println("Saisie incorrect veuillez entrez un nombre...");
			}

		}
		try {
			ihmUtil.getPizzaDaoList().updatePizza(index, pizza);
		} catch (UpdatePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
