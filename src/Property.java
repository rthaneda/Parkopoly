public abstract class Property extends Space {

	private double price;
	private boolean isOwned = false;
	private double rentPrice;
	private String ownerSymbol;

	/*
	 * This is the non-default constructor for the Property class, it sets up a
	 * new Property with all aspects needed for the Property to be defined.
	 * Preconditions: None
	 * 
	 * @param name The name of the Property
	 * 
	 * @param price The price of the Property
	 */
	public Property(String name, double price) {
		super(name);
		if (price >= getMinimumPrice()) {
			this.price = price;
		} else {
			this.price = getMinimumPrice();
		}
		rentPrice = this.price / 10.0;
		ownerSymbol = "-";
	}

	/*
	 * This returns the price of this Property. Preconditions: None
	 * 
	 * @return A double representing the price of this Property
	 */
	public double getPrice() {
		return price;
	}

	/*
	 * This returns the cost of renting this Property for one turn.
	 * Preconditions: None
	 * 
	 * @return A String representing the cost of renting this Property for one
	 * turn
	 */
	public double getRentPrice() {
		return rentPrice;
	}

	/*
	 * This returns a boolean representing whether this Property is owned or
	 * not. Preconditions: None
	 * 
	 * @return A boolean value representing whether this Property is owned or
	 * not
	 */
	public boolean isOwned() {
		return isOwned;
	}

	/*
	 * This function returns a String representing a symbol of the player who
	 * owns this Property. Preconditions: None
	 * 
	 * @return A String representing a symbol of the player who owns this
	 * Property
	 */
	public String getOwnerSymbol() {
		return ownerSymbol;
	}

	/*
	 * This function inputs a String to represent the symbol of the player who
	 * owns this Property. Preconditions: None
	 * 
	 * @param String s The String to represent the symbol of the player who owns
	 * this Property
	 */
	public void setOwnerSymbol(String s) {
		ownerSymbol = s;
	}

	/*
	 * This function changes the ownership status of this Property to owned or
	 * not owned. Preconditions: None
	 */
	public void changeOwnershipStatus() {
		isOwned = !isOwned;
	}

	/*
	 * This function is meant to give the minimum allowed price for a child
	 * class of Property. Preconditions: None
	 * 
	 * @return A double value representing the minimum allowed price for a child
	 * class of Property
	 */
	public abstract double getMinimumPrice();
}
