public class PinkProperty extends Property {

	private double minimumPrice = 500;

	/*
	 * This is the non-default constructor for the PinkProperty class, it sets
	 * up a new PinkProperty with all aspects needed for the PinkProperty to be
	 * defined. Preconditions: None
	 * 
	 * @param name The name of the PinkProperty
	 * 
	 * @param price The price of the PinkProperty
	 */
	public PinkProperty(String name, double price) {
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
