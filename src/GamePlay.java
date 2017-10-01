import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.gui.TextField;
import java.io.*;
import java.util.ArrayList;

public class GamePlay extends BasicGameState {
	Image land = null;
	Image player1 = null;
	Image player2 = null;
	Image dice1 = null;
	Image dice2 = null;
	Image dice3 = null;
	Image dice4 = null;
	Image dice5 = null;
	Image dice6 = null;
	private int diceRoll;
	boolean diceDisplay;
	int stateID = -1;
	Font font;
	TextField textField;
	Graphics k = new Graphics();
	public final Coordinates[] player1Positions = { new Coordinates(1, 870),
			new Coordinates(1, 765), new Coordinates(1, 690),
			new Coordinates(1, 615), new Coordinates(1, 540),
			new Coordinates(1, 465), new Coordinates(1, 390),
			new Coordinates(1, 315), new Coordinates(1, 240),
			new Coordinates(1, 165), new Coordinates(90, 1),
			new Coordinates(165, 1), new Coordinates(240, 1),
			new Coordinates(315, 1), new Coordinates(390, 1),
			new Coordinates(465, 1), new Coordinates(540, 1),
			new Coordinates(615, 1), new Coordinates(690, 1),
			new Coordinates(765, 1), new Coordinates(870, 1),
			new Coordinates(910, 165), new Coordinates(910, 240),
			new Coordinates(910, 315), new Coordinates(910, 390),
			new Coordinates(910, 465), new Coordinates(910, 540),
			new Coordinates(910, 615), new Coordinates(910, 690),
			new Coordinates(910, 765), new Coordinates(870, 930),
			new Coordinates(765, 930), new Coordinates(690, 930),
			new Coordinates(615, 930), new Coordinates(540, 930),
			new Coordinates(465, 930), new Coordinates(390, 930),
			new Coordinates(315, 930), new Coordinates(240, 930),
			new Coordinates(165, 930) };

	public final Coordinates[] player2Positions = { new Coordinates(65, 865),
			new Coordinates(65, 765), new Coordinates(65, 690),
			new Coordinates(65, 615), new Coordinates(65, 540),
			new Coordinates(65, 465), new Coordinates(65, 390),
			new Coordinates(65, 315), new Coordinates(65, 240),
			new Coordinates(65, 165), new Coordinates(1, 90),
			new Coordinates(165, 65), new Coordinates(240, 65),
			new Coordinates(315, 65), new Coordinates(390, 65),
			new Coordinates(465, 65), new Coordinates(540, 65),
			new Coordinates(615, 65), new Coordinates(690, 65),
			new Coordinates(765, 65), new Coordinates(850, 65),
			new Coordinates(850, 165), new Coordinates(850, 240),
			new Coordinates(850, 315), new Coordinates(850, 390),
			new Coordinates(850, 465), new Coordinates(850, 540),
			new Coordinates(850, 615), new Coordinates(850, 690),
			new Coordinates(850, 765), new Coordinates(850, 865),
			new Coordinates(765, 865), new Coordinates(690, 865),
			new Coordinates(615, 865), new Coordinates(540, 865),
			new Coordinates(465, 865), new Coordinates(390, 865),
			new Coordinates(315, 865), new Coordinates(240, 865),
			new Coordinates(165, 865) };

	Player playerOne = new HumanPlayer("Player 1", 4000, 0);
	Player playerTwo = new HumanPlayer("Player 2", 4000, 0);

	float p1x = player1Positions[playerOne.getSpace()].getX();
	float p1y = player1Positions[playerOne.getSpace()].getY();
	float p2x = player2Positions[playerTwo.getSpace()].getX();
	float p2y = player2Positions[playerTwo.getSpace()].getY();

	boolean playerOneBuying = false;
	boolean playerTwoBuying = false;

	boolean moving = true;

	boolean gameOver = false;

	int p1k = 1;
	int p2k = 1;

	Space zero = new PassiveSpace("Go");
	Space one = new BrownProperty("Plymouth Parking Lot", 300);
	Space two = new ChanceSpace("Chance Space 1");
	Space three = new BrownProperty("Canton Parking Lot", 350);
	Space four = new TaxSpace("Income Tax", 100);
	Space five = new Railroad("Plymouth-Salem Path", 500);
	Space six = new TurquoiseProperty("Salem Parking Lot", 400);
	Space seven = new ChanceSpace("Chance Space 2");
	Space eight = new TurquoiseProperty("Plymouth Cafeteria", 400);
	Space nine = new TurquoiseProperty("Canton Cafeteria", 450);
	Space ten = new PassiveSpace("Detention");
	Space eleven = new PinkProperty("Salem Cafeteria", 550);
	Space twelve = new PassiveSpace("Parking Pass");
	Space thirteen = new PinkProperty("JV Track", 500);
	Space fourteen = new PinkProperty("Plymouth Indoor Track", 500);
	Space fifteen = new ChanceSpace("Chance Space 3");
	Space sixteen = new OrangeProperty("Salem Soccer Fields", 600);
	Space seventeen = new TaxSpace("Property Tax", 200);
	Space eighteen = new OrangeProperty("Varsity Soccer Field", 600);
	Space nineteen = new OrangeProperty("Varsity Track", 600);
	Space twenty = new PassiveSpace("Parking Pass");
	Space twentyone = new RedProperty("Salem Upper Commons", 750);
	Space twentytwo = new ChanceSpace("Chance Space 4");
	Space twentythree = new RedProperty("Radio Station", 700);
	Space twentyfour = new RedProperty("Phase 3", 740);
	Space twentyfive = new Railroad("Plymouth-Canton Path", 500);
	Space twentysix = new YellowProperty("Tennis Courts", 850);
	Space twentyseven = new YellowProperty("Salem Auditorium", 840);
	Space twentyeight = new ChanceSpace("Chance Space 5");
	Space twentynine = new YellowProperty("Canton Little Theater", 845);
	Space thirty = new PassiveSpace("Send To Detention");
	Space thirtyone = new GreenProperty("The Den", 900);
	Space thirtytwo = new GreenProperty("The Chief Connection", 950);
	Space thirtythree = new PassiveSpace("Parking Pass");
	Space thirtyfour = new GreenProperty("The Rock Shop", 975);
	Space thirtyfive = new Railroad("Canton-Salem Path", 550);
	Space thirtysix = new ChanceSpace("Chance Space 6");
	Space thirtyseven = new BlueProperty("The Rock", 1050);
	Space thirtyeight = new TaxSpace("Super Tax", 500);
	Space thirtynine = new BlueProperty("The Pit", 1040);

	int firstTurn = 1;

	private Space[] spaces = { zero, one, two, three, four, five, six, seven,
			eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen,
			sixteen, seventeen, eighteen, nineteen, twenty, twentyone,
			twentytwo, twentythree, twentyfour, twentyfive, twentysix,
			twentyseven, twentyeight, twentynine, thirty, thirtyone, thirtytwo,
			thirtythree, thirtyfour, thirtyfive, thirtysix, thirtyseven,
			thirtyeight, thirtynine };

	int playerTurn = 0;

	public String[] chanceOptions = {
			"Your phone went off in class, pay $100.",
			"You were student of the month, collect $100.",
			"You were late to class, pay $50.",
			"You helped somebody with their homework. collect $50.",
			"You didn't do your homework, pay $25.",
			"You made varsity in your sport, collect $100.",
			"You were eating in the library, pay $50.",
			"You fell in the snow, pay $50.",
			"You got a scholarship, collect collect $500.",
			"You graduated, collect $1000." };

	public double[] chanceValues = { -100, 100, -50, 50, -25, 100, -50, -50,
			500, 1000 };

	int x = 1;

	/*
	 * This function creates a new instance of GamePlay. Preconditions: None
	 */
	public GamePlay(int StateID) {
		stateID = StateID;
	}

	/*
	 * This function initializes the variables that are needed during gameplay.
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.GameState#init(org.newdawn.slick.GameContainer,
	 * org.newdawn.slick.state.StateBasedGame)
	 */
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		font = new UnicodeFont(new java.awt.Font(java.awt.Font.SANS_SERIF,
				java.awt.Font.ITALIC, 26));
		textField = new TextField(gc, gc.getDefaultFont(), 150, 542, 654, 268);
		land = new Image("//Resources//monopoly.png");
		player1 = new Image("//Resources//monopoly car.png");
		player2 = new Image("//Resources//monopolyhelicopter.png");
		textField.setText("Press right to start");
		dice1 = new Image("//Resources//1.png");
		dice2 = new Image("//Resources//2.png");
		dice3 = new Image("//Resources//3.png");
		dice4 = new Image("//Resources//4.png");
		dice5 = new Image("//Resources//5.png");
		dice6 = new Image("//Resources//6.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		textField.render(gc, g);
		g.drawString("Player 1: Car", 175, 180);
		g.drawString("Number of Properties: "
				+ playerOne.getProperties().size(), 175, 210);
		g.drawString("Amount of Money: " + playerOne.getMoney(), 175, 240);
		g.drawString("Space: " + playerOne.getSpace(), 175, 270);
		g.drawString("P1K: " + p1k, 175, 300);
		g.drawString("Player Turn: " + playerTurn, 175, 3330);

		g.drawString("Player 2: Helicopter", 520, 180);
		g.drawString("Number of Properties: "
				+ playerTwo.getProperties().size(), 520, 210);
		g.drawString("Amount of Money: " + playerTwo.getMoney(), 520, 240);
		g.drawString("Space: " + playerTwo.getSpace(), 520, 270);
		g.drawString("P2K: " + p2k, 520, 300);

		g.drawString(((Property) spaces[1]).getOwnerSymbol(), 124, 772);
		g.drawString(((Property) spaces[3]).getOwnerSymbol(), 124, 626);
		g.drawString(((Property) spaces[5]).getOwnerSymbol(), 130, 476);
		g.drawString(((Property) spaces[6]).getOwnerSymbol(), 124, 398);
		g.drawString(((Property) spaces[8]).getOwnerSymbol(), 124, 250);
		g.drawString(((Property) spaces[9]).getOwnerSymbol(), 124, 175);

		g.drawString(((Property) spaces[11]).getOwnerSymbol(), 177, 124);
		g.drawString(((Property) spaces[13]).getOwnerSymbol(), 327, 124);
		g.drawString(((Property) spaces[14]).getOwnerSymbol(), 403, 124);
		g.drawString(((Property) spaces[16]).getOwnerSymbol(), 553, 124);
		g.drawString(((Property) spaces[18]).getOwnerSymbol(), 703, 124);
		g.drawString(((Property) spaces[19]).getOwnerSymbol(), 779, 124);

		g.drawString(((Property) spaces[21]).getOwnerSymbol(), 830, 174);
		g.drawString(((Property) spaces[23]).getOwnerSymbol(), 830, 326);
		g.drawString(((Property) spaces[24]).getOwnerSymbol(), 830, 398);
		g.drawString(((Property) spaces[25]).getOwnerSymbol(), 830, 478);
		g.drawString(((Property) spaces[26]).getOwnerSymbol(), 830, 552);
		g.drawString(((Property) spaces[27]).getOwnerSymbol(), 830, 625);
		g.drawString(((Property) spaces[29]).getOwnerSymbol(), 830, 778);

		g.drawString(((Property) spaces[31]).getOwnerSymbol(), 777, 828);
		g.drawString(((Property) spaces[32]).getOwnerSymbol(), 701, 828);
		g.drawString(((Property) spaces[34]).getOwnerSymbol(), 554, 828);
		g.drawString(((Property) spaces[35]).getOwnerSymbol(), 477, 828);
		g.drawString(((Property) spaces[37]).getOwnerSymbol(), 328, 828);
		g.drawString(((Property) spaces[39]).getOwnerSymbol(), 177, 828);

		land.draw(0, 0);
		player1.draw(p1x, p1y, .3f);
		player2.draw(p2x, p2y, .25f);
		if (diceDisplay == true) {
			switch (diceRoll) {
			case 2:
				dice1.draw(500, 350, .5f);
				dice1.draw(400, 350, .5f);
				break;
			case 3:
				dice2.draw(500, 350, .5f);
				dice1.draw(400, 350, .5f);
				break;
			case 4:
				dice2.draw(500, 350, .5f);
				dice2.draw(400, 350, .5f);
				break;
			case 5:
				dice3.draw(500, 350, .5f);
				dice2.draw(400, 350, .5f);
				break;
			case 6:
				dice3.draw(500, 350, .5f);
				dice3.draw(400, 350, .5f);
				break;
			case 7:
				dice1.draw(500, 350, .5f);
				dice6.draw(400, 350, .5f);
				break;
			case 8:
				dice4.draw(500, 350, .5f);
				dice4.draw(400, 350, .5f);
				break;
			case 9:
				dice3.draw(500, 350, .5f);
				dice6.draw(400, 350, .5f);
				break;
			case 10:
				dice5.draw(500, 350, .5f);
				dice5.draw(400, 350, .5f);
				break;
			case 11:
				dice5.draw(500, 350, .5f);
				dice6.draw(400, 350, .5f);
				break;
			case 12:
				dice6.draw(500, 350, .5f);
				dice6.draw(400, 350, .5f);
				break;
			}

		}

	}

	/*
	 * This function updates the game continuously and is responsible for game
	 * logic. (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer,
	 * org.newdawn.slick.state.StateBasedGame, int)
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput(); // Input controller obtained from
										// GameContainer

		if (firstTurn == 1 && input.isKeyDown(Input.KEY_RIGHT)) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			firstTurn = 2;
			playerTurn = 1;
		}

		if (playerTurn == 1) {
			if (p1k == 1) {
				if (playerOne.getMoney() < 0) {
					gameOver = true;
					p1k = 10;
				}
				diceRoll = rollDice();
				int oldSpace = playerOne.getSpace();
				int newSpace = (oldSpace + diceRoll) % 40;
				diceDisplay = true;
				playerOne.setSpace(newSpace);
				p1x = player1Positions[playerOne.getSpace()].getX();
				p1y = player1Positions[playerOne.getSpace()].getY();

				String displayedText = playerOne.getName() + ", you  rolled "
						+ diceRoll + " and moved from space " + oldSpace
						+ " to space " + newSpace + ".";

				textField.setText(displayedText);

				if (newSpace < oldSpace) {
					playerOne.changeMoney(200);
				}

				displayedText += "\nThis space is: "
						+ spaces[newSpace].getName();

				textField.setText(displayedText);

				boolean iOwn = false;

				for (Property k : playerOne.getProperties()) {
					if (spaces[newSpace].getName().equals(k.getName())) {
						iOwn = true;
					}
				}

				boolean theyOwn = false;

				for (Property k : playerTwo.getProperties()) {
					if (spaces[newSpace].getName().equals(k.getName())) {
						theyOwn = true;
					}
				}

				if ((spaces[newSpace] instanceof Property || spaces[newSpace] instanceof Railroad)
						&& ((Property) spaces[newSpace]).isOwned() == false
						&& playerOne.getMoney() > ((Property) spaces[newSpace])
								.getPrice()
						&& iOwn == false
						&& theyOwn == false) {
					displayedText += "\nWould you like to buy this property? Press up to buy,\npress left to decline. The cost of this property is $"
							+ ((Property) spaces[newSpace]).getPrice();
					p1k = 2;
				}

				if ((spaces[newSpace] instanceof Property || spaces[newSpace] instanceof Railroad)
						&& ((Property) spaces[newSpace]).isOwned() == false
						&& playerOne.getMoney() <= ((Property) spaces[newSpace])
								.getPrice()
						&& iOwn == false
						&& theyOwn == false) {
					displayedText += "\nYou cannot afford this property, press left to end your turn.";
					p1k = 3;
				}

				if ((spaces[newSpace] instanceof Property || spaces[newSpace] instanceof Railroad)
						&& iOwn == true) {
					displayedText += "\nYou already own this property, press the left key to end your turn.";
					p1k = 3;
				}

				if ((spaces[newSpace] instanceof Property || spaces[newSpace] instanceof Railroad)
						&& theyOwn == true) {
					double money = playerOne.getMoney();
					if (spaces[newSpace] instanceof BrownProperty) {
						int counter = 0;
						for (Property k : playerTwo.getProperties()) {
							if (k instanceof BrownProperty) {
								counter++;
							}
						}
						if (counter == 2) {
							displayedText += "\n"
									+ playerTwo.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerOne.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerTwo
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress left to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof TurquoiseProperty) {
						int counter = 0;
						for (Property k : playerTwo.getProperties()) {
							if (k instanceof TurquoiseProperty) {
								counter++;
							}
						}
						if (counter == 3) {
							displayedText += "\n"
									+ playerTwo.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerOne.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerTwo
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress left to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof PinkProperty) {
						int counter = 0;
						for (Property k : playerTwo.getProperties()) {
							if (k instanceof PinkProperty) {
								counter++;
							}
						}
						if (counter == 3) {
							displayedText += "\n"
									+ playerTwo.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerOne.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerTwo
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress left to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof OrangeProperty) {
						int counter = 0;
						for (Property k : playerTwo.getProperties()) {
							if (k instanceof OrangeProperty) {
								counter++;
							}
						}
						if (counter == 3) {
							displayedText += "\n"
									+ playerTwo.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerOne.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerTwo
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress left to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof RedProperty) {
						int counter = 0;
						for (Property k : playerTwo.getProperties()) {
							if (k instanceof RedProperty) {
								counter++;
							}
						}
						if (counter == 3) {
							displayedText += "\n"
									+ playerTwo.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerOne.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerTwo
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress left to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof YellowProperty) {
						int counter = 0;
						for (Property k : playerTwo.getProperties()) {
							if (k instanceof YellowProperty) {
								counter++;
							}
						}
						if (counter == 3) {
							displayedText += "\n"
									+ playerTwo.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerOne.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerTwo
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress left to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof GreenProperty) {
						int counter = 0;
						for (Property k : playerTwo.getProperties()) {
							if (k instanceof GreenProperty) {
								counter++;
							}
						}
						if (counter == 3) {
							displayedText += "\n"
									+ playerTwo.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerOne.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerTwo
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress left to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof BlueProperty) {
						int counter = 0;
						for (Property k : playerTwo.getProperties()) {
							if (k instanceof BlueProperty) {
								counter++;
							}
						}
						if (counter == 2) {
							displayedText += "\n"
									+ playerTwo.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerOne.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerTwo
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress left to end your turn.";
						}
					}
					if (playerOne.getMoney() == money) {
						displayedText += "\n"
								+ playerOne.getName()
								+ ", your opponent owns this property, you must pay $"
								+ ((Property) spaces[newSpace]).getRentPrice();
						playerOne.changeMoney(-1.0
								* ((Property) spaces[newSpace]).getRentPrice());
						playerTwo.changeMoney(((Property) spaces[newSpace])
								.getRentPrice());
						displayedText += "\nPress left to end your turn.";
					}
					p1k = 3;
				}

				if (playerOne.getMoney() < 0) {
					gameOver = true;
					p1k = 10;
				}

				if (spaces[newSpace] instanceof TaxSpace) {
					playerOne.changeMoney(-1
							* ((TaxSpace) spaces[newSpace]).getTaxAmount());
					displayedText += "\nYou have paid $"
							+ ((TaxSpace) spaces[newSpace]).getTaxAmount()
							+ " in " + spaces[newSpace].getName();
					displayedText += "\nPress the left key to end your turn.";
					p1k = 3;
				}

				if (spaces[newSpace] instanceof PassiveSpace
						&& spaces[newSpace].getName().equals(
								"Send To Detention")) {
					playerOne.setSpace(10);
					p1x = 72;
					p1y = 78;
					playerOne.changeMoney(-1 * 50);
					displayedText += "\nYou have been sent to Detention and have had to pay $50.";
				}

				if (spaces[newSpace] instanceof PassiveSpace
						&& !(spaces[newSpace] instanceof TaxSpace)
						&& !(spaces[newSpace] instanceof ChanceSpace)) {
					displayedText += "\nPress the left key to end your turn.";
					p1k = 3;
				}

				if (spaces[newSpace] instanceof ChanceSpace) {
					int chance = ((ChanceSpace) spaces[newSpace])
							.chanceFunction();
					double money = chanceValues[chance];
					displayedText += "\nChance Time! " + chanceOptions[chance];
					displayedText += "\nPress the left key to end your turn.";
					playerOne.changeMoney(money);
					p1k = 4;
				}

				if (playerOne.getMoney() < 0) {
					gameOver = true;
					p1k = 10;
				}

				textField.setText(displayedText);
			}
			if ((spaces[playerOne.getSpace()] instanceof Property || spaces[playerOne
					.getSpace()] instanceof Property)
					&& p1k == 2
					&& input.isKeyDown(Input.KEY_UP)) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				try {
					((Property) spaces[playerOne.getSpace()])
							.changeOwnershipStatus();
				} catch (ClassCastException k) {
					k.printStackTrace();
					System.err.println("Cannot be cast as a Property.");
				}
				playerOne.changeMoney(-1
						* ((Property) spaces[playerOne.getSpace()]).getPrice());
				playerOne.addProperty((Property) spaces[playerOne.getSpace()]);
				((Property) spaces[playerOne.getSpace()]).setOwnerSymbol("1");
				p1k = 1;
				playerTurn = 2;
			}
			if ((p1k == 3 || p1k == 2 || p1k == 4)
					&& input.isKeyDown(Input.KEY_LEFT)) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				p1k = 1;
				playerTurn = 2;
			}
		} else if (playerTurn == 2) {
			if (p2k == 1) {
				if (playerTwo.getMoney() < 0) {
					gameOver = false;
					p2k = 10;
				}
				diceRoll = rollDice();
				int oldSpace = playerTwo.getSpace();
				int newSpace = (oldSpace + diceRoll) % 40;
				diceDisplay = true;
				playerTwo.setSpace(newSpace);
				p2x = player2Positions[playerTwo.getSpace()].getX();
				p2y = player2Positions[playerTwo.getSpace()].getY();

				String displayedText = playerTwo.getName() + ", you  rolled "
						+ diceRoll + " and moved from space " + oldSpace
						+ " to space " + newSpace + ".";

				textField.setText(displayedText);

				if (newSpace < oldSpace) {
					playerTwo.changeMoney(200);
				}

				displayedText += "\nThis space is: "
						+ spaces[newSpace].getName();

				textField.setText(displayedText);

				boolean iOwn = false;

				for (Property k : playerTwo.getProperties()) {
					if (spaces[newSpace].getName().equals(k.getName())) {
						iOwn = true;
					}
				}

				boolean theyOwn = false;

				for (Property k : playerOne.getProperties()) {
					if (spaces[newSpace].getName().equals(k.getName())) {
						theyOwn = true;
					}
				}

				if ((spaces[newSpace] instanceof Property || spaces[newSpace] instanceof Railroad)
						&& ((Property) spaces[newSpace]).isOwned() == false
						&& playerTwo.getMoney() > ((Property) spaces[newSpace])
								.getPrice()
						&& iOwn == false
						&& theyOwn == false) {
					displayedText += "\nWould you like to buy this property? Press up to buy,\npress down to decline. The cost of this property is $"
							+ ((Property) spaces[newSpace]).getPrice();
					p2k = 2;
				}

				if ((spaces[newSpace] instanceof Property || spaces[newSpace] instanceof Railroad)
						&& ((Property) spaces[newSpace]).isOwned() == false
						&& playerTwo.getMoney() <= ((Property) spaces[newSpace])
								.getPrice()
						&& iOwn == false
						&& theyOwn == false) {
					displayedText += "\nYou cannot afford this property, press down to end your turn.";
					p2k = 3;
				}

				if ((spaces[newSpace] instanceof Property || spaces[newSpace] instanceof Railroad)
						&& iOwn == true) {
					displayedText += "\nYou already own this property, press the down key to end your turn.";
					p2k = 3;
				}

				if ((spaces[newSpace] instanceof Property || spaces[newSpace] instanceof Railroad)
						&& theyOwn == true) {
					double money = playerTwo.getMoney();
					if (spaces[newSpace] instanceof BrownProperty) {
						int counter = 0;
						for (Property k : playerOne.getProperties()) {
							if (k instanceof BrownProperty) {
								counter++;
							}
						}
						if (counter == 2) {
							displayedText += "\n"
									+ playerOne.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerTwo.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerOne
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress down to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof TurquoiseProperty) {
						int counter = 0;
						for (Property k : playerOne.getProperties()) {
							if (k instanceof TurquoiseProperty) {
								counter++;
							}
						}
						if (counter == 3) {
							displayedText += "\n"
									+ playerOne.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerTwo.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerOne
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress down to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof PinkProperty) {
						int counter = 0;
						for (Property k : playerOne.getProperties()) {
							if (k instanceof PinkProperty) {
								counter++;
							}
						}
						if (counter == 3) {
							displayedText += "\n"
									+ playerOne.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerTwo.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerOne
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress down to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof OrangeProperty) {
						int counter = 0;
						for (Property k : playerOne.getProperties()) {
							if (k instanceof OrangeProperty) {
								counter++;
							}
						}
						if (counter == 3) {
							displayedText += "\n"
									+ playerOne.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerTwo.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerOne
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress down to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof RedProperty) {
						int counter = 0;
						for (Property k : playerOne.getProperties()) {
							if (k instanceof RedProperty) {
								counter++;
							}
						}
						if (counter == 3) {
							displayedText += "\n"
									+ playerOne.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerTwo.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerOne
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress down to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof YellowProperty) {
						int counter = 0;
						for (Property k : playerOne.getProperties()) {
							if (k instanceof YellowProperty) {
								counter++;
							}
						}
						if (counter == 3) {
							displayedText += "\n"
									+ playerOne.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerTwo.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerOne
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress down to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof GreenProperty) {
						int counter = 0;
						for (Property k : playerOne.getProperties()) {
							if (k instanceof GreenProperty) {
								counter++;
							}
						}
						if (counter == 3) {
							displayedText += "\n"
									+ playerOne.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerTwo.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerOne
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress down to end your turn.";
						}
					}
					if (spaces[newSpace] instanceof BlueProperty) {
						int counter = 0;
						for (Property k : playerOne.getProperties()) {
							if (k instanceof BlueProperty) {
								counter++;
							}
						}
						if (counter == 2) {
							displayedText += "\n"
									+ playerOne.getName()
									+ " owns all of this color properties. You must pay $"
									+ 2.0
									* ((Property) spaces[newSpace])
											.getRentPrice();
							playerTwo.changeMoney(-2.0
									* ((Property) spaces[newSpace])
											.getRentPrice());
							playerOne
									.changeMoney(2.0 * ((Property) spaces[newSpace])
											.getRentPrice());
							displayedText += "\nPress down to end your turn.";
						}
					}
					if (playerTwo.getMoney() == money) {
						displayedText += "\n"
								+ playerTwo.getName()
								+ ", your opponent owns this property, you must pay $"
								+ ((Property) spaces[newSpace]).getRentPrice();
						playerTwo.changeMoney(-1.0
								* ((Property) spaces[newSpace]).getRentPrice());
						playerOne.changeMoney(((Property) spaces[newSpace])
								.getRentPrice());
						displayedText += "\nPress down to end your turn.";
					}
					p2k = 3;
				}

				if (playerTwo.getMoney() < 0) {
					gameOver = false;
					p2k = 10;
				}

				if (spaces[newSpace] instanceof TaxSpace) {
					playerTwo.changeMoney(-1
							* ((TaxSpace) spaces[newSpace]).getTaxAmount());
					displayedText += "\nYou have paid $"
							+ ((TaxSpace) spaces[newSpace]).getTaxAmount()
							+ " in " + spaces[newSpace].getName();
					displayedText += "\nPress the down key to end your turn.";
					p2k = 3;
				}

				if (spaces[newSpace] instanceof PassiveSpace
						&& spaces[newSpace].getName().equals(
								"Send To Detention")) {
					playerTwo.setSpace(10);
					p2x = 72;
					p2y = 105;
					playerTwo.changeMoney(-1 * 50);
					displayedText += "\nYou have been sent to Detention and have had to pay $50.";
				}

				if (spaces[newSpace] instanceof PassiveSpace
						&& !(spaces[newSpace] instanceof TaxSpace)
						&& !(spaces[newSpace] instanceof ChanceSpace)) {
					displayedText += "\nPress the down key to end your turn.";
					p2k = 3;
				}

				if (spaces[newSpace] instanceof ChanceSpace) {
					int chance = ((ChanceSpace) spaces[newSpace])
							.chanceFunction();
					double money = chanceValues[chance];
					displayedText += "\nChance Time! " + chanceOptions[chance];
					displayedText += "\nPress the down key to end your turn.";
					playerTwo.changeMoney(money);
					p2k = 4;
				}

				if (playerTwo.getMoney() < 0) {
					gameOver = false;
					p2k = 10;
				}

				textField.setText(displayedText);
			}
			if ((spaces[playerTwo.getSpace()] instanceof Property || spaces[playerTwo
					.getSpace()] instanceof Railroad)
					&& p2k == 2
					&& input.isKeyDown(Input.KEY_UP)) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					((Property) spaces[playerTwo.getSpace()])
							.changeOwnershipStatus();
				} catch (ClassCastException k) {
					k.printStackTrace();
					System.err.println("Cannot be cast as a Property.");
				}
				playerTwo.changeMoney(-1
						* ((Property) spaces[playerTwo.getSpace()]).getPrice());
				playerTwo.addProperty((Property) spaces[playerTwo.getSpace()]);
				((Property) spaces[playerTwo.getSpace()]).setOwnerSymbol("2");
				p2k = 1;
				playerTurn = 1;
			}
			if ((p2k == 3 || p2k == 2 || p2k == 4)
					&& input.isKeyDown(Input.KEY_DOWN)) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				p2k = 1;
				playerTurn = 1;
			}
		}
		if (p1k == 10 || p2k == 10 || gameOver == true && x == 1) {
			Player winningPlayer = null;
			Player losingPlayer = null;

			if (playerOne.getMoney() > playerTwo.getMoney()) {
				winningPlayer = playerOne;
				losingPlayer = playerTwo;
			} else if (playerTwo.getMoney() > playerOne.getMoney()) {
				winningPlayer = playerTwo;
				losingPlayer = playerOne;
			}
			textField
					.setText("The Game is Over!\n" + winningPlayer.getName()
							+ ", you have won!\n" + losingPlayer.getName()
							+ " has run out of money!" + "\n"
							+ winningPlayer.makeFun());
			x++;
		}

	}

	/*
	 * This function will return a random number between 2 and 12, representing
	 * rolling two dice. Preconditions: None
	 * 
	 * @return A random number between 2 and 12
	 */
	public int rollDice() {
		return (int) ((Math.random()) * (6) + 1)
				+ (int) ((Math.random()) * (6) + 1);
	}

	/*
	 * This function will return the state that the game is currently in.
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.state.BasicGameState#getID()
	 */
	public int getID() {
		return stateID;
	}

}
