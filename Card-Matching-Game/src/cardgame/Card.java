package cardgame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * This class is used to store the attributes of Card objects and uses methods to give the cards functionality
 * when called.
 * 
 * @author Daniel Hawkins
 *
 */

public class Card extends JButton {
	private static int width = 75;
	private static int height = 100;
	private static int count = 0;
	private Color faceColor;
	private static Color backgroundColor = Color.DARK_GRAY;

	private boolean isFaceDown = true;
	
	/**
	 * This constructor creates Card objects that can be placed on a Game Board.
	 * 
	 * @param fc This parameter represents the face color that is to be assigned to the card being created.
	 */

	public Card(Color fc) {
		setPreferredSize(new Dimension(width, height));
		faceColor = fc;
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setOpaque(true);
		faceDown();

	}
	
	/**
	 * This method "flips" a given card to be face up when called.
	 * In other words, it changes the color of the card being specified to its given face color.
	 */

	public void faceUp() {
		isFaceDown = false;
		changeColor(faceColor);
	}
	
	/**
	 * This method "flips" a given card to be face down when called.
	 * In other words, it changes the color of the card being specified to its given background color.
	 */

	public void faceDown() {
		isFaceDown = true;
		changeColor(backgroundColor);
	}
	
	/**
	 * This is a customized equals method to compare two Card objects by their face colors.
	 * 
	 * @return This method returns either true or false depending on the equivalence of the two cards.
	 */

	public boolean equals(Object other) {
		Card otherCard = (Card) other;
		return this.faceColor.equals(otherCard.faceColor);
	}
	
	/**
	 * This method changes the color of a card object when called.
	 * 
	 * @param c This parameter represents a color.
	 */

	private void changeColor(Color c) {
		setBackground(c);
		paintImmediately(0, 0, 500, 500);
	}
	
	/**
	 * This method returns either true of false depending on whether the card being specified is
	 * "face up" or "face down".
	 * 
	 * @return Returns true or false.
	 */

	public boolean isFaceDown() {
		return isFaceDown;
	}
	
	public void flash() {
		for (int i = 1; i < 6 + 1; i++) {
			Color[] colorList = new Color[] { Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA,
					Color.CYAN };

			if (count > 4) {
				count = 0;
			} else {
				count++;
			}

			Color color = colorList[count];
			changeColor(color);
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
