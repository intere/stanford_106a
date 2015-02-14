package com.stanford.assignment1;

/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

@SuppressWarnings("serial")
public class CheckerboardKarel extends SuperKarel {

	public void run() {
		if(frontIsClear()) {
			makeCheckerBoard();
		} else {
			while(frontIsBlocked()) {
				turnLeft();
				makeCheckerBoard();
			}
		}
	}
	
	private void makeCheckerBoard() {
		placeAlternateBeepers();
		while (leftIsClear()) {
			repoToMoveWest();
			placeAlternateBeepers();
			if(rightIsClear()){
				repoToMoveEast();
				placeAlternateBeepers();
			} else {
				turnAround();
			}
		}
	}

	/*
	 * Precondition: Karel on west wall facing east
	 * Postcondition: Karel on east wall facing east
	 */
	private void placeAlternateBeepers(){
		putBeeper();
		while(frontIsClear()) {
			move();
			if(frontIsClear()) {
				move();
				putBeeper();
			}
		}
	}
	
	
	/*
	 * Precondition: Karel on east wall facing east
	 * Postcondition: Karel on east wall facing west and positioned north one row
	 */
	private void repoToMoveWest() {
		turnLeft();
		move();
		turnLeft();
	}
	/*
	 * Precondition: Karel on west wall facing west
	 * Postcondition: Karel on east wall facing east and postioned north one row
	 */
	private void repoToMoveEast() {
		turnRight();
		move();
		turnRight();
	}
	
}