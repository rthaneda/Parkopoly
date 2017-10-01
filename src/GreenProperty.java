public class GreenProperty extends Property {

	private double minimumPrice = 900;

	/*
	 * This is the non-default constructor for the GreenProperty class, it sets
	 * up a new GreenProperty with all aspects needed for the GreenProperty to
	 * be defined. Preconditions: None
	 * 
	 * @param name The name of the GreenProperty
	 * 
	 * @param price The price of the GreenProperty
	 */
	public GreenProperty(String name, double price) {
		super(name, price);
	}

	/*
	 * This function is meant to give the minimum allowed price for a
	 * GreenProperty. Preconditions: None
	 * 
	 * @return A double value representing the minimum allowed price for a
	 * GreenProperty
	 * 
	 * @see Property#getMinimumPrice()
	 */
	@Override
	public double getMinimumPrice() {
		return minimumPrice;
	}

}
