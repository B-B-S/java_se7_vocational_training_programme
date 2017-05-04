package _20161117aufgabe01pizzabaeckereithreads.kueche;

import java.util.Vector;

public class GetraenkFactory extends AGerichteFactory {

	//constructors
	protected GetraenkFactory() {
		super(new ReadInMenu("menu_getraenk.txt"));
	}
	
	
	//standard methods
		//toString (return all available getraenke including their menu entry number and price)
	@Override
	public String toString() {
		int spacing = 30;
		
		//header NichtalkolholischeGetraenke
		StringBuffer textBufferNichtAlkohol = new StringBuffer();
		textBufferNichtAlkohol.append("Nichtalkoholische Getraenke:\n");
		textBufferNichtAlkohol.append("________________________________________________________________________________________________________________________________________\n");
		textBufferNichtAlkohol.append("Nummer                         | Typ                            | Name                           | Preis                          | Kcal\n");
		textBufferNichtAlkohol.append("________________________________________________________________________________________________________________________________________");
		
		//header AlkolholischeGetraenke
		StringBuffer textBufferAlkohol = new StringBuffer();
		textBufferAlkohol.append("Alkoholische Getraenke:\n");
		textBufferAlkohol.append(	"_________________________________________________________________________________________________"
									+
									"_________________________________________________________________________________\n"
		);
		textBufferAlkohol.append(	"Nummer                         | Typ                            | Name                           |"
									+
									"Preis                           | Kcal                           | Alkoholgehalt\n"
		);
		textBufferAlkohol.append(	"____________________________________________________________________________________________________"
									+
									"______________________________________________________________________________"
		);
		
		//header Unknown getraenke
		StringBuffer textBufferUnknown = new StringBuffer();
		textBufferUnknown.append("Unknown getraenke:");
		
		
		//process records
		boolean unknown = false;
		
			//define order
		Vector<Integer> mapkey_order = new Vector<>();
		for(Integer key : this.getMenu().keySet()) {
			mapkey_order.add(key);
		}
		mapkey_order.sort(null);
		
			//read out records
		for(Integer key : mapkey_order) {
			String[] record =  this.getMenu().get(key);
			
			if(record.length >= 2 && record[1].equals("nichtalkoholisches Getraenk")) {
				textBufferNichtAlkohol.append("\n");
				for(int j = 0; j < record.length; j++) {
					if(j != 0) {
						textBufferNichtAlkohol.append(" | ");
					}
					textBufferNichtAlkohol.append(record[j]);
					//fill in blanks to have equal space in between values
					for(int i = 0; i < spacing - record[j].length(); i++) {
						textBufferNichtAlkohol.append(" ");
					}
				}
			} else if(record.length >= 2 && record[1].equals("alkoholisches Getraenk")) {
				textBufferAlkohol.append("\n");
				for(int j = 0; j < record.length; j++) {
					if(j != 0) {
						textBufferAlkohol.append(" | ");
					}
					textBufferAlkohol.append(record[j]);
					//fill in blanks to have equal space in between values
					for(int i = 0; i < spacing - record[j].length(); i++) {
						textBufferAlkohol.append(" ");
					}
				}
			} else {
				//if this section executes, the record cannot be associated with a known type
				unknown = true;
				textBufferUnknown.append("\n");
				for(int i = 0; i < record.length; i++) {
					if(i != 0) {
						textBufferUnknown.append(" | ");
					}
					textBufferUnknown.append("val" + i + ": " + record[i]);
				}
			}
		}
		
			//executes if unknown type has been found
		try {
			if(unknown) {
				throw new RuntimeException(textBufferUnknown.toString());
			}
		} catch (RuntimeException e) {
				e.printStackTrace();
		}
		
		
		//return string
		return textBufferNichtAlkohol.toString() + "\n\n" + textBufferAlkohol.toString();
	}

	
	//features
	@Override
	protected AGetraenk createGericht(int selection_num) {
		AGetraenk getraenk;
		if(this.getMenu().containsKey(selection_num)){
			//try accessing and converting all expected indexes
			boolean valid_parameters = true;
			int num = 0;
			String type = "";
			String name = "";
			float price = 0.0f;
			float kcal = 0.0f;
			float alc = 0.0f;
			try {
				String[] record = this.getMenu().get(selection_num);
				num = Integer.parseInt(record[0]);
				type = record[1];
				//check for getraenk type and act accordingly
				if(type.equals("nichtalkoholisches Getraenk")) {
					name = record[2];
					price = Float.parseFloat(record[3]);
					kcal = Float.parseFloat(record[4]);
				} else if(type.equals("alkoholisches Getraenk")) {
					name = record[2];
					price = Float.parseFloat(record[3]);
					kcal = Float.parseFloat(record[4]);
					alc = Float.parseFloat(record[5]);
				} else {
					throw new RuntimeException();
				}
			} catch(NumberFormatException | NullPointerException e) {
				valid_parameters = false;
				System.err.println("Menu entry for Getraenk is not valid, check format of values!");
				e.printStackTrace();
			} catch(ArrayIndexOutOfBoundsException e) {
				valid_parameters = false;
				System.err.println("Menu entry for Getraenk is not valid, check for amount of individual values");
				e.printStackTrace();
			} catch(RuntimeException e) {
				valid_parameters = false;
				System.err.println("Menu entry for Getraenk is not valid, check type value");
				e.printStackTrace();
			} finally {
				//create getraenk depending on type
				if(valid_parameters && type.equals("nichtalkoholisches Getraenk")) {
					getraenk = new GetraenkNichtAlkohol(num, name, price, kcal);
				} else if (valid_parameters && type.equals("alkoholisches Getraenk")){
					getraenk = new GetraenkAlkohol(num, name, price, kcal, alc);
				} else if(valid_parameters) {
					//if this section executes, available valid type values might have been updated in try block
					getraenk = null;
					throw new RuntimeException("Unexpected program behaviour, check available type values in program code!");
				} else {
					getraenk = null;
				}
			}
		} else {
			getraenk = null;
			System.out.println("Select getraenk is not available!");
		}
		return getraenk;
	}
}
