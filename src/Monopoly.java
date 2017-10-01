import org.newdawn.slick.GameContainer;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Monopoly extends StateBasedGame {

	public static final int MAINMENUSTATE = 0;
	public static final int GAMEPLAYSTATE = 1;

	/*
	 * This function creates a new instance of a Monopoly game. Preconditions:
	 * None
	 */
	public Monopoly() {
		super("Parkopoly");
		this.addState(new MainMenu(MAINMENUSTATE));
		this.addState(new GamePlay(GAMEPLAYSTATE));
		this.enterState(MAINMENUSTATE);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Monopoly());
		app.setDisplayMode(966, 966, false);
		app.start();
	}

	/*
	 * This function initializes the game states. (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.StateBasedGame#initStatesList(org.newdawn.slick
	 * .GameContainer)
	 */
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MAINMENUSTATE).init(gc, this);
		this.getState(GAMEPLAYSTATE).init(gc, this);

	}

}
