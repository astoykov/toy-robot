package com.alesto.robot;

import java.util.Scanner;

import com.alesto.robot.domain.Direction;
import com.alesto.robot.domain.GoodRobot;

/**
 * A very simple console app to run command line interactive tests
 * 
 * @author Alex
 *
 */
public class RobotApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Robot App!");
		System.out.println("Simply type your command bellow");
		System.out.println("Type exit to close");
		
        Scanner in = new Scanner(System.in);

        Robot robot = new GoodRobot();
        
        while(in.hasNextLine())
        {
        	
        	String line = in.nextLine().trim();

        	if (line.toLowerCase().startsWith("place "))
        	{
        		String[] tokens = line.substring(line.indexOf(" ")+1).split(",");
                robot.place(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Direction.valueOf(tokens[2]));
                continue;
        	}
            switch (line.toLowerCase()) {
                case "left":
                    robot.left();
                    break;
                case "right":
                    robot.right();
                    break;
                case "move":
                    robot.move();
                    break;
                case "report":
                    System.out.println(robot.report());
                    break;
                case "exit":
                    System.out.println("Bye!");
                    in.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
            
        }


	}

}
