public class Railroad extends Property {

	private double minimumPrice = 500;

	/*
	 * This is the non-default constructor for the Railroad class, it sets up a
	 * new Railroad with all aspects needed for the Railroad to be defined.
	 * Preconditions: None
	 * 
	 * @param name The name of the Railroad
	 * 
	 * @param price The price of the Railroad
	 */
	public Railroad(String name, double price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}

	/*
	 * This function is meant to give the minimum allowed price for a Railroad.
	 * Preconditions: None
	 * 
	 * @return A double value representing the minimum allowed price for a
	 * Railroad
	 * 
	 * @see Property#getMinimumPrice()
	 */
	@Override
	public double getMinimumPrice() {
		return minimumPrice;
	}

}
