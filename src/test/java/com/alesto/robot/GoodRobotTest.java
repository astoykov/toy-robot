package com.alesto.robot;

import static org.junit.Assert.*;
import static com.alesto.robot.domain.Direction.*;

import org.junit.Test;

import com.alesto.robot.domain.GoodRobot;

/**
 * Main unit test
 * TODO: For simplicity, this is the main and only test suite.
 *  It covers deep tests including domain classes, but those should be normally be tested in a separate jUnit class.
 *  
 * @author Alex
 *
 */
public class GoodRobotTest {
	
	private Robot robot = new GoodRobot();
	
	@Test
	public void testTurnLeft() {
		robot = new GoodRobot();
		robot.place(0,0,NORTH);
		robot.left();
		assertEquals("Incorrect position", "0,0,WEST", robot.report());
		robot.left();
		assertEquals("Incorrect position", "0,0,SOUTH", robot.report());
		robot.left();
		assertEquals("Incorrect position", "0,0,EAST", robot.report());
		robot.left();
		assertEquals("Incorrect position", "0,0,NORTH", robot.report());
	
	}

	
	@Test
	public void testTurnRight() {
		robot = new GoodRobot();
		robot.place(0,0,NORTH);
		robot.right();
		assertEquals("Incorrect position", "0,0,EAST", robot.report());
		robot.right();
		assertEquals("Incorrect position", "0,0,SOUTH", robot.report());
		robot.right();
		assertEquals("Incorrect position", "0,0,WEST", robot.report());
		robot.right();
		assertEquals("Incorrect position", "0,0,NORTH", robot.report());
	
	}
	
	@Test
	public void testMainScenario() {
		robot = new GoodRobot();
		robot.place(0,0,NORTH);
		robot.move();
		assertEquals("Incorrect position", "0,1,NORTH", robot.report());
		robot.place(0,0,NORTH);
		robot.left();
		assertEquals("Incorrect position", "0,0,WEST", robot.report());
		robot.place(1,2,EAST);
		robot.move();
		robot.move();
		robot.left();
		robot.move();
		assertEquals("Incorrect position", "3,3,NORTH", robot.report());
	
	}

	@Test
	public void testInvalidPlacing() {
		robot = new GoodRobot();
		robot.place(-1,0,NORTH);
		assertEquals("Incorrect position", "Robot not placed yet", robot.report());
		robot.place(7,0,NORTH);
		assertEquals("Incorrect position", "Robot not placed yet", robot.report());
	
	}
	
	
	@Test
	public void testCommandsWithoutPlacing() {
		robot = new GoodRobot();
		robot.move();
		robot.left();
		robot.right();
		assertEquals("Incorrect position", "Robot not placed yet", robot.report());
		robot.place(3,3,NORTH);
		robot.move();
		assertEquals("Incorrect position", "3,4,NORTH", robot.report());
	
	}
	
	@Test
	public void testGoingOutsideOfTheBoard() {
		robot = new GoodRobot();
		robot.place(0,4,NORTH);
		robot.move();
		robot.move();
		robot.move();
		assertEquals("Incorrect position", "0,4,NORTH", robot.report());
	
	}
}
