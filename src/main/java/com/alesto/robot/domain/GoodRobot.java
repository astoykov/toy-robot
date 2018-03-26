package com.alesto.robot.domain;

import java.util.Optional;

import com.alesto.robot.PositionValidator;
import com.alesto.robot.Robot;

public class GoodRobot implements Robot {

	/**
	 * Holds the robot position. It is empty until initialised by calling Robot#place()
	 */
	private Optional<Position> position = Optional.empty();
	
	/**
	 * @see Robot#move()
	 */
	public void move()
	{
		position.map(pos -> pos.move()).filter(pos -> PositionValidator.isValid(pos)).ifPresent(pos -> this.position = Optional.of(pos));
	}
	
	/**
	 * @see Robot#place()
	 */
	public void place(int x, int y, Direction pos)
	{
		this.position = Optional.of(new Position(x,y,pos)).filter(posit -> PositionValidator.isValid(posit));
	}
	
	/**
	 * @see Robot#report()
	 */
	public String report()
	{
		if(position.isPresent())
			return position.get().report();
		return "Robot not placed yet";
	}
	
	/**
	 * @see Robot#left()
	 */
	public void left()
	{
		position = position.map(pos -> pos.left());
	}
	
	/**
	 * @see Robot#right()
	 */
	public void right()
	{
		position = position.map(pos -> pos.right());
	}
	
}
