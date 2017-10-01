public class RedProperty extends Property {

	private double minimumPrice = 700;

	/*
	 * This is the non-default constructor for the RedProperty class, it sets up
	 * a new RedProperty with all aspects needed for the RedProperty to be
	 * defined. Preconditions: None
	 * 
	 * @param name The name of the RedProperty
	 * 
	 * @param price The price of the RedProperty
	 */
	public RedProperty(String name, double price) {
		super(name, price);
	}

	/*
	 * This function is meant to give the minimum allowed price for a
	 * RedProperty. Preconditions: None
	 * 
	 * @return A double value representing the minimum allowed price for a
	 * RedProperty
	 * 
	 * @see Property#getMinimumPrice()
	 */
	@Override
	public double getMinimumPrice() {
		return minimumPrice;
	}

}
