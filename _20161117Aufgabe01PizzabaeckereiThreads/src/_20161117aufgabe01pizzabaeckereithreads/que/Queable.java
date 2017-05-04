package _20161117aufgabe01pizzabaeckereithreads.que;

import java.util.Vector;

public interface Queable {
	
	//getters and setters
	int getMaxQue();
	int getOrderNumber();
	int getMaxOrderNumber();
	
	//features (methods' implementation should be synchronized in multi-threading environment)
	void storeOrder(Vector<Integer> order) throws InterruptedException;
	Vector<Integer> retrieveOrder() throws InterruptedException;
}
