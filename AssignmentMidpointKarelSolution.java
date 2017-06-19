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

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public void run(){
		fillArea();
		while (beepersPresent()){
			moveToEndOfBeeperTrail();
		}
		turnAround();
		move();

	}
	
	//Comment:
	//Pre-condition: Condition that must be true before method is executed.
	//Post-condition: Condition that must be true after method is executed.
	//Post-conditions should always be met.
	private void fillArea(){
		while (frontIsClear()){
			move();
			if (frontIsClear()){
				putBeeper();
			}
		}
		turnAround();
		move();
	}

	private void moveToEndOfBeeperTrail(){
		move();
		if (beepersPresent()){
			while (beepersPresent()){
				move();
			}
			pickLastBeeper();
		}

	}

	private void pickLastBeeper(){
		turnAround();
		move();
		safePickBeeper();
		move();
	}

	private void safePickBeeper(){
		if (beepersPresent()){
			pickBeeper();
		}
	}

}

