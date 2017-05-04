package de.bijan._20161107aufgabe01dao_main;

import de.bijan._20161107aufgabe01dao_classes.Schueler;
import de.bijan._20161107aufgabe01dao_classes.Schulklasse;
import de.bijan._20161107aufgabe01dao_classes.SchulklasseDAOImpl;

public class DaoMain {

	public static void main(String[] args) {
//		Schulklasse schulklasse1 = new Schulklasse("2E", "Harrald", "Mann",
//													new Schueler("Peter", "Fischer", 9, "m"),
//													new Schueler("Maria", "Lasagne", 10, "f"))
//		;
//		SchulklasseDAOImpl dao1 = new SchulklasseDAOImpl(schulklasse1);
//		dao1.addSchueler(new Schueler("Peter", "Fischer", 10, "m"));
//		dao1.updateSchueler("Peter", "Fischer", 10, "male", "Hans", "Mueller", 10);
//		dao1.deleteSchueler("Hans", "Mueller", 10, "male");
//		System.out.println(dao1.returnSchueler(2));
		
		Schulklasse schulklasse2 = new Schulklasse("2E", "Harrald", "Mann", new Schueler("Peter", "Fischer", 9, "m"), new Schueler("Heinz", "Fischer", 9, "m"));
		SchulklasseDAOImpl dao2 = new SchulklasseDAOImpl(schulklasse2);
		System.out.println(dao2.returnSchueler(1));
		
	}

}
