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
public class Player {

	private int xCoordinate = 0;
	private int yCoordinate = 0;
	private Lamp lamp;
	private Key key;
	
	public void setXCoordinate(int x) {
		xCoordinate = x;
	}
	
	public void setYCoordinate(int y) {
		yCoordinate = y;
	}
	
	public int getX() {
		return xCoordinate;
	}
	
	public int getY() {
		return yCoordinate;
	}
	
	public void setLamp(Lamp lamp) {
		this.lamp = lamp;
	}
	
	public void setKey(Key key) {
		this.key = key;
	}
	
	public Key getKey() {
		return key;
	}
	
	public Lamp getLamp() {
		return lamp;
	}
	
	


}
