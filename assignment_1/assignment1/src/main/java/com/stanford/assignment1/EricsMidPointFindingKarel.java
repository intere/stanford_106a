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
	public void run() {
		placeBeepersOnEnds();
		moveBeepersToCenter();
	}

	private void moveBeepersToCenter() {
		faceEast();
		while(!beepersPresent()) {
			move();
		}
		pickBeeper();
		move();
		if(!beepersPresent()) {
			putBeeper();
			walkToEnd();
		} else {
			faceWest();
			walkToEnd();
		}
		
		faceWest();
		if(!frontIsBlocked()) {
			while(!beepersPresent()) {
				move();
			}
			pickBeeper();
			move();
			if(!beepersPresent()) {
				putBeeper();
				walkToEnd();
				moveBeepersToCenter();
			} else {
				walkToEnd();
			}
		}
	}

	private void placeBeepersOnEnds() {
		putBeeper();
		walkToEnd();
		putBeeper();
		goHome();
	}

	private void goHome() {
		faceWest();
		walkToEnd();
	}
	
	private void faceEast() {
		while(!facingEast()) {
			turnLeft();
		}
	}

	private void faceWest() {
		while(!facingWest()) {
			turnLeft();
		}
	}

	private void walkToEnd() {
		while(frontIsClear()) {
			move();
		}
	}
}
