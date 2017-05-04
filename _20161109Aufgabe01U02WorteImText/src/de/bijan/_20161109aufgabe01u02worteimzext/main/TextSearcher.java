package de.bijan._20161109aufgabe01u02worteimzext.main;

import java.util.ArrayList;

public class TextSearcher {
	
	//attributes
	private String searchedInText;
	
	
	//getter and setter
	public String getSearchedInText() {
		return this.searchedInText;
	}
	public void setSearchedInText(String searchedInText) {
		this.searchedInText = searchedInText;
	}
	

	//contstructors
	public TextSearcher(String searchedInText) {
		super();
		this.setSearchedInText(searchedInText);
	}
	
	
	//standard methods
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " string in which look-up operations will be performed: \n" + this.getSearchedInText();
	}
	
	
	//features
	/**
	 * method returns array list that contains each unique word in text with its number of occurences
	 * internally array lists will be used to process the words/text
	 * 
	 * @return ArrayList<String> list of strings that contains each unique word and its number of occurrences in text
	 */
	public ArrayList<String> allWordsOccurenceList() {
		char blank = 32;
		
		//get pre-processed text with word separating characters replaced by blanks and flanked by blanks
		String preprocessedText = blank + this.preProcessSearchedInText() + blank;
		
		//create a list that stores each unique word in text, create a list that stores each unique word in text with amount of occurrences
		ArrayList<String> uniqueWordList = new ArrayList<String>();
		ArrayList<String> uniqueWordOccurencesList = new ArrayList<String>();
		//fill lists
		StringBuilder uniqueWord = new StringBuilder("");
		for(int i = 0; i < preprocessedText.length(); i++) {
			//write word to lists if not already present (word is written, when next blank is reached),
			//also write associated amount of occurrences to corresponding list
			if(preprocessedText.charAt(i) == blank && uniqueWord.length() > 0 && !uniqueWordList.contains(uniqueWord.toString())) {
				uniqueWordList.add(uniqueWord.toString());
				uniqueWordOccurencesList.add(uniqueWord.toString() + ": " + this.oneWordOccurence(uniqueWord.toString()));
				//reset StringBuilder
				uniqueWord = new  StringBuilder("");
			} else if(preprocessedText.charAt(i) == blank) {
				//reset StringBuilder
				uniqueWord = new  StringBuilder("");
			} else {
				//fill StringBuilder
				uniqueWord.append(preprocessedText.charAt(i));
			}
		}
		
		//return output list
		return uniqueWordOccurencesList;
	}
	
	/**
	 * method returns array that contain each unique word in text with its number of occurrences
	 * internally arrays will be used to process the words/text
	 * 
	 * @return String[] array that contains each unique word and its number of occurrences in text
	 */
	public String[] allWordsOccurenceArrays() {
		char blank = 32;
		
		//get pre-processed text with word separating characters replaced by blanks and flanked by blanks
		String preprocessedText = blank + this.preProcessSearchedInText() + blank;
		
		//create an array that stores each unique word in text
		String[] uniqueWordArray = new String[0];
		//fill array
		StringBuilder uniqueWord = new StringBuilder("");
		for(int j = 0; j < preprocessedText.length(); j++) {
			//write word to array if not already present (word is written, when next blank is reached)
			if(preprocessedText.charAt(j) == blank && uniqueWord.length() > 0) {
				//check if word is already present in array
				boolean wordPresent = false;
				for(String word : uniqueWordArray) {
					if(word.equals(uniqueWord.toString())) {
						wordPresent = true;
					}
				}
				//add word to array if not already present
				if(wordPresent == false) {
					String[] uniqueWordArrayOld = uniqueWordArray;
					uniqueWordArray = new String[uniqueWordArrayOld.length + 1];
					for(int i = 0; i < uniqueWordArrayOld.length; i++) {
						uniqueWordArray[i] = uniqueWordArrayOld[i];
					}
					uniqueWordArray[uniqueWordArray.length-1] = uniqueWord.toString();
				}
				//reset StringBuilder
				uniqueWord = new StringBuilder("");
			} else if (preprocessedText.charAt(j) != blank){
				//fill StringBuilder
				uniqueWord.append(preprocessedText.charAt(j));
			}
		}
		
		//create an array that stores amount of occurences of each unique word in same sequence as array that stores unique words
		//also create additional string output array, that combines the two
		int[] occurencesArray = new int[uniqueWordArray.length];
		String[] outputArray = new String[uniqueWordArray.length];
		//fill arrays
		for(int i = 0; i < occurencesArray.length; i++) {
			occurencesArray[i] = this.oneWordOccurence(uniqueWordArray[i]);
			outputArray[i] = uniqueWordArray[i] + ": " + occurencesArray[i]; 
		}
		
		//return output
		return outputArray;
	}
	
		/**
		 * method will search for word in text, typical word separating characters will be treated as word borders, including blanks
		 * 
		 * method calls preProcessSearchedInText() helper method internally
		 * 
		 * @param word Word that will be searched for in text
		 * @return int Amount of occurences of word in text
		 */
	public int oneWordOccurence(String word) {
		String text = this.getSearchedInText();
		if(word.isEmpty() || text.isEmpty() || word.length() > text.length()) {
			return 0;
		} else {
			int counter = 0;
			char blank = 32;
			
			//replace word separating characters with blanks and add flanking blanks to text
			String preprocessedText = blank + this.preProcessSearchedInText() + blank;
			//add flanking blanks to word
			word = blank + word + blank;
			
			//count occurrences of word in text
			for(int i = 0; i < preprocessedText.length(); i++) {
				if(preprocessedText.regionMatches(i, word, 0, word.length())) {
					counter++;
				}
			}
			return counter;
		}
	}
	
	
	//internal helper methods
		//replace all word separating characters with blanks (periods, semi-colons, tabulator, etc.) and return string
	private String preProcessSearchedInText() {
		StringBuilder preprocessedTextSB = new StringBuilder("");
		char blank = 32;
		for(int i = 0; i < this.getSearchedInText().length(); i++) {
			switch(this.getSearchedInText().charAt(i)) {
				case 9:
				case 10:
				case 13:
				case 33:
				case 34:
				case 38:
				case 39:
				case 40:
				case 41:
				case 46:
				case 47:
				case 58:
				case 59:
				case 63:
				case 64:
				case 91:
				case 92:
				case 93:
				case 123:
				case 124:
				case 125:
					//replace word separating character with blank
					preprocessedTextSB.append(blank);
					break;
				default:
					preprocessedTextSB.append(this.getSearchedInText().charAt(i));
					break;
			}
		}
		return preprocessedTextSB.toString();
	}
}
