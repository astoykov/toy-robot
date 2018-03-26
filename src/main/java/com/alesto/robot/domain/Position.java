package com.alesto.robot.domain;

/**
 * A domain class representing the robot's position
 * @author Alex
 *
 */
public class Position {
	
	//Coordinates
	public final int x,y;
	//Direction
	Direction direction;
	
	
	public Position(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	/**
	 * Performs a move of 1 step towards the facing direction
	 * @return the new position
	 */
	public Position move()
	{
		int newX = x + 1*direction.goX;
		int newY = y + 1*direction.goY;
		return new Position(newX,newY,this.direction);
	}
	
	/** 
	 * Returns a report of the current coordinates and orientation
	 * 
	 * @return a text report
	 */
	public String report()
	{
		return "" + x + "," + y + "," + direction;
	}
	
	/**
	 * Performs a left turn
	 * @return the new position
	 */
	public Position left()
	{
		return new Position(this.x,this.y,this.direction.left());
	}
	
	/**
	 * Performs a right turn
	 * @return the new position
	 */
	public Position right()
	{
		return new Position(this.x,this.y,this.direction.right());
	}
	
	
}
