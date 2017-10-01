public class TurquoiseProperty extends Property {

	private double minimumPrice = 400;

	/*
	 * This is the non-default constructor for the TurquoiseProperty class, it
	 * sets up a new TurquoiseProperty with all aspects needed for the
	 * TurquoiseProperty to be defined. Preconditions: None
	 * 
	 * @param name The name of the TurquoiseProperty
	 * 
	 * @param price The price of the TurquoiseProperty
	 */
	public TurquoiseProperty(String name, double price) {
		super(name, price);
	}

	/*
	 * This function is meant to give the minimum allowed price for a
	 * TurquoiseProperty. Preconditions: None
	 * 
	 * @return A double value representing the minimum allowed price for a
	 * TurquoiseProperty
	 * 
	 * @see Property#getMinimumPrice()
	 */
	@Override
	public double getMinimumPrice() {
		return minimumPrice;
	}

}
