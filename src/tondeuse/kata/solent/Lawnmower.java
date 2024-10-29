/***
 * Solent application 
 * made by Gabin NIZAN
 * 29/10/224
 ***/
package tondeuse.kata.solent;

public class Lawnmower  {
	private int X = 0;
	private int Y = 0;
	private char direction = 'N';

	public Lawnmower() {
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

}
