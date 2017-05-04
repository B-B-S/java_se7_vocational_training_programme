package _20161117aufgabe01pizzabaeckereithreads.kueche;

import java.util.Vector;

public class PizzaFactory extends AGerichteFactory {

	//constructors
	protected PizzaFactory() {
		super(new ReadInMenu("menu_pizza.txt"));
	}
	
	
	//standard methods
		//toString (return all available pizzas including their menu entry number and price)
	@Override
	public String toString() {
		StringBuffer textBuffer = new StringBuffer();
		int spacing = 20;
		textBuffer.append("Pizze:\n");
		textBuffer.append("_________________________________________________________________________\n");
		textBuffer.append("Nummer               | Name                 | Preis                | Kcal\n");
		textBuffer.append("_________________________________________________________________________");
		
		
		//process records
			//define order
		Vector<Integer> mapkey_order = new Vector<>();
		for(Integer key : this.getMenu().keySet()) {
			mapkey_order.add(key);
		}
		mapkey_order.sort(null);
		
			//read out records
		for(Integer key : mapkey_order) {
			textBuffer.append("\n");
			String[] record =  this.getMenu().get(key);
			for(int j = 0; j < record.length; j++) {
				if(j != 0) {
					textBuffer.append(" | ");
				}
				textBuffer.append(record[j]);
				//fill in blanks to have equal space in between values
				for(int i = 0; i < spacing - record[j].length(); i++) {
					textBuffer.append(" ");
				}
			}
		}
		
		
		//return string
		return textBuffer.toString();
	}
	
	
	//features
	@Override
	protected APizza createGericht(int selection_num) {
		APizza pizza;
		if(this.getMenu().containsKey(selection_num)){
			//try accessing and converting all expected indexes
			boolean valid_parameters = true;
			int num = 0;
			String name = "";
			float price = 0.0f;
			float kcal = 0.0f;
			try {
				String[] record = this.getMenu().get(selection_num);
				
				num = Integer.parseInt(record[0]);
				name = record[1];
				price = Float.parseFloat(record[2]);
				kcal = Float.parseFloat(record[3]);
			} catch(NumberFormatException | NullPointerException e) {
				valid_parameters = false;
				System.err.println("Menu entry for Pizza is not valid, check format of values!");
				e.printStackTrace();
			} catch(ArrayIndexOutOfBoundsException e) {
				valid_parameters = false;
				System.err.println("Menu entry for Pizza is not valid, check for amount of individual values");
				e.printStackTrace();
			} finally {
				if(valid_parameters) {
					//create pizza (only one concrete pizza class available at this time)
					pizza = new Pizza(num, name, price, kcal);
				} else {
					pizza = null;
				}
			}
		} else {
			pizza = null;
			System.out.println("Select pizza is not available!");
		}
		return pizza;
	}
}
