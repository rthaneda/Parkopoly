public class BlueProperty extends Property {

	private double minimumPrice = 100;

	/*
	 * This is the non-default constructor for the BlueProperty class, it sets
	 * up a new BlueProperty with all aspects needed for the BlueProperty to be
	 * defined. Preconditions: None
	 * 
	 * @param name The name of the BlueProperty
	 * 
	 * @param price The price of the BlueProperty
	 */
	public BlueProperty(String name, double price) {
		super(name, price);
	}

	/*
	 * This function is meant to give the minimum allowed price for a
	 * BlueProperty. Preconditions: None
	 * 
	 * @return A double value representing the minimum allowed price for a
	 * BlueProperty
	 * 
	 * @see Property#getMinimumPrice()
	 */
	@Override
	public double getMinimumPrice() {
		return minimumPrice;
	}

}
