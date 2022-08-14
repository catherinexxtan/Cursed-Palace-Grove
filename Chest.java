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
public class Chest {

	/*
	 * Instance variables go here, you're responsible for choosing
	 * which ones are needed and naming them
	 */

	boolean isTheChestLocked;
	String contentsOfTheChest;
	Key keyUsedToLockTheChest;
	

	/**
	 * This method is used by the Map class, you won't need to call it yourself
	 * It should result in this chest being locked and storing which key locked it.
	 */
	public void lock(Key theKey) {		//does not return anything, isLocked = true
		
		keyUsedToLockTheChest = theKey;
		isTheChestLocked = true;
	
	}
	
	/**
	 * If theKey is the same key that was used to lock this chest, then
	 * the chest is unlocked.  Otherwise this method does nothing.
	 */
	public void unLock(Key theKey) {	//does not return anything, isLocked = false
		
		if (this.keyUsedToLockTheChest == theKey) {
			isTheChestLocked = false;
		}
		
	}
	
	/**
	 * Should return true if the chest is locked, false otherwise
	 */
	public boolean isLocked() {
		if (isTheChestLocked == true) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * Return a string describing the contents of the chest.
	 */
	public String getContents() {
		
		return contentsOfTheChest;
		
	}
	
	/**
	 * Set the contents of the chest to this string.  You should not need to call
	 * this method in your program (though you have to implement it anyway).
	 */
	public void setContents(String contents) {
		
		contentsOfTheChest = contents;
		
	}
	
	
	
}
