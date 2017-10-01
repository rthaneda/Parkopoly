public class TaxSpace extends PassiveSpace {

	private double taxAmount;

	/*
	 * This is the non-default constructor for the TaxSpace class, it creates a
	 * new TaxSpace with a name and the amount of the tax. Preconditions: None
	 * 
	 * @param name The name of the tax space
	 * 
	 * @param taxAmount The amount of money to pay for this tax
	 */
	public TaxSpace(String name, double taxAmount) {
		super(name);
		this.taxAmount = taxAmount;
	}

	/*
	 * This returns the amount of tax that this tax space implements.
	 * Preconditions: None
	 * 
	 * @return The amount of tax this tax space commands
	 */
	public double getTaxAmount() {
		return taxAmount;
	}

}
