public class OrangeProperty extends Property {

	private double minimumPrice = 600;

	/*
	 * This is the non-default constructor for the OrangeProperty class, it sets
	 * up a new OrangeProperty with all aspects needed for the OrangeProperty to
	 * be defined. Preconditions: None
	 * 
	 * @param name The name of the OrangeProperty
	 * 
	 * @param price The price of the OrangeProperty
	 */
	public OrangeProperty(String name, double price) {
		super(name, price);
	}

	/*
	 * This function is meant to give the minimum allowed price for a
	 * OrangeProperty. Preconditions: None
	 * 
	 * @return A double value representing the minimum allowed price for a
	 * OrangeProperty
	 * 
	 * @see Property#getMinimumPrice()
	 */
	@Override
	public double getMinimumPrice() {
		return minimumPrice;
	}

}
