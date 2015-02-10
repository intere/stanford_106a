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

package com.stanford.106a;

import stanford.karel.*;


public class MidpointFindingKarel extends SuperKarel {

  public void run() {
    putDownBeepers();
    backToStart();
    stackBeepersAtEnd();
    moveToMiddle();
  }
  /*
   * Precondition: Karel is on west wall facing east
   * Postcondition: Karel places a beeper on every corner
   * 				to the east wall and finishes facing east.
   */
  private void putDownBeepers() {
    while(frontIsClear()) {
      putBeeper();
      move();
    }
    putBeeper();
  }
  /*
   * Precondition: Karel is at the east wall of a row facing east.
   * Postcondition: Karel is at the west wall facing east
   */
  private void backToStart() {
    turnAround();
    while(frontIsClear()) {
      move();
    }
    turnAround();
  }
  /*
   * Precondition: Karel is at the west wall facing east
   * Postcondition: Karel is at the east wall facing east having
   * 				picked up all beepers
   */
  private void pickUpBeepers() {
    while(frontIsClear()) {
      pickBeeper();
      backToStart();
    }
    pickBeeper();
  }
  /*
   * Precondition: Karel is at the west wall facing east with
   * 				bag of beepers
   * Postcondition: Karel is halfway across the row facing east
   */
  private void moveToMiddle() {
    while(beepersInBag()) {
      putBeeper();
      putBeeper();
      move();
    }
  }

  private void stackBeepersAtEnd() {
    pickBeeper();
    moveToWall();
    putBeeper();
    backToStart();
    moveToBeeper();
  }

  private void moveToBeeper() {
    while(noBeepersPresent()) {
      move();
    }
  }

  private void moveToWall() {
    while(frontIsClear()) {
      move();
    }
  }
}
