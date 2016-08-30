package com.animalsinzoo;

import java.util.Scanner;
	
public class Zoo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String userMenuInput = null;
		boolean menuCorrect = true;
		
		System.out.println("Welcome to the zoo animals' information program");
		
		do {
			System.out.println("Press 1 to read to the database" + "\nPress 2 to add to the database"
					+"\nPress 3 to update the database" 
					+"\nPress 4 to delete an animal from the database"
					+"\nPress 5 to exit the database");
			userMenuInput = sc.nextLine();
			switch (userMenuInput) {
			case "1":
				DAOZoo.readFromDB();
				System.out.println("");
				break;
			case "2":
				//DAOZoo.writeToDatabase();
				System.out.println("");
				System.out.println("New field added.");
				System.out.println("");
				break;
			case "3":
				//DAOZoo.updateToDatabase();
				System.out.println("");
				System.out.println("Update complete.");
				System.out.println("");
				break;
			case "4":
				//DAOZoo.deleteFromDB();
				System.out.println("");
				System.out.println("Termination...accomplished!");
				System.out.println("");
				break;
			case "5":
				System.out.println("Thank you for using the database, good bye.");
				menuCorrect = false;
				break;
			default:
				System.out.println("Invalid option entered, please select an available menu option");
				menuCorrect = true;
				break;
			}
		} while (menuCorrect);
		
	}// main

} // class
