package com.alesto.robot;

import com.alesto.robot.domain.Direction;

/**
 * Main Robot interface performing actions as specified in requirements
 * @author Alex
 *
 */
public interface Robot {
	
	/**
	 * Places the robot on the board. 
	 * If supplied coordinates fall outside of the board, the command will be ignored
	 * 
	 * @param x the x coordinate (between 0 and board width)
	 * @param y the y coordinate (between 0 and board height)
	 * @param direction - the {@link Direction} the robot is looking at (NORTH, EAST, SOUTH or WEST)
	 */
	public void place(int x, int y, Direction direction);
	
	/**
	 * Moves the robot one step forward in the facing direction. 
	 * If the new robot position falls outside the board, the command will be ignored
	 */
	public void move();
	
	/** 
	 * Rotates the robot 90 degrees anti-clockwise
	 */
	public void left();
	
	/** 
	 * Rotates the robot 90 degrees clockwise
	 */
	public void right();
	
	/**
	 * Produces a report of the robot's position and orientation
	 * @return a short report
	 */
	public String report();
	
}
