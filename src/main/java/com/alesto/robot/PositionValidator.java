package com.alesto.robot;

import com.alesto.robot.domain.Board;
import com.alesto.robot.domain.Position;

/**
 * A validator of the robot's position on the board
 * @author Alex
 *
 */
public interface PositionValidator {
	/**
	 * A utility method to check if a robot position is valid
	 * @param position - the position to be tested
	 * @return true if valid or false
	 */
	public static boolean isValid(Position position) {
		//TODO: For simplicity the logic is on the interface, but best to be implemented in a separate class
		if (position.x < Board.width && position.y < Board.height && position.x >=0 && position.y >=0) return true;
		return false;
	}
}
