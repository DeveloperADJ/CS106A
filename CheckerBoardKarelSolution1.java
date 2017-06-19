/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run(){
		if (frontIsBlocked()){
			turnLeft();
		}
		while (frontIsClear()){
		fillLane1();
		moveBack();
		moveUp();
		fillLane2();
		moveBack();
		moveUp();
		}
	}



	private void fillLane1(){
		safePutBeeper();
		while (frontIsClear()){
			safeMove();
			if (frontIsClear()){
				safeMove();
				safePutBeeper();
			}
		}
	}

	private void fillLane2(){
		while (frontIsClear()){
			
			safeMove();
			safePutBeeper();
			if (frontIsClear()){
				safeMove();
				
			}
		}
	}
	
	private void moveBack(){
		turnAround();
		while (frontIsClear()){
			safeMove();
		}
	}

	private void moveUp(){
		if (rightIsClear()){
		turnRight();
		safeMove();
		turnRight();
		} else {
			turnRight();
		}
	}

	//Extra Stuff

	private void safePutBeeper(){
		if (noBeepersPresent()){
			putBeeper();
		}
	}

	private void safeMove(){
		if (frontIsClear()){
			move();
		}
	}


}


