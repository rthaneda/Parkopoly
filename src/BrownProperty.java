public class BrownProperty extends Property {

	private double minimumPrice = 300;

	/*
	 * This is the non-default constructor for the BrownProperty class, it sets
	 * up a new BrownProperty with all aspects needed for the BrownProperty to
	 * be defined. Preconditions: None
	 * 
	 * @param name The name of the BrownProperty
	 * 
	 * @param price The price of the BrownProperty
	 */
	public BrownProperty(String name, double price) {
		super(name, price);
	}

	/*
	 * This function is meant to give the minimum allowed price for a
	 * BrownProperty. Preconditions: None
	 * 
	 * @return A double value representing the minimum allowed price for a
	 * BrownProperty
	 * 
	 * @see Property#getMinimumPrice()
	 */
	public double getMinimumPrice() {
		return minimumPrice;
	}
}
