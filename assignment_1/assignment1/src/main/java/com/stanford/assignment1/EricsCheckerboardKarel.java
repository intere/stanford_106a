package com.stanford.assignment1;

import stanford.karel.SuperKarel;

@SuppressWarnings("serial")
public class EricsCheckerboardKarel extends SuperKarel {
	@Override
	public void run() {
		if(frontIsBlocked()) {
			turnLeft();
		}
		makeCheckers();
	}

	/**
	 * Will make checkers (always puts a beeper, and moves forward, until it hits a wall)
	 */
	private void makeCheckers() {
		if(frontIsClear()) {
			putBeeper();
		}
		while(frontIsClear()) {
			move();
			if(frontIsClear()) {
				move();
				putBeeper();
			}
		}
		
		if(beepersPresent()) {
			moveUpAndSkipBeeper();
		} else {
			moveUpAndPlaceBeeper();
		}		
	}

	/**
	 * Moves up one row, and places a beeper, immediately, then begins making the checkerboard (if the front is clear).
	 */
	private void moveUpAndPlaceBeeper() {
		if(facingEast()) {
			turnLeft();
			move();
			turnLeft();
		} else if(facingWest()) {
			turnRight();
			move();
			turnRight();
		}
		
		if(frontIsClear()) {
			makeCheckers();
		}
	}

	/**
	 * Moves up one row, skips placing a beeper, immediately, then begins making the checkerboard (if the front is clear).
	 */
	private void moveUpAndSkipBeeper() {
		if(facingEast()) {
			turnLeft();
			move();
			turnLeft();
		} else if(facingWest()) {
			turnRight();
			move();
			turnRight();
		}
		if(!frontIsClear()) {
			if(facingEast()) {
				turnLeft();
			} else if(facingWest()) {
				turnRight();
			}
		}
		if(frontIsClear()) {
			move();
		}
		if(frontIsClear()) {
			makeCheckers();
		}
	}
}
