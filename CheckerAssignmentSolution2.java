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
			fillRow();
			moveUpRightSide();
			fillRow();
			moveUpLeftSide();
		}
		
		if (beepersPresent()){
		pickBeeper();
		}
	}



	private void fillRow(){
		putBeeper();
		while (frontIsClear()){
			move();
			if (frontIsClear()){
				safeMove();
				putBeeper();
			}
		}
	}

	private void moveUpRightSide(){

		if (beepersPresent()){
			moveUpFromBlack();
		} else {
			moveUpFromWhite();
		}
	}

	private void moveUpLeftSide(){
		turnRight();
		if (frontIsClear()){
			safeMove();
			turnRight();
		}
	}

	private void moveUpFromBlack(){
		turnLeft();
		safeMove();
		if (frontIsClear()){
		turnLeft();
		safeMove();
		}
	}

	private void moveUpFromWhite(){
		turnLeft();
		if (frontIsClear()){
		safeMove();
		turnLeft();
		}
	}


	private void safeMove(){
		if (frontIsClear()){
			move();
		}
	}
}

