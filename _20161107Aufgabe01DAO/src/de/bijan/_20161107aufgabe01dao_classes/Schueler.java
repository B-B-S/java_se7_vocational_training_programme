package de.bijan._20161107aufgabe01dao_classes;

/**
 * 
 * @author teilnehmer
 * @param  first name
 * @param  last name
 * @param  age (>=5)
 * @param  gender ("male"/"m", "female"/"f", "both"/"b",) 
 *         the non-abbreviated versions wil be stored
 *
 */
public class Schueler {
	
	//attributes
	private String firstName;
	private String lastName;
	private int age = 5;
	private String gender = "both";
	
	
	//setter and getter (gender is not changeable from outside of the class)
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		if(age >= 5) {
			this.age = age;
		} else {
			System.out.println("Schueler " + this.getFirstName() + " " + this.getLastName()
								+ " would be to young to be in school (current set age value" + this.getAge() + ").");
		}
	}
	public String getGender() {
		return this.gender;
	}
	private void setGender(String gender) {
		gender = gender.toUpperCase();
		switch(gender) {
			case "MALE":
			case "M":
				this.gender = "male";
				break;
			case "FEMALE":
			case "F":
				this.gender = "female";
				break;
			case "BOTH":
			case "B":
				this.gender = "both";
				break;
			default:
				System.out.println("Gender must be male/m, female/f, both/b, gender has not been changed (currently"
									+ this.getGender() + ").");
		}
	}
	
	
	//constructors
	public Schueler() {
		this("Harald", "Mueller", 18, "m");
	}
	public Schueler(String firstName, String lastName, int age, String gender) {
		super();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAge(age);
		this.setGender(gender);
	}
	
	
	//standard methods
	// toString()
	@Override
	public String toString() {
		return  this.getClass().getSimpleName() + "\r\n" + "first name: " + this.getFirstName()
				+ "\r\n" + "last name: " + this.getLastName()
				+ "\r\n" + "age: " + this.getAge() + "\r\n" + "gender: " + this.getGender()
		;
	}
	// equals()
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other instanceof Schueler) {
			Schueler that = (Schueler) other;
			//attribute comparison
			return	this.getFirstName().equals(that.getFirstName())
					&& this.getLastName().equals(that.getLastName())
					&& this.getAge() == that.getAge()
					&& this.getGender().equals(that.getGender())
			;
		} else {
			return false;
		}
	}
	
	
	//features
	public void celebrateBirthday() {
		this.setAge(this.getAge() + 1);
		System.out.println("Hurray! Today's " + this.getFirstName() + "'s birthday!");
	}
}
