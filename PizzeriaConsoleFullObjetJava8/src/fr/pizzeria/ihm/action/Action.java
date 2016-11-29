package fr.pizzeria.ihm.action;

import fr.pizzeria.ihm.IhmUtil;

public abstract class Action {

	private String title;
	protected IhmUtil ihmUtil;

	public Action(String description, IhmUtil ihmUtil) {
		this.title = description;
		this.ihmUtil = ihmUtil;
	}

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}

	public String getDescription() {
		return title;
	}

	public void setDescription(String description) {
		this.title = description;
	}
	
	public void afficheTitre(){
		System.out.println("***** "+ getDescription()+" *****");
	}
	
	public void describeAction(){
		System.out.println(getDescription());
	}

	public abstract void doAction();
}