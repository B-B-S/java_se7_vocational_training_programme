package de.bijan._20161109aufgabe01u02worteimzext.main;

public class Main {

	public static void main(String[] args) {
		//read in text
		String text = new ReadInTextFile("C:/EclipseWorkspace/_20161109Aufgabe01U02WorteImText/suchtext.txt").readInText();
		System.out.println("Text that has been read in: \n" + text);
		System.out.println();
		
		
		//initialize text searcher
		TextSearcher searcher = new TextSearcher(text);
		System.out.println(searcher);
		System.out.println();
		
		
		//use text searcher
		System.out.println("Number of occurences of word Neuzeit: " + searcher.oneWordOccurence("Neuzeit"));
		System.out.println();
		
		System.out.println("Number of occurences of all words in text (using arrays):");
		System.out.print("[");
		String[] allWordOccurenceArray = searcher.allWordsOccurenceArrays(); 
		for(int i = 0; i < allWordOccurenceArray.length; i++) {
			if(i > 0) {
				System.out.print(", ");
			}
			System.out.print(allWordOccurenceArray[i]);
		}
		System.out.println("]");
		System.out.println();
		
		System.out.println("Number of occurences of all words in text (using arrays lists): ");
		System.out.println(searcher.allWordsOccurenceList());
		System.out.println();
	}
}
