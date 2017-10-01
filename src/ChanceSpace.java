public class ChanceSpace extends PassiveSpace {

	/*
	 * This is the non-default constructor for the ChanceSpace class, it creates
	 * a new ChanceSpace with a name. Preconditions: None
	 * 
	 * @param name The name of the chance space
	 */
	public ChanceSpace(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/*
	 * This function returns a random number between 0 and 9 inclusive.
	 * Preconditions: None
	 * 
	 * @return An int value between 0 and 9 inclusive
	 */
	public int chanceFunction() {
		return (int) (Math.random() * 10);
	}

}
