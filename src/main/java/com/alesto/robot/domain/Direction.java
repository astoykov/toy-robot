package com.alesto.robot.domain;

/**
 * An Enum representing the direction (orientation) and its meaning in the 2d world
 * @author Alex
 *
 */
public enum Direction {
	
	NORTH(0,1), EAST(1,0), SOUTH(0,-1), WEST(-1,0);
	
	//No real need to make these private
	final int goX, goY;
	
	Direction(int goX, int goY)
	{
		this.goX = goX;
		this.goY = goY;
	}
	
	/**
	 * A helper method to turn left
	 * @return the new Direction
	 */
	public synchronized Direction left()
	{
	    int newGoX = this.goY*-1;
	    int newGoY = this.goX;
	    
		for (Direction newDir : Direction.values()) {

	        if (newDir.goX == newGoX && newDir.goY == newGoY) {

	            return newDir;
	        }
	    }
		return this;
	}
	
	/**
	 * A helper method to turn right
	 * @return the new Direction
	 */
	public synchronized Direction right()
	{
	    int newGoX = this.goY;
	    int newGoY = this.goX*-1;
	    
		for (Direction newDir : Direction.values()) {

	        if (newDir.goX == newGoX && newDir.goY == newGoY) {

	            return newDir;
	        }
	    }
		return this;
	}
}
