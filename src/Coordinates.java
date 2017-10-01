public class Coordinates {

	private int x;
	private int y;

	/*
	 * This is the non-default constructor for the Coordinates class, it creates
	 * a new Coordinates object with a given x and y location. Preconditions:
	 * None
	 * 
	 * @param inputX An integer representing the x value of the coordinate
	 * 
	 * @param inputY An integer representing the y value of the coordinate
	 */
	public Coordinates(int inputX, int intputY) {
		this.x = inputX;
		this.y = intputY;
	}

	/*
	 * This function returns the x value of this coordinate. Preconditions: None
	 * 
	 * @return The x value of the coordinate
	 */
	public int getX() {
		return x;
	}

	/*
	 * This function returns the y value of this coordinate. Preconditions: None
	 * 
	 * @return The y value of the coordinate
	 */
	public int getY() {
		return y;
	}

}
