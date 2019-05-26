package cardgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class is used to the control the logic of the game and actions performed on the game board.
 * 
 * @author Daniel Hawkins
 *
 */

public class GameController implements ActionListener {
	private static int clickCount = 0;
	private static int clickTotal = 0;
	private static int cardsMatched = 0;
	private static Card clickedCard2;
	GameBoard gb = new GameBoard();
	int pairs = gb.getPairs();
	private static ArrayList<Card> cardList = new ArrayList<Card>();
	
	/**
	 * This method changes the state of a Card object when it is clicked.
	 * This method also compares cards, keeps click count and controls the logic of the entire game.
	 * Once all of the cards are face up, this method prints a statement letting the user know that
	 * they have completed the game and also prints out the click count.
	 */

	public void actionPerformed(ActionEvent arg0) {
		Card clickedCard = (Card) arg0.getSource();
		if (clickedCard.isFaceDown()) {
			clickedCard.faceUp();
			clickCount++;
			clickTotal++;
			if (clickCount > 1 && clickedCard.equals(clickedCard2) == true) {
				clickCount = 0;
				cardsMatched++;
				cardList.add(clickedCard);
				cardList.add(clickedCard2);
				if (cardsMatched == pairs) {
					System.out.println("Congratulations! You won!");
					System.out.println("Number of clicks: " + clickTotal);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (Card c: cardList) {
						c.faceDown();
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.exit(0);
				}
			}
			if (clickCount > 1 && clickedCard.equals(clickedCard2) == false) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clickedCard.faceDown();
				clickedCard2.faceDown();
				clickCount = 0;
			}
			if (clickCount > 0) {
				clickedCard2 = clickedCard;
			}
		}

	}
}
