package de.bijan._20161107aufgabe01dao_classes;

import de.bijan.arraylistwannabe.ArrayListWannabe;

public class Schulklasse {
	
	//attributes
	private String identifier;
	private String teacherFirstName;
	private String teacherLastName;
	private ArrayListWannabe memberList;
	
	
	//getter and setter (memberList can only be set internally)
	public String getIdentifier() {
		return this.identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getTeacherFirstName() {
		return this.teacherFirstName;
	}
	public void setTeacherFirstName(String teacherFirstName) {
		this.teacherFirstName = teacherFirstName;
	}
	public String getTeacherLastName() {
		return this.teacherLastName;
	}
	public void setTeacherLastName(String teacherLastName) {
		this.teacherLastName = teacherLastName;
	}
	public ArrayListWannabe getMemberList() {
		return this.memberList;
	}
	private void setMemberList(ArrayListWannabe memberList) {
		this.memberList = memberList;
	}
	
	
	//contructors
	public Schulklasse() {
		this("1A", "Heinz", "Mueller", new Schueler[0]);
	}
	public Schulklasse(String identifier, String teacherFirstName, String teacherLastName) {
		this(identifier, teacherFirstName, teacherLastName, new Schueler[0]);
	}
	public Schulklasse(String identifier, String teacherFirstName, String teacherLastName, Schueler... schuelerArray) {
		super();
		this.setIdentifier(identifier);
		this.setTeacherFirstName(teacherFirstName);
		this.setTeacherLastName(teacherLastName);
		if(schuelerArray.length == 0) {
			this.setMemberList(new ArrayListWannabe());
		} else {
			this.setMemberList(new ArrayListWannabe((Object[])schuelerArray));
		}
	}
}
