/*
 * [CSCI 1301].java
 * Author:  [Catherine Tan] 
 * Submission Date:  [April 27, 2022]
 *
 * Purpose: Project 4, we create a game that utilizes multiple classes and methods. We learn to utilize these classes with each other to create 
 * 			a coherent Adventure type game. 
 * 
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 *
 */
import java.util.Scanner;

public class Adventure {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		Player Player = new Player();		//creates Player object of Player class
		Player.setXCoordinate(0);			//set coords to 0,0
		Player.setYCoordinate(0);	

		Map Map = new Map();				//creates Map object of Map class

		Lamp playerLamp;
		Key playerKey;
		Chest playerChest;

		boolean continueGame = true;		//boolean value, set to true so we can continue the game
		String userCommand = "";

		System.out.println("Welcome to UGA Adventures: Episode I");
		System.out.println("The Adventure of the Cave of Redundancy Adventure");
		System.out.println("By: Catherine Tan\n");

		//printing map's description
		System.out.println(Map.getRoom(Player.getX(), Player.getY()).getDescription());

		while (continueGame == true) {			//while loop to continue the game

			userCommand = keyboard.nextLine();		//accepts user input

			//GET LAMP COMMAND
			if (userCommand.equalsIgnoreCase("GET LAMP")) {
				if (Map.getRoom(Player.getX(),Player.getY()).getLamp() == null) {			//checks if lamp is null / aka no lamp present
					System.out.println("No lamp present");
				}
				else if (Map.getRoom(Player.getX(), Player.getY()).getLamp() != null) {		//checks if lamp is not null / aka lamp is present

					playerLamp = Map.getRoom(Player.getX(), Player.getY()).getLamp();		//playerLamp is now initialized to getLamp() 
					Player.setLamp(playerLamp);												//actually giving the player the lamp
					System.out.println("OK");												//print OK when successful

					Map.getRoom(Player.getX(), Player.getY()).clearLamp();					//removes the lamp from the room
				}
			}		//ends get lamp 

			//LIGHT LAMP COMMAND
			else if (userCommand.equalsIgnoreCase("LIGHT LAMP")) {
				if (Player.getLamp() == null) {									//checks if player has lamp or not
					System.out.println("You don't have the lamp to light");
				}
				else if (Player.getLamp() != null) {							//if player has the lamp, then they can light it

					Player.getLamp().setIsTheLampLit(true);					//lights the lamp, therefore making the lamp class boolean true
					System.out.println("OK");
				}
			}		//ends light lamp

			//NORTH COMMAND
			//If the current room (prior to the move) isDark(), AND the player doesn't have the lamp OR they have the lamp but the lamp is not lit
			else if (userCommand.equalsIgnoreCase("NORTH")) {
				if (Map.getRoom(Player.getX(), Player.getY()).isDark() == true && (Player.getLamp() == null || Player.getLamp().getIsTheLampLit() == false)) {

					continueGame = false;			//player gets eaten by grue so end game if condition is false ^
					System.out.println("You have stumbled into a passing grue, and have been eaten");

				}
				else if (Map.getRoom(Player.getX(), Player.getY()).canGoNorth() == true) {		//if the player is able to go north
					Player.setXCoordinate(Player.getX() - 1);			//if the condition is true, then move -1x (translates to 1 square North)

					//If the room (after the move) isDark() AND the player does not have the lamp OR the lamp is not lit,
					if (Map.getRoom(Player.getX(), Player.getY()).isDark() == true && (Player.getLamp() == null || Player.getLamp().getIsTheLampLit() == false)) {		//if the lamp is not lit and the room is dark

						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");

					}
					else {

						System.out.println(Map.getRoom(Player.getX(), Player.getY()).getDescription());			//prints the description of the room every time the player moves to a new room
					}
				}
				else if (Map.getRoom(Player.getX(), Player.getY()).canGoNorth() == false) {		//if the player is unable to go north
					System.out.println("Can't go that way");
				}
			}		//ends north

			//SOUTH COMMAND
			else if (userCommand.equalsIgnoreCase("SOUTH")) {
				//If the current room (prior to the move) isDark(), AND the player doesn't have the lamp OR they have the lamp but the lamp is not lit
				if (Map.getRoom(Player.getX(), Player.getY()).isDark() == true && (Player.getLamp() == null || Player.getLamp().getIsTheLampLit() == false)) {

					continueGame = false;			//player gets eaten by grue so end game if condition is false ^
					System.out.println("You have stumbled into a passing grue, and have been eaten");
				}
				else if (Map.getRoom(Player.getX(), Player.getY()).canGoSouth() == true) {		//if the player is able to go south

					Player.setXCoordinate(Player.getX() + 1);		//move +1x (translates to 1 square south)

					if (Map.getRoom(Player.getX(), Player.getY()).isDark() == true && (Player.getLamp() == null || Player.getLamp().getIsTheLampLit() == false)) {		//if the lamp is not lit, and the room is dark

						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					}
					else {

						System.out.println(Map.getRoom(Player.getX(), Player.getY()).getDescription());		//prints the description of the room every time the player moves to a new room

					}
				}
				else if (Map.getRoom(Player.getX(), Player.getY()).canGoSouth() == false) {		//if the player is unable to go south
					System.out.println("Can't go that way");

				}
			}		//ends south

			//EAST COMMAND
			else if (userCommand.equalsIgnoreCase("EAST")) {
				//If the current room (prior to the move) isDark(), AND the player doesn't have the lamp OR they have the lamp but the lamp is not lit
				if (Map.getRoom(Player.getX(), Player.getY()).isDark() == true && (Player.getLamp() == null || Player.getLamp().getIsTheLampLit() == false)) {

					continueGame = false;			//player gets eaten by grue so end game if condition is false ^
					System.out.println("You have stumbled into a passing grue, and have been eaten");
				}
				else if (Map.getRoom(Player.getX(), Player.getY()).canGoEast() == true) {		//if the player is able to go east

					Player.setYCoordinate(Player.getY() + 1);		//move +1y (translates to 1 square east)

					if (Map.getRoom(Player.getX(), Player.getY()).isDark() == true && (Player.getLamp() == null || Player.getLamp().getIsTheLampLit() == false)) {		//if the lamp is not lit, and the room is dark

						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					}
					else {

						System.out.println(Map.getRoom(Player.getX(), Player.getY()).getDescription());		//prints the description of the room every time the player moves to a new room

					}
				}
				else if (Map.getRoom(Player.getX(), Player.getY()).canGoEast() == false) {		//if the player is unable to go east
					System.out.println("Can't go that way");

				}
			}		//ends east

			//WEST COMMAND
			else if (userCommand.equalsIgnoreCase("WEST")) {
				//If the current room (prior to the move) isDark(), AND the player doesn't have the lamp OR they have the lamp but the lamp is not lit
				if (Map.getRoom(Player.getX(), Player.getY()).isDark() == true && (Player.getLamp() == null || Player.getLamp().getIsTheLampLit() == false)) {

					continueGame = false;			//player gets eaten by grue so end game if condition is false ^
					System.out.println("You have stumbled into a passing grue, and have been eaten");
				}
				else if (Map.getRoom(Player.getX(), Player.getY()).canGoWest() == true) {		//if the player is able to go west

					Player.setYCoordinate(Player.getY() - 1);		//move -1y (translates to 1 square west)

					if (Map.getRoom(Player.getX(), Player.getY()).isDark() == true && (Player.getLamp() == null || Player.getLamp().getIsTheLampLit() == false)) {		//if the lamp is not lit, and the room is dark

						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					}
					else {

						System.out.println(Map.getRoom(Player.getX(), Player.getY()).getDescription());		//prints the description of the room every time the player moves to a new room

					}
				}
				else if (Map.getRoom(Player.getX(), Player.getY()).canGoWest() == false) {		//if the player is unable to go west
					System.out.println("Can't go that way");

				}
			}

			//LOOK COMMAND
			else if (userCommand.equalsIgnoreCase("LOOK")) {
				if (Map.getRoom(Player.getX(), Player.getY()).isDark() == true && (Player.getLamp() == null || Player.getLamp().getIsTheLampLit() == false)) {		//if room is dark and player does not have lamp OR lamp isnt lit
					System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
				}
				else {
					System.out.println(Map.getRoom(Player.getX(), Player.getY()).getDescription());		//always print description of the room after user types look

					if (Map.getRoom(Player.getX(), Player.getY()).getLamp() != null) {					//if there is a lamp present in the room
						System.out.println("There is an old oil lamp that was made long ago here.");
					}
					else if (Map.getRoom(Player.getX(), Player.getY()).getKey() != null) {				//if there is a key present in the room
						System.out.println("You see the outline of a key on a dusty shelf that's covered in dust.");
					}
					else if (Map.getRoom(Player.getX(), Player.getY()).getChest() != null) {			//if there is a chest present in the room
						System.out.println("There is a large, wooden, massive, oaken chest here with the word “CHEST” carved into it");
					}

				}	//ends else condition 

				//this prints all the possible exits there are in each room
				System.out.print("Exits are: ");
				if (Map.getRoom(Player.getX(), Player.getY()).canGoNorth() == true) {		//if the user can go north, print north
					System.out.println("north");
				}
				if (Map.getRoom(Player.getX(), Player.getY()).canGoSouth() == true) {		//if the user can go south, print south
					System.out.println("south");
				}
				if (Map.getRoom(Player.getX(), Player.getY()).canGoEast() == true) {		//if the user can go east, print east
					System.out.println("east");
				}
				if (Map.getRoom(Player.getX(), Player.getY()).canGoWest() == true) {		//if the user can go west, print west
					System.out.println("west");
				}

			}		//ends look

			//GET KEY COMMAND
			else if (userCommand.equalsIgnoreCase("GET KEY")) {
				if (Map.getRoom(Player.getX(),Player.getY()).getKey() == null) {		//if the room does not have a key 
					System.out.println("No key present");
				}
				else if (Map.getRoom(Player.getX(),Player.getY()).getKey() != null) {		//if there is a key present in the room

					playerKey = Map.getRoom(Player.getX(), Player.getY()).getKey();			//give the player the key
					Player.setKey(playerKey);												//actually sets the playerKey into the Player's inventory
					System.out.println("OK");
				}

			}		//ends get key 

			//OPEN CHEST COMMAND
			else if (userCommand.equalsIgnoreCase("OPEN CHEST")) {
				if (Map.getRoom(Player.getX(), Player.getY()).getChest() == null) {			//if the room does not have a chest
					System.out.println("No chest present");
				}
				if (Map.getRoom(Player.getX(), Player.getY()).getChest() != null) {			//if there is a chest present in the room

					playerChest = Map.getRoom(Player.getX(), Player.getY()).getChest();		//set the Map's chest equal to playerChest so Player can interact with it

					if (playerChest.isLocked() == false) {									//if the chest is unlocked

						System.out.println(playerChest.getContents());						//print the chest's contents
						continueGame = false;												//end the game, set boolean to false
					}
					if (playerChest.isLocked() == true) {									//otherwise, if the chest is locked

						System.out.println("The chest is locked");

					}
				}	
			}		//ends open chest

			//UNLOCK CHEST
			else if (userCommand.equalsIgnoreCase("UNLOCK CHEST")) {
				if (Player.getKey() == null) {													//if the player does not have a key
					System.out.println("Need a key to do any unlocking!");
				}
				else if (Map.getRoom(Player.getX(), Player.getY()).getChest() == null) {		//if there is no chest present in the room
					System.out.println("No chest to unlock");
				}
				else if (Player.getKey() != null) {												//if the player possess a key
					playerChest = Map.getRoom(Player.getX(), Player.getY()).getChest();			//set the Map's chest equal to playerChest so Player can interact with it
					playerKey = Player.getKey();												//set key equal to playerKey so Player can interact with it
					playerKey.use(playerChest);													//use the key to unlock the chest

					System.out.println("OK");
				}
			}

			//if the user enters anything other than the commands listed, but still loop the code so it does not end abrubtly
			else {															
				System.out.println("I'm sorry I don't know how to do that.");
			}

		}		//ends while loop

		keyboard.close();
	}			//ends main method

}				//ends Adventure class
