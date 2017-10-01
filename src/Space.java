public abstract class Space {

	private String name;

	/*
	 * This is the non-default constructor for the Space class, it creates a new
	 * Space with a name. Preconditions: None
	 * 
	 * @param name The name of the space
	 */
	public Space(String name) {
		this.name = name;
	}

	/*
	 * This function returns the name of this instantiated Space. Preconditions:
	 * None
	 * 
	 * @return A String representing the name of this Space
	 */
	public String getName() {
		return name;
	}

}
