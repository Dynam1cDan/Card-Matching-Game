package cardgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

/**
 * This class creates a Game Board and constructs card objects from the Card class.
 * After constructing the card objects it places them onto the GameBoard.
 * 
 * @author Daniel Hawkins
 *
 */

public class GameBoard extends JFrame {
	private ArrayList<Card> cardList = new ArrayList<Card>();
	private static int colorCount = 0;
	private static int pairs;

	public static void main(String[] args) {
		new GameBoard(10);
	}
	
	/**
	 * This constructor creates a new game board and also creates Card objects that are placed onto the game board.
	 * This constructor also chooses a color that is assigned to each pair of card objects created and also assigns
	 * actions listeners to the cards.
	 * 
	 * @param pairs This parameter is used to determine how many pairs of cards the constructor will create.
	 */

	public GameBoard(int pairs) {
		this.pairs = pairs;
		setTitle("Concentration Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		
		c.setLayout(new GridLayout((int) Math.floor(Math.sqrt(pairs)) + 1, (int) Math.floor(Math.sqrt(pairs))));
		c.setBackground(Color.BLACK);
		c.setPreferredSize(new Dimension(1000,800));


		for (int i = 1; i < pairs + 1; i++) {
			Color[] colorList = new Color[] { Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA,
					Color.CYAN };

			if (colorCount > 4) {
				colorCount = 0;
			} else {
				colorCount++;
			}

			Color color = colorList[colorCount];

			Card c1 = new Card(color);
			Card c2 = new Card(color);

			cardList.add(c1);
			cardList.add(c2);

			GameController gc = new GameController();
			c1.addActionListener(gc);
			c2.addActionListener(gc);
		}

		Collections.shuffle(cardList);
		for (int i = 0; i < cardList.size(); i++) {
			c.add(cardList.get(i));
		}
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * This constructor has the sole purpose of giving the GameController access to the getPairs() method.
	 */

	public GameBoard() {
		return;
	}
	
	/**
	 * This method returns the number of pairs of cards on the game board.
	 * 
	 * @return Returns the number of pairs of cards on the game board.
	 */

	public int getPairs() {
		return pairs;
	}
}
