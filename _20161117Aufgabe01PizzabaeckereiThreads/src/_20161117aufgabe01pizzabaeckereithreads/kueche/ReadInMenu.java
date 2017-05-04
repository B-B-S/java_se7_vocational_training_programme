package _20161117aufgabe01pizzabaeckereithreads.kueche;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ReadInMenu {
		
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
		public ReadInMenu(String filePath) {
			super();
			this.setFilePath(filePath);
		}
		
		
		//standard methods
		@Override
		public String toString() {
			return this.getClass().getSimpleName() + "file path of file to be read in: \n" + this.getFilePath();
		}
		
		
		//features
			//read in text file (menu), each line's comma separated values are read into an array as individual entries
			//each array (representing each record) is then added to a map
		public HashMap<Integer, String[]> readInMenu() {
			HashMap<Integer, String[]> menu = new HashMap<>();
			try(Scanner scan = new Scanner(new File(this.getFilePath()))) {
				int countlines = 0;
				while(scan.hasNextLine()) {
					String[] line = scan.nextLine().split(",");
					if(line.length > 0 && intPresent(line[0])) {
						countlines++;
						menu.put(Integer.valueOf(line[0]), line);
					} else {
						throw new RuntimeException("Empty record in between other records"
											+ " or first comma separated value is not an integer and/or blanks are part of it."
											+ " First comma separated value should represent menu entry number!");
					}
				}
				//check whether duplicate menu entry numbers exist in input text file
				if(countlines != menu.size()) {
					throw new RuntimeException("Duplicate menu entry numbers in input text file (first comma separated value)!");
				}
			} catch(FileNotFoundException e) {
				System.err.println("File (" + this.getFilePath() + " could not be found!");
				e.printStackTrace();
			} catch(RuntimeException e) {
				e.printStackTrace();
			}
			return menu;
		}
		
		
		//internal helper methods
			//check whether checked text consists of digits only and represents a valid integer
		private boolean intPresent(String checkText) {
			boolean present;
			if(checkText.length() == 0) {
				present = false;
			} else {
				present = true;
				for(int i = 0; i < checkText.length(); i++) {
					switch(checkText.charAt(i)) {
						case 48:
						case 49:
						case 50:
						case 51:
						case 52:
						case 53:
						case 54:
						case 55:
						case 56:
						case 57:
							//do nothing
							break;
						default:
							present = false;
							break;
						
					}
				}
			}
			return present;
		}
	}
