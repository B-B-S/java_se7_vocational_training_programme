package de.bijan._20161214aufgabe02emailadressvalidatorregex.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	//rules for validation:
	//Lokalteil
	//
	//A-Za-z0-9.!#$%&'*+-/=?^_`{|}~
	//am anfang und ende sind punkte untersagt
	//
	//
	//Hostname
	//
	//durch punkte abgetrennt, nur a-zA-Z0-9 und -
	//Einzelteile 5-63
	//
	//
	//Top-Level-Domain
	//
	//mindestens zwei Buchstaben
	//sub-domains mit Punkt abgetrennt
	//ein bis zwei Domaineinheiten
	
	public static void main(String[] args) {
		//read in user entry (email adress that is to be verified)
			//scanner will not be closed as this would lead to problems when trying to open another scanner on System.in later on
		System.out.println("Please provide an email adress that is to be verified:");
		Scanner scan = new Scanner(System.in);
		String address = null;
		if(scan.hasNextLine()) {
			address = scan.nextLine();
		}
		
		
		//compile pattern from regex
		StringBuilder regex = new StringBuilder();
			//section for local part, the section enclosed in round brackets stands for additional sub-parts, separated by periods
		regex.append("[A-Za-z0-9!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\|\\}~]+(\\.[A-Za-z0-9!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\|\\}~]+)*");
			//section for hostname, the section enclosed in round brackets stands for additional sub-parts separated by periods
		regex.append("@[A-Za-z0-9\\-]{5,63}(\\.[A-Za-z0-9\\-]{5,63})*");
			//section for top level domain, either one part or two parts (separated by period)
		regex.append("\\.[a-zA-Z]{2,3}(\\.[a-zA-Z]{2,3})?");
		Pattern pattern = Pattern.compile(regex.toString());
		
		
		//validate user entry
		Matcher matcher = pattern.matcher(address);
		boolean found = false;
		if(matcher.find() && matcher.group().length() == address.length()) {
			found = true;
		}
		
		
		//inform user about result
		if(found) {
			System.out.println("Congratulations, the email address you have provided is valid.");
		} else {
			System.out.println("Unfortunately, the email address you have provided is invalid.");
		}
	}

}
