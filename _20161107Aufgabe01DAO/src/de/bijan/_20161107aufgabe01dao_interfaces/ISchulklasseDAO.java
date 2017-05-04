package de.bijan._20161107aufgabe01dao_interfaces;

import de.bijan._20161107aufgabe01dao_classes.Schueler;

public interface ISchulklasseDAO {

	void addSchueler(Schueler schueler);
	void updateSchueler(String firstNameOld, String lastNameOld, int ageOld, String genderOld, String firstNameNew, String lastNameNew, int ageNew);
	Schueler returnSchueler(int index);
	Schueler returnSchueler(String firstName, String lastName, int age, String gender);
	void deleteSchueler(int index);
	void deleteSchueler(String firstName, String lastName, int age, String gender);
}
