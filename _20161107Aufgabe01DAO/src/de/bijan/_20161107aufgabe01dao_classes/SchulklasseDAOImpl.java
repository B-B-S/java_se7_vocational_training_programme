package de.bijan._20161107aufgabe01dao_classes;

import de.bijan._20161107aufgabe01dao_interfaces.ISchulklasseDAO;

/**
 * DAO makes sure that two Schueler in the Schulklasse cannot share the exact same attributes 
 */
public class SchulklasseDAOImpl implements ISchulklasseDAO{

	//attributes
	private Schulklasse schulklasse;
	
	
	//getter and setter (only to be used internally)
	private Schulklasse getSchulklasse() {
		return this.schulklasse;
	}
	private void setSchulklasse(Schulklasse schulklasse) {
		this.schulklasse = schulklasse;
	}
	
	
	//constructors
	public SchulklasseDAOImpl(Schulklasse schulklasse) {
		super();
		//check if schulklasse parameter contains duplicate schueler entries in regards to their attributes, 
		//if so create Schulklasse in DAO without any pupils and standard values
		int counter = 0;
		for(int j = 0; j < schulklasse.getMemberList().size(); j++) {
			for(int i = 0; i < schulklasse.getMemberList().size(); i++) {
				Schueler schueler1 = (Schueler)schulklasse.getMemberList().elementAtIndex(j);
				Schueler schueler2 = (Schueler)schulklasse.getMemberList().elementAtIndex(i);
				if(j != i && schueler1.equals(schueler2)) {
					counter++;
				}
			}
		}
		if(counter > 0) {
			this.setSchulklasse(new Schulklasse("2B", "Sebastian", "Mueller", new Schueler[0]));
			System.out.println("Duplication in pupil's attributes while initialising DAO. Created standard value Schulklasse without any pupils");
		} else {
			this.setSchulklasse(schulklasse);
		}
	}
	
	
	@Override
	public void addSchueler(Schueler schueler) {
		int counter = 0;
		for(int i = 0; i < this.getSchulklasse().getMemberList().size(); i++) {
			if(this.getSchulklasse().getMemberList().elementAtIndex(i).equals(schueler)) {
				counter++;
			}
		}
		//check whether schueler does not exist in Schulklasse yet and add to Schulklasse if so
		if(counter == 0) {
			this.getSchulklasse().getMemberList().add(schueler);
		} else {
			System.out.println("Pupil could not be added to data source, as it already exists in it.");
		}
	}
	@Override
	public void updateSchueler(String firstNameOld, String lastNameOld, int ageOld, String genderOld, String firstNameNew, String lastNameNew, int ageNew) {
		int foundAtPosition = -1;
		//check if schueler with specified attributes exists in datasource, if so store position
		for(int i = 0; i < this.getSchulklasse().getMemberList().size(); i++) {
			Schueler schueler = (Schueler)this.getSchulklasse().getMemberList().elementAtIndex(i);
			if(	schueler.getFirstName().equals(firstNameOld)
				&& schueler.getLastName().equals(lastNameOld)
				&& schueler.getAge() == ageOld
				&& schueler.getGender().equals(genderOld)) {
				foundAtPosition = i;
			}
		}
		//if the schueler could be found at datasource, it will be updated with specified value at the position it has been found at
		if(foundAtPosition >= 0){
			Schueler updateSchueler = (Schueler)this.getSchulklasse().getMemberList().elementAtIndex(foundAtPosition);
			updateSchueler.setFirstName(firstNameNew);
			updateSchueler.setLastName(lastNameNew);
			updateSchueler.setAge(ageNew);
		} else {
			System.out.println("Entry could not be found in data source.");
		}
	}
	@Override
	public Schueler returnSchueler(int index) {
		if(index >= 0 && index < this.getSchulklasse().getMemberList().size()) {
			return (Schueler)this.getSchulklasse().getMemberList().elementAtIndex(index);
		} else {
			System.out.println("Specified index cannot used to return pupil from datasource (entries in datasource: " + this.getSchulklasse().getMemberList().size() + ").");
			return null;
		}
	}
	@Override
	public Schueler returnSchueler(String firstName, String lastName, int age, String gender){
		int foundAtPosition = -1;
		//check if schueler with specified attributes exists in datasource, if so store position
		for(int i = 0; i < this.getSchulklasse().getMemberList().size(); i++) {
			Schueler schueler = (Schueler)this.getSchulklasse().getMemberList().elementAtIndex(i);
			if(	schueler.getFirstName().equals(firstName)
				&& schueler.getLastName().equals(lastName)
				&& schueler.getAge() == age
				&& schueler.getGender().equals(gender)) {
				foundAtPosition = i;
			}
		}
		//if the schueler could be found at datasource, it will be returned from the position it has been found at
		if(foundAtPosition >= 0){
			return (Schueler)this.getSchulklasse().getMemberList().elementAtIndex(foundAtPosition);
		} else {
			System.out.println("Entry could not be found in data source.");
			return null;
		}
	}
	@Override
	public void deleteSchueler(int index) {
		if(index >= 0 && index < this.getSchulklasse().getMemberList().size()) {
			this.getSchulklasse().getMemberList().remove(index);
		} else {
			System.out.println("Specified index is not part of data source (entries in datasource: " + this.getSchulklasse().getMemberList().size() + ").");
		}
	}
	@Override
	public void deleteSchueler(String firstName, String lastName, int age, String gender) {
		int foundAtPosition = -1;
		//check if schueler with specified attributes exists in datasource, if so store position
		for(int i = 0; i < this.getSchulklasse().getMemberList().size(); i++) {
			Schueler schueler = (Schueler)this.getSchulklasse().getMemberList().elementAtIndex(i);
			if(	schueler.getFirstName().equals(firstName)
				&& schueler.getLastName().equals(lastName)
				&& schueler.getAge() == age
				&& schueler.getGender().equals(gender)) {
				foundAtPosition = i;
			}
		}
		//if the schueler could be found at datasource, it will be deleted from it
		if(foundAtPosition >= 0) {
			this.getSchulklasse().getMemberList().remove(foundAtPosition);
		} else {
			System.out.println("Pupil could not be found in datasource.");
		}
	}

	
}
