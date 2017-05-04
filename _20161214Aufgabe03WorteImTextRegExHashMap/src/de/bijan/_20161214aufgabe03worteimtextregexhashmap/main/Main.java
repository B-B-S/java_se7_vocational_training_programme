package de.bijan._20161214aufgabe03worteimtextregexhashmap.main;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		ReadInTextFile text = new ReadInTextFile("suchtext.txt");
		
		//define the separator and the pattern to find a word
		String separator = "[ \\.;,\\?!]";
		Pattern pattern = Pattern.compile(separator + "+" + "[a-zA-Z0-9]+" + separator + "+");
		
		//create matcher from text to be searched in for words, add a leading and a trailing blank as "word separator"
		Matcher matcher = pattern.matcher(" " + text.readInText() + " ");
		
		//create a TreeMap with each word appearing once as a key and its amount of appearances as value
		TreeMap<String,Integer> map = new TreeMap<>();
		while(matcher.find()) {
			//if word has already been found once, increment value by one, otherwise add word as key and set value to 1 (remove separators as well)
			String group = matcher.group().replaceAll(separator, "");
			int counter = map.get(group) == null ? 1 : map.get(group) + 1;
			map.put(group, counter);
		}
		
		//print text input
		System.out.println(text.readInText());
		
		//print text output
		for(Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
