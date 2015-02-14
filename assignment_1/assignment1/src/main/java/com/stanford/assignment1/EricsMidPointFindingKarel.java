package com.stanford.assignment1;

/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.SuperKarel;

@SuppressWarnings("serial")
public class EricsMidPointFindingKarel extends SuperKarel {
	private int eastMoves;
	
	public void run() {
		moveToEastWall();
		moveToOpeningAndFaceEast();
		pickupPaperAndReturnHome();
		dropPaperInCenter();
	}

	private void dropPaperInCenter() {
		for(int i=0; i<eastMoves/2; i++) {
			move();
		}
		putBeeper();
		turnAround();
		for(int i=0; i<eastMoves/2; i++) {
			move();
		}
		turnAround();
	}

	private void pickupPaperAndReturnHome() {
		eastMoves = 0;
		move();
		pickBeeper();
		turnAround();
		while(frontIsClear()) {
			move();
			++eastMoves;
		}
		turnRight();
		while(frontIsClear()) {
			move();
		}
		turnRight();
	}

	private void moveToOpeningAndFaceEast() {
		turnRight();
		while(!foundDoor()) {
			move();
		}
	}
	
	private boolean foundDoor() {
		turnLeft();
		boolean foundDoor = frontIsClear();
		if(frontIsClear()) {
			return frontIsClear();
		}
		turnRight();
		return foundDoor;
	}

	private void moveToEastWall() {
		while(frontIsClear()) {
			move();
		}
	}
}
