public class YellowProperty extends Property {

	private double minimumPrice = 800;

	/*
	 * This is the non-default constructor for the YellowProperty class, it sets
	 * up a new YellowProperty with all aspects needed for the YellowProperty to
	 * be defined. Preconditions: None
	 * 
	 * @param name The name of the YellowProperty
	 * 
	 * @param price The price of the YellowProperty
	 */
	public YellowProperty(String name, double price) {
		super(name, price);
	}

	/*
	 * This function is meant to give the minimum allowed price for a
	 * YellowProperty. Preconditions: None
	 * 
	 * @return A double value representing the minimum allowed price for a
	 * YellowProperty
	 * 
	 * @see Property#getMinimumPrice()
	 */
	@Override
	public double getMinimumPrice() {
		return minimumPrice;
	}

}
