package de.bijan._20161024Aufgabe02dreieckEntwurf;

public class Main {

	public static void main(String[] args) {
		Triangle triangle1 = new Triangle(5,4,3);
		System.out.println(triangle1.toString());
		System.out.println(triangle1.isPerpendicular());
		System.out.println(triangle1.type());
		System.out.println(triangle1.calcPeriphery());
		System.out.println(triangle1.calcArea());
		
		Triangle triangle2 = new Triangle(5,5,3);
		System.out.println(triangle2.toString());
		System.out.println(triangle2.isPerpendicular());
		System.out.println(triangle2.type());
		System.out.println(triangle2.calcPeriphery());
		System.out.println(triangle2.calcArea());
		
		Triangle triangle3 = new Triangle(5,5,5);
		System.out.println(triangle3.toString());
		System.out.println(triangle3.isPerpendicular());
		System.out.println(triangle3.type());
		System.out.println(triangle3.calcPeriphery());
		System.out.println(triangle3.calcArea());
		
		Triangle triangle4 = new Triangle(10,20,30);
		System.out.println(triangle4.toString());
		System.out.println(triangle4.isPerpendicular());
		System.out.println(triangle4.type());
		System.out.println(triangle4.calcPeriphery());
		System.out.println(triangle4.calcArea());
	}

}
