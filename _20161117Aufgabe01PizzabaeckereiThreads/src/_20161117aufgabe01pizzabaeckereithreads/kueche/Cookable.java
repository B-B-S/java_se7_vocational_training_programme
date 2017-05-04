package _20161117aufgabe01pizzabaeckereithreads.kueche;

import java.util.Vector;

public interface Cookable {
	
	//features
	AGericht createGericht(int selectionNum);
	Vector<Integer> availableSelections();
}
