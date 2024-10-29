/***
 * Solent application 
 * made by Gabin NIZAN
 * 29/10/224
 ***/ 
package tondeuse.kata.solent;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	
	/***
	 * Change angular position of the lawnmower by 90 degrees to the right or the left
	 * @param currentDirection 
	 * 		actual angular position of the lawnmower 
	 * @param rotation 
	 * 	 	instruction that determines if the lawnmower turn left or right
	 * @return
	 * 		new angular position of the lawnmower 
	 */
	private static char directionRotation(char currentDirection, char rotation) {
		char newDirection = 0;
		switch (currentDirection) {
		case 'N':
			if (rotation == 'D') {
				newDirection = 'E';
			}
			else if (rotation == 'G') {
				newDirection = 'W';
			}
			else {
				System.out.println("Wrong instruction");
			}
			break;
			
		case 'E':
			if (rotation == 'D') {
				newDirection = 'S';
			}
			else if (rotation == 'G') {
				newDirection = 'N';
			}
			else {
				System.out.println("Wrong instruction");
			}
			break;
			
		case 'S':
			if (rotation == 'D') {
				newDirection = 'W';
			}
			else if (rotation == 'G') {
				newDirection = 'E';
			}
			else {
				System.out.println("Wrong instruction");
			}
			break;
			
		case 'W':
			if (rotation == 'D') {
				newDirection = 'N';
			}
			else if (rotation == 'G') {
				newDirection = 'S';
			}
			else {
				System.out.println("Wrong instruction");
			}
			break;
		default:
			System.out.println("Wrong direction");
			break;
		}
		
		return newDirection;
	}

	/***
	 * According the the direction of the lawnmower, change the coordinate of the item
	 * @param direction 
	 * 		N S E or W 
	 * @param coordinate 
	 * 		the coordinate of X or Y
	 * @param maxX
	 * 		max coordinate for X in order to keep the lawnmower inside the garden
	 * @param maxY
	 * 		max coordinate for Y in order to keep the lawnmower inside the garden
	 * @return 
	 * 		the new coordinate
	 */
	private static Lawnmower newCoordinate(char direction, Lawnmower lawnmower, int maxX, int maxY) {
		switch (direction) {
		case 'N':
			if (lawnmower.getY() + 1 <= maxY) {
				lawnmower.setY(lawnmower.getY() +1);
			}
			break;
		case 'E':
			if (lawnmower.getX() + 1 <= maxX) {
				lawnmower.setX(lawnmower.getX() +1);
			}
			break;
		case 'S':
			if (lawnmower.getY() -1 >= 0) {
				lawnmower.setY(lawnmower.getY() -1);
			}
			break;
		case 'W':
			if (lawnmower.getX() -1 >= 0) {
				lawnmower.setX(lawnmower.getX()- 1);
			}
			break;
		default:
			System.out.println("Wrong direction");
			break;
		}
		
		return lawnmower;
	}
	
	
	/***
	 * Print function to see the final result
	 * 
	 * @param lawnmower1
	 * 		Result number 1 
	 * @param lawnmower2
	 * 		Result number2
	 */
	private static void printResult(Lawnmower lawnmower1, Lawnmower lawnmower2) {
		System.out.println(lawnmower1.getX());
		System.out.println(lawnmower1.getY());
		System.out.println(lawnmower1.getDirection());
		System.out.println();
		System.out.println(lawnmower2.getX());
		System.out.println(lawnmower2.getY());
		System.out.println(lawnmower2.getDirection());
		System.out.println();
		System.out.println();
	}

	
	
	public static void main(String[] args) throws FileNotFoundException {
		FileReader instructionFile = new FileReader("C:\\Users\\gabin\\Desktop\\test.txt");
		BufferedReader buffer = new BufferedReader(instructionFile);
		String instruction = "";
		try {
			instruction = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Lawnmower  lawnmower1 = new Lawnmower();
		Lawnmower  lawnmower2 = new Lawnmower ();
		List<Integer> indexSpace = new ArrayList<>();
		
		for (int i = 0; i < instruction.length(); i++) {
			if (instruction.charAt(i) == ' ') {
				indexSpace.add(i);
			}
		}

		int maxX = Integer.parseInt(instruction.substring(0, indexSpace.get(0)));
		int maxY = Integer.parseInt(instruction.substring(indexSpace.get(0) + 1, indexSpace.get(1)));
		
		lawnmower1.setX(Integer.parseInt(instruction.substring(indexSpace.get(1) + 1, indexSpace.get(2))));
		lawnmower1.setY(Integer.parseInt(instruction.substring(indexSpace.get(2) + 1, indexSpace.get(3))));
		char[] firstDirectionLawnmoer1 = instruction.substring(indexSpace.get(3) + 1, indexSpace.get(4)).toCharArray();
		lawnmower1.setDirection(firstDirectionLawnmoer1[0]);
		String lawnmower1Instruction = instruction.substring(indexSpace.get(4) + 1, indexSpace.get(5));
		
		lawnmower2.setX(Integer.parseInt(instruction.substring(indexSpace.get(5) + 1, indexSpace.get(6))));
		lawnmower2.setY(Integer.parseInt(instruction.substring(indexSpace.get(6) + 1, indexSpace.get(7))));
		char[] firstDirectionLawnmoer2 = instruction.substring(indexSpace.get(7) + 1, indexSpace.get(8)).toCharArray();
		lawnmower2.setDirection(firstDirectionLawnmoer2[0]);
		String lawnmower2Instruction = instruction.substring(indexSpace.get(8) + 1, instruction.length());
		
		for (int i = 0; i < lawnmower1Instruction.length(); i++) {
			if (lawnmower1Instruction.charAt(i) == 'D' || lawnmower1Instruction.charAt(i) == 'G') {
				lawnmower1.setDirection(directionRotation(lawnmower1.getDirection(), lawnmower1Instruction.charAt(i)));
			}
			else if (lawnmower1Instruction.charAt(i) == 'A') {
				newCoordinate(lawnmower1.getDirection(), lawnmower1, maxX, maxY);
			}
        }
		
		for (int i = 0; i < lawnmower2Instruction.length(); i++) {
			if (lawnmower2Instruction.charAt(i) == 'D' || lawnmower2Instruction.charAt(i) == 'G') {
				lawnmower2.setDirection(directionRotation(lawnmower2.getDirection(), lawnmower2Instruction.charAt(i)));
			}
			else if (lawnmower2Instruction.charAt(i) == 'A') {
				newCoordinate(lawnmower2.getDirection(), lawnmower2, maxX, maxY);
			}
        }
		printResult(lawnmower1, lawnmower2);
	}

}
