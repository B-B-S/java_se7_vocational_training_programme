package _20161117aufgabe01pizzabaeckereithreads.que;

import java.util.Vector;

public class Que implements Queable {

	//attributes
	private int maxQue = 1;
	private int orderNumber = 1;
	private int maxOrderNumber = 1;
	private Vector<Vector<Integer>> orderVector;
	
	
	//getters and setters (only to be used internally)
	@Override
	public int getMaxQue() {
		return this.maxQue;
	}
	private void setMaxQue(int maxQue) {
		if(maxQue >= 1) {
			this.maxQue = maxQue;
		}
	}
	@Override
	public int getOrderNumber() {
		return this.orderNumber;
	}
	private void setOrderNumber() {
		if(this.orderNumber < this.getMaxOrderNumber()) {
			this.orderNumber++;
		} else {
			this.orderNumber = 1;
		}
	}
	@Override
	public int getMaxOrderNumber() {
		return this.maxOrderNumber;
	}
	private void setMaxOrderNumber(int maxOrderNumber) {
		if(maxOrderNumber >= 1) {
			this.maxOrderNumber = maxOrderNumber;
		}
	}
	private Vector<Vector<Integer>> getOrderVector() {
		return this.orderVector;
	}
	private void setOrderVector(Vector<Vector<Integer>> orderVector) {
		this.orderVector = orderVector;
	}
	
	
	//constructors
	public Que() {
		this(50, 999);
	}
	public Que(int maxQue, int maxOrderNumber) {
		this.setMaxQue(maxQue);
		this.setMaxOrderNumber(maxOrderNumber);
		this.setOrderVector(new Vector<Vector<Integer>>());
	}
	
	
	//standard methods
		//toString
	@Override
	public String toString() {
		return this.getClass().getSimpleName()	+ " maxQue: " + this.getMaxQue()
												+ "orderNumber: " + this.getOrderNumber()
												+ "maxOrderNumber: " + this.getMaxOrderNumber()
												+ "orderVector: " + this.getOrderVector()
		;
	}
	
	
	//features
	/**
	 * synchronized method that takes an order in form of a Vector<Integer> and stores it in a que represented by a vector as long as the que is not completely filled
	 * as long as the que is full, the calling thread will be sent to sleep and will release the lock by calling wait()
	 * after an order has been added to the que, all other threads will be woken up to proceed
	 * 
	 * @param Vector<Integer> order order to be stored represented by a Vector containing Integers, if vector is empty, it will not be stored
	 * 								when stored an order number will be added as first element
	 */
	public synchronized void storeOrder(Vector<Integer> order) throws InterruptedException {
		//have calling thread wait and sleep until space to add new elements is available again
		while(this.getOrderVector().size() == this.getMaxQue()) {
			wait();
		}
		
		//check whether order contains any items and add order number as first element to order
		// then add order to orderVector que
		// then set new order number
		if(order.size() > 0) {
			order.add(0, this.getOrderNumber());
			this.getOrderVector().add(order);
			this.setOrderNumber();
		} else {
			System.out.println("Specified order is empty!");
		}
		
		//wake up sleeping threads
		notifyAll();
	}
	
	/**
	 * synchronized method that returns an the first order in the que in the form of a Vector<Integer> and then removes it from the que as long as the que is not completely empty
	 * as long as the que is completely empty, the calling thread will be sent to sleep and will release the lock by calling wait()
	 * before returning the order, all other threads will be woken up to proceed
	 * 
	 * @return Vector<Integer> order	order stored as first element in que represented by a Vector containing Integers
	 * 									contains an order number as first element added when order gets put into que (see storeOrder method)  
	 */
	public synchronized Vector<Integer> retrieveOrder() throws InterruptedException{
		//have calling thread wait and sleep until elements are available again
		while(this.getOrderVector().size() == 0) {
			wait();
		}
		
		//retrieve first available element then remove it from orderVector que
		Vector<Integer> order = this.getOrderVector().firstElement();
		this.getOrderVector().removeElement(order);
		
		//wake up sleeping threads
		notifyAll();
		
		//return order
		return order;
	}
}
