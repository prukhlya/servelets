package com.animalsinzoo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.hithursday.Student;

public class DAOZoo {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=rootautoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";

	static Connection CONN = null; // caps because they are class variables -
									// best practice naming
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;

	static Scanner sc = new Scanner(System.in);

	public static void connToDB() { // method connects to the database

		try {

			Class.forName(JDBC_DRIVER);
			System.out.println("Trying to connect to the Database...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the Database.");
		} catch (Exception e) {
			System.out.println("Failed to connect to the Database.");
			e.printStackTrace();

		}

	} // connToDB

	public static void readFromDB() {

		connToDB(); // method call to connect to the database

		ArrayList<Animal> ourAnimals = new ArrayList<>();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM zoo.animals_in_zoo;");

			while (RES_SET.next()) { // fetching the data from the db
				Animal animalInDB = new Animal();

				// properties that are being fetched from the db and stored in
				// animalInDB
				animalInDB.setAnimalID(RES_SET.getInt("animal_id"));
				animalInDB.setAnimalSpecies(RES_SET.getString("animal_species"));
				animalInDB.setAnimalName(RES_SET.getString("animal_name"));
				animalInDB.setAnimalAge(RES_SET.getInt("animal_age"));
				animalInDB.setAnimalWeight(RES_SET.getDouble("animal_weight"));

				ourAnimals.add(animalInDB); // adding properties that are being
											// fetched from the db and stored in
											// studentInDB to the arraylist
			}
			for (Animal animal : ourAnimals) { // for each loop/enhanced for
												// loop
				System.out.println(animal.toString());
			} // for

		} catch (SQLException e) {
			e.printStackTrace();
		} // catch

	} // readFromDB() method

	public static void writeToDatabase(Animal animal) {

		connToDB();

		try {

			PREP_STMT = CONN.prepareStatement(insertToDB);

			PREP_STMT.setString(1, animal.getAnimalSpecies());
			PREP_STMT.setString(2, animal.getAnimalName());
			PREP_STMT.setInt(3, animal.getAnimalAge());
			PREP_STMT.setDouble(4, animal.getAnimalWeight());

			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //write

	public static void updateToDatabase(Animal animal) {

		connToDB();

		try {

			PREP_STMT = CONN.prepareStatement(updateToDB);

			PREP_STMT.setInt(1, animal.getAnimalID());
			PREP_STMT.setString(2, animal.getAnimalSpecies());
			PREP_STMT.setString(3, animal.getAnimalName());
			PREP_STMT.setInt(4, animal.getAnimalAge());
			PREP_STMT.setDouble(5, animal.getAnimalWeight());
			PREP_STMT.setInt(6, animal.getAnimalID());

			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // updateToDatabase

	private static String insertToDB = "INSERT INTO `zoo`.`animals_in_zoo`"
			+ "(animal_species, animal_name, animal_age, animal_weight)" + " VALUES " + "(?, ?, ?, ?)";

	private static String updateToDB = "UPDATE `zoo`.`animals_in_zoo`SET" + " animal_id = ?," + " animal_species = ?,"
			+ " animal_name = ?," + "animal_age = ?," + "animal_weight = ?" + "WHERE animal_id = ?";

	public static String deleteFromDB = "DELETE FROM `zoo`.`animals_in_zoo`" + "WHERE animal_id= ?";

	public static void deleteFromDB(Animal animal) {

		

		connToDB();

		try {
			PREP_STMT = CONN.prepareStatement(deleteFromDB);
			PREP_STMT.setInt(1, animal.getAnimalID());
			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// deletefromDB

	public static Animal animalToDelete() {

		Animal animalToDelete = new Animal();

		System.out.println("What is the Animal ID of the animal you wish to terminate?");
		animalToDelete.setAnimalID(Integer.parseInt(sc.nextLine()));

		return animalToDelete;

	}// animal to delete

//	public static Animal updateTheAnimal() { //not being used because no scanner love
//
//		Animal animalToUpdate = new Animal();
//
//		System.out.println("Enter the ID of the animal you want to update:");
//		animalToUpdate.setAnimalID(Integer.parseInt(sc.nextLine()));
//
//		System.out.println("What is the animal's species?");
//		animalToUpdate.setAnimalSpecies(sc.nextLine());
//
//		System.out.println("What is the animal's name?");
//		animalToUpdate.setAnimalName(sc.nextLine());
//
//		System.out.println("What is animal's age?");
//		animalToUpdate.setAnimalAge(Integer.parseInt(sc.nextLine()));
//
//		System.out.println("What is the animal's weight?");
//		animalToUpdate.setAnimalWeight(Double.parseDouble(sc.nextLine()));
//
//		return animalToUpdate;
//
//	} // updateTheAnimal

	public static Animal aboutTheAnimal() {

		Animal animalToAdd = new Animal();

		System.out.println("What is the animal's species?");
		animalToAdd.setAnimalSpecies(sc.nextLine());

		System.out.println("What is the animal's name?");
		animalToAdd.setAnimalName(sc.nextLine());

		System.out.println("What is animal's age?");
		animalToAdd.setAnimalAge(Integer.parseInt(sc.nextLine()));

		System.out.println("What is the animal's weight?");
		animalToAdd.setAnimalWeight(Double.parseDouble(sc.nextLine()));

		return animalToAdd;

	} // aboutTheAnimal

} // class DAO

	// public static void writeToDB() {
	// connToDB(); //method call to connect to the database
	// try {
	// STMT = CONN.createStatement();
	// STMT.executeUpdate(
	// "INSERT INTO `zoo`.`animals_in_zoo`(animal_species, animal_name,
	// animal_age, animal_weight)"
	// + "VALUES ('Pig', 'Bacon', 5, 1350.50)");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// } //writeToDB


