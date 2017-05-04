package _20161117aufgabe01pizzabaeckereithreads.kueche;

import java.util.Vector;

public class Kueche implements Cookable {

	//attributes
	Vector<AGerichteFactory> factoryVector;
	
	
	//getters and setters
	private Vector<AGerichteFactory> getFactoryVector() {
		return this.factoryVector;
	}
	private void setFactoryVector(Vector<AGerichteFactory> factoryVector) {
		this.factoryVector = factoryVector;
	}
	
	
	//constructors
		//add as many AGerichteFactory as you wish or remove some
	public Kueche() {
		Vector<AGerichteFactory> factoryVector = new Vector<>();
		factoryVector.add(new PizzaFactory());
		factoryVector.add(new SalatFactory());
		factoryVector.add(new GetraenkFactory());
		this.setFactoryVector(factoryVector);
	}
	
	
	//standard methods
		//toString
	@Override
	public String toString() {
		StringBuffer textBuffer = new StringBuffer();
		
		textBuffer.append("Trattoria Bon Giorno\n");
		textBuffer.append("____________________\n");
		textBuffer.append("Speisekarte\n");
		textBuffer.append("____________________\n");
		
		for(AGerichteFactory factory : this.getFactoryVector()) {
			textBuffer.append("\n\n");
			textBuffer.append(factory);
		}
		
		return textBuffer.toString();
	}
	
	
	//features
	/**
	 * create and return an AGericht based on the selection number provided,
	 * selection must be available in menu files and unique amongst all of them,
	 * factory associated with the menu file containing the selection will then be called
	 * to create AGericht
	 * 
	 * @param int selectionNum	Number of AGericht in associated menu file that
	 * 							is to be created and returned
	 * 
	 * @return AGericht
	 *
	 */
	public AGericht createGericht(int selectionNum) {
		AGericht gericht = null;
		//check whether selection is available and unique
		int counter = 0;
		for(AGerichteFactory factory : this.getFactoryVector()) {
			if(factory.getMenu().containsKey(selectionNum)) {
				counter++;
			}
		}
		
		//create gericht if selection is available and unique
		try {
			if(counter == 0) {
				gericht = null;
				System.out.println("Dieses Gericht fuehren wir in diesem Restaurant leider nicht!");
			} else if(counter > 1) {
				gericht = null;
				throw new RuntimeException("Selection Number is not unique amongst factories!");
			} else {
				//create gericht
				for(AGerichteFactory factory : this.getFactoryVector()) {
					if(factory.getMenu().containsKey(selectionNum)) {
						gericht = factory.createGericht(selectionNum);
					}
				}
			}
		} catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		
		//return gericht
		return gericht;
	}
	
	
	/**
	 * method returns an unsorted vector that contains all available selection numbers across all factories
	 * 
	 * @return Vector<Integer> selections
	 */
	public Vector<Integer> availableSelections() {
		Vector<Integer> selections = new Vector<>();
		
		for(AGerichteFactory factory : this.getFactoryVector()) {
			for(int entry : factory.getMenu().keySet()) {
				selections.add(entry);
			}
		}
		
		return selections;
	}
}
