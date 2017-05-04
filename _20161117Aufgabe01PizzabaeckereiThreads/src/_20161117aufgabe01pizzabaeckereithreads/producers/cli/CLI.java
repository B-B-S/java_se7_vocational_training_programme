package _20161117aufgabe01pizzabaeckereithreads.producers.cli;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

import _20161117aufgabe01pizzabaeckereithreads.kueche.Kueche;
import _20161117aufgabe01pizzabaeckereithreads.que.Que;

public class CLI extends Thread {
	
	//attributes
	private Que que;
	private int sleepTime = 1;
	private Kueche kueche;
	
	
	//getters and setters (attributes can only be accessed internally)
	private Que getQue() {
		return this.que;
	}
	private void setQue(Que que) {
		this.que = que;
	}
	private int getSleepTime() {
		return this.sleepTime;
	}
	private void setSleepTime(int sleepTime) {
		if(sleepTime >= 1) {
			this.sleepTime = sleepTime;
		}
	}
	private Kueche getKueche() {
		return this.kueche;
	}
	private void setKueche(Kueche kueche) {
		this.kueche = kueche;
	}
	
	
	//constructors
	public CLI(String name, Que que) {
		this(name, que, 500);
	}
	public CLI(String name, Que que, int sleepTime) {
		super(name);
		this.setQue(que);
		this.setSleepTime(sleepTime);
		this.setKueche(new Kueche());
		//print menu to console once
		System.out.println(this.getKueche());
		System.out.println("Bitte waehlen geben Sie Ihre Bestellung auf. Enter bestaetigt Ihre Eingabe.");
		System.out.println("Wenn Sie fertig sind, schicken sie bitte ein x-Zeichen ab.");
		System.out.println("Zum beenden der Anwendung, schicken sie bitte ein q-Zeichen ab.");
	}
	
	
	//standard methods
		//toString
	@Override
	public String toString() {
		return super.toString() + " que: " + this.getQue() + " sleepTime: " + this.getSleepTime();
	}
	
	
	//features
	@Override
	public void run() {
		try (Scanner scan = new Scanner(System.in);){
			while(true) {
				//store user order in que
				this.getQue().storeOrder(this.queryUserOrder(scan));
				
				//confirm to user
				System.out.println("Danke fuer Ihre Bestellung!");
				
				//have thread sleep for specified time
				sleep((int) (Math.random() * this.getSleepTime()));
			}
		} catch(InterruptedException e) {
			//do nothing
		}
	}
	
	
	//internal helper methods
	/**
	 * ---------------------------------
	 * method is to be called in the thread's run method and needs a scanner object that reads from System.in
	 * ---------------------------------
	 * 
	 * method opens a loop over the user's keyboard to ask for menu entries to be selected
	 * every input will be confirmed by hitting the enter key
	 * if a valid integer has been input, it will be added to the order, if not it will be discarded
	 * if an x is put in and the order is still empty, the loop will continue, if it is not empty, the loop will stop and the order will be returned
	 * if a q is put in, the whole program will abort
	 * 
	 * @return Vector<Integer> order order to be returned consisting of Integer values collected from user input via keyboard
	 */
	private Vector<Integer> queryUserOrder(Scanner scan) {
		Vector<Integer> order = new Vector<>();
		
		//fill in user order, until user finishes ordering
		boolean emptyOrderAbort = false;
		String orderElement = null;
		do {
			emptyOrderAbort = false;
			boolean orderElementValid = true;
			try {
				orderElement = scan.nextLine();
				//check if input is valid Integer
				Integer.parseInt(orderElement);
			} catch(NumberFormatException | NoSuchElementException e) {
				//if input is not an Integer declare it as non-valid in regards to being an Integer
				orderElementValid = false;
			}
			
			//if valid Integer has been input by user add to order
			if(orderElementValid) {
				order.add(Integer.parseInt(orderElement));
			} else if(!orderElement.equals("x") && !orderElement.equals("X") && !orderElement.equals("q") && !orderElement.equals("Q")) {
				//display text for non-valid selection if no abort character has been input
				System.out.println("Bitte eine gueltige Menuewahl eingeben, ungueltige Wahl wurde verworfen!");
			} else if((orderElement.equals("x") || orderElement.equals("X")) && order.size() == 0) {
				//variable used to check loop abort requirements
				emptyOrderAbort = true;
				System.out.println("Bitte geben Sie mindestens eine Wahl an, bevor Sie Ihre Bestellung abschicken!");
			}
		} while	(	(!orderElement.equals("x") && !orderElement.equals("X") && !orderElement.equals("q") && !orderElement.equals("Q"))
					||
					//empty orders will not lead to abort of the loop when x has been specified by user
					((orderElement.equals("x") || orderElement.equals("X")) && emptyOrderAbort == true)
				);
		
		//abort program if specified by user
		if(orderElement.equals("q") || orderElement.equals("Q")) {
			System.exit(0);
		}
		
		//return order
		return order;
	}
}
