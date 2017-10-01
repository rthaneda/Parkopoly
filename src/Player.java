import java.util.ArrayList;

public abstract class Player {

	private String name;
	private double money = 15000;
	private int space = 0;
	private ArrayList<Property> properties;

	/*
	 * This is the non-default constructor for the Player class, it sets up a
	 * player with a variety of different aspects. Preconditions: None
	 * 
	 * @param name The name of the Player
	 * 
	 * @param money The amount of money the Player starts out with
	 * 
	 * @param space The space at which the Player starts out at
	 */
	public Player(String name, double money, int space) {
		this.name = name;
		this.money = money;
		this.space = space;
		properties = new ArrayList<Property>();
	}

	/*
	 * This returns the ArrayList containing the properties that the Player
	 * owns. Preconditions: None
	 * 
	 * @return An ArrayList containing this Player's properties
	 */
	public ArrayList<Property> getProperties() {
		return properties;
	}

	/*
	 * This allows a Property to be added to the ArrayList containg this
	 * Player's properties. Preconditions: None
	 * 
	 * @param p A Property to be added to this Player's ArrayList of properties
	 */
	public void addProperty(Property p) {
		properties.add(p);
		alphaSort();
	}

	/*
	 * This gets the amount of money that this Player has. Preconditions: None
	 * 
	 * @return The amount of money this Player has
	 */
	public double getMoney() {
		return money;
	}

	/*
	 * This function changes the amount of money this Player has by the input
	 * parameter representing money. Preconditions: None
	 * 
	 * @param x A double value representing the amount to change this Player's
	 * money by
	 */
	public void changeMoney(double x) {
		money += x;
	}

	/*
	 * This gets the name of this Player.Preconditions: None
	 * 
	 * @return The name of this Player
	 */
	public String getName() {
		return name;
	}

	/*
	 * This gets the cur5rent Space of this Player. Preconditions: None
	 * 
	 * @return The current space of this Player
	 */
	public int getSpace() {
		return space;
	}

	/*
	 * This allows the space of this Player to be set according to an input
	 * parameter. Preconditions: None
	 * 
	 * @param x The space to set this Player's space to
	 */
	public void setSpace(int x) {
		space = x;
	}

	/*
	 * This function sorts this Player's properties from the ArrayList
	 * containing this Player's properties in alphabetic order. Preconditions:
	 * None
	 */
	private void alphaSort() {
		int firstUnsortedIndex = 0;
		int smallestIndex = 0;
		for (int x = 0; x < properties.size() - 1; x++) {
			smallestIndex = firstUnsortedIndex;
			for (int k = firstUnsortedIndex; k < properties.size(); k++) {
				if (properties
						.get(k)
						.getName()
						.compareToIgnoreCase(
								properties.get(smallestIndex).getName()) > 0) {
					smallestIndex = k;
				}
			}

			Property tmp = properties.get(firstUnsortedIndex);
			properties.set(firstUnsortedIndex, properties.get(smallestIndex));
			properties.set(smallestIndex, tmp);
			firstUnsortedIndex++;
		}
	}

	/*
	 * This function is meant to give a specific response to another player when
	 * this player wins the game. Preconditions: None
	 * 
	 * @return A String containing a response to winning the game
	 */
	public abstract String makeFun();
}
