package de.bijan._20170113aufgabe01u03lesepfade.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	//attributes
	private BufferedWriter pathListing;
	
	//getters and setters
	public BufferedWriter getPathListing() {
		return this.pathListing;
	}
	public void setPathListing(BufferedWriter pathListing) {
		this.pathListing = pathListing;
	}
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		File outputPath = new File(System.getProperty("user.home") + "/" + "filesystemcontent.txt");
		outputPath.delete();
		main.setPathListing(new BufferedWriter(new FileWriter(outputPath, true)));
		
		//get all drives
		File[] allRoots = File.listRoots();
		
		//write out first line
		main.getPathListing().write("Content of all drives in system:");
		main.getPathListing().flush();
		
		//write out information
		for(File currPath : allRoots) {
			//write drive letter
			main.getPathListing().newLine();
			main.getPathListing().write(currPath.toString());
			main.getPathListing().flush();
			
			//read in drive
			if(currPath.canRead() && currPath.listFiles() != null) {
				//read in all files in root directory of drive
				for(File file : currPath.listFiles()) {
					if(file.isFile()) {
						main.getPathListing().newLine();
						main.getPathListing().write("\t");
						main.getPathListing().write(file.getName());
					}
				}
				main.getPathListing().flush();
				
				//call method to read in all sub-folders in drive
				for(File path : currPath.listFiles()) {
					if(path.isDirectory()) {
						main.readSubFolder(path, "\t");
						main.getPathListing().flush();
					}
				}
			}
			
			
		}
		main.getPathListing().close();
	}
	
	public void readSubFolder(File path, String tabs) throws IOException {
		this.getPathListing().newLine();
		this.getPathListing().write(tabs);
		this.getPathListing().write(path.getName());
		
		//add one more tab for files and sub-folders
		tabs += "\t";
				
		if(path.canRead() && path.listFiles() != null) {
			//read in files
			for(File file : path.listFiles()) {
				if(file.isFile()) {
					this.getPathListing().newLine();;
					this.getPathListing().write(tabs);
					this.getPathListing().write(file.getName());
				}
			}
			this.getPathListing().flush();
			
			//recurse into sub-directories
			for(File subDir : path.listFiles()) {
				if(subDir.isDirectory()) {
					this.readSubFolder(subDir, tabs);
				}
			}
		}
	}
}
