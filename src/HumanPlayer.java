public class HumanPlayer extends Player {

	/*
	 * This is the non-default constructor for the HumanPlayer class, it sets up
	 * a human player with all characteristics needed. Preconditions: None
	 * 
	 * @param name The name of the human player
	 * 
	 * @param money The amount of money this human player starts out with
	 * 
	 * @param space The space this human player starts with
	 */
	public HumanPlayer(String name, double money, int space) {
		super(name, money, space);
	}

	/*
	 * This function is meant to give a specific response to another player when
	 * this player wins the game. Preconditions: None
	 * 
	 * @return A String containing a response to winning the game
	 * 
	 * @see Player#makeFun()
	 */
	@Override
	public String makeFun() {
		return getName() + ", proceed to make fun of your opponent for losing!";
	}

}
