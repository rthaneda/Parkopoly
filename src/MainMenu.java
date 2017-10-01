import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState {

	private Image background = null;
	private Image play = null;
	private Image instructions = null;
	int stateID = 0;
	private File gameInstructions = null;
	private PrintWriter writer;
	Music openingMenuMusic = null;

	/*
	 * This creates a new Main Menu. Preconditions: None
	 */
	public MainMenu(int StateID) {
		stateID = StateID;
	}

	/*
	 * This function initializes the Main Menu. (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.GameState#init(org.newdawn.slick.GameContainer,
	 * org.newdawn.slick.state.StateBasedGame)
	 */
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		background = new Image("//Resources//ParkopolyBackground.jpg");
		play = new Image("//Resources//PLAY.jpg");
		instructions = new Image("//Resources//INSTRUCTIONS.jpg");
		if (System.getProperty("os.name").equals("Windows 7"))
			gameInstructions = new File("C://Users//"
					+ System.getProperty("user.name")
					+ "//Desktop//Instructions.txt");
		else
			gameInstructions = new File("C://Documents and Settings//"
					+ System.getProperty("user.name")
					+ "//Desktop//Instructions.txt");

		openingMenuMusic = new Music("//Resources//MonopolyMusic.wav");
		openingMenuMusic.loop();

	}

	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {

		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();

		if ((mouseX > 250 && mouseX < 700) && (mouseY > 10 && mouseY < 200)
				&& input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
			sb.enterState(Monopoly.GAMEPLAYSTATE);
		}

		if ((mouseX > 800 && mouseX < 1100) && (mouseY > 10 && mouseY < 900)
				&& input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				writer = new PrintWriter(gameInstructions);
				writer.println(">Welcome to Parkopoly!");
				writer.println(">This game is all about investing in the right properties to get money for yourself at your opponents' expense.");
				writer.println(">Every player will begin with $4000.");
				writer.println(">The Bank holds the deeds that will be purchased by the players. The Bank also pays salaries and bonuses. It sells properties and hands out the proper real estate when purchased by a player.");
				writer.println(">Each player's token will be on \"GO\", the value of the dice will determine how far your token will move.");
				writer.println(">Depending on the space your token reaches, you may be entitled to buy properties, or be obliged to pay rent, pay taxes, draw a Chance card, or Go To Detention");
				writer.println(">Each time a player's token lands on or passes over GO, whether by throwing the dice or drawing a card, the Bank pays that player a $200 salary.");
				writer.println(">Whenever you land on an unowned property you may buy that property from the Bank at its printed price. You receive the property and your player number will appear on the property space, showing ownership. If you do not wish to buy the property, it will remain unclaimed.");
				writer.println(">When you land on a property that is owned by another player, the owner collects rent from you in accordance with the list printed on its Title Deed card.");
				writer.println(">It is advantageous to hold all the Title Deed cards in a color-group because the owner may then charge double rent for properties in that color-group.");
				writer.println(">When you land on a chance space, a card will appear; follow the instructions.");
				writer.println(">You land in Detention when your token lands on the space marked \"Go to Detention\". When you are sent to Detention you cannot collect your $200 salary in that move since, regardless of where your token is on the board, you must move directly into Detention. Your turn ends when you are sent to Detention.");
				writer.println(">If you are not \"sent to detention\" but in the ordinary course of play land on that space, you are \"Just Visiting\", you incur no penalty, and you move ahead in the usual manner on your next turn. You still are able to collect rent on your properties because you are \"Just Visiting\".");
				writer.println(">Being sent to Detention causes the player to move back to that space, you do not remain there for more than one turn. Also, one must pay $50 to leave jail. This is not optional.");
				writer.println(">Even though you are in Detention, you may collect rents.");
				writer.println(">A player landing on a parking pass space does not receive any money, property or reward of any kind. This is just a \"free\" resting-place.");
				writer.println(">You are declared bankrupt if you do not have enough money left to either pay the Bank or another player.");
				writer.println(">A bankrupt player must immediately retire from the game.");
				writer.println(">The last player left in the game wins.");
				writer.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				System.err.println("Cannot Write File.");
			}

			try {
				new ProcessBuilder("notepad",
						gameInstructions.getAbsolutePath()).start();
			} catch (IOException e) {
				e.printStackTrace();
			}

			gameInstructions.deleteOnExit();

		}

		if (input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) {
			gc.exit();
		}

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		background.draw(0, 0);
		play.draw(275, 10);
		instructions.draw(840, 10);

	}

	public int getID() {

		return stateID;
	}

}
