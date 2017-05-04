package de.bijan._20161214aufgabe03worteimtextregexhashmap.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadInTextFile {
	
	//attributes
	String filePath;
	
	
	//getter and setter
	public String getFilePath() {
		return this.filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	//constructors
	public ReadInTextFile(String filePath) {
		super();
		this.setFilePath(filePath);
	}
	
	
	//standard methods
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "file path of file to be read in: \n" + this.getFilePath();
	}
	
	
	//features
		//read in text file (line breaks will be removed and replaced by blanks)
	public String readInText() {
		StringBuilder testtext = new StringBuilder("");
		char blank = 32;
		boolean filepresent = true;
		try(Scanner scan = new Scanner(new File(this.getFilePath()))) {
			while(scan.hasNextLine()) {
				testtext.append(scan.nextLine());
				testtext.append(blank);
			}
		} catch(FileNotFoundException e) {
			filepresent = false;
			System.out.println("File (" + this.getFilePath() + " could not be found!");
		}
		return filepresent ? testtext.toString() : "";
	}
}
