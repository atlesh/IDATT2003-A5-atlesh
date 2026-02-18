package edu.ntnu.idatt2003.cardgame;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents a hand of cards
 */
public class Hand {

  private final List<PlayingCard> hand;

  /**
   * Creates a hand of cards.
   * @param hand hand of cards.
   */
  public Hand(List<PlayingCard> hand) {
    this.hand = new ArrayList<>(hand);
  }

  /**
   * Checks if hand is flush (All cards have same suit).
   * @return boolean: true if hand is flush or boolean: false if hand is not flush.
   */
  public boolean isFlush() {
    if (hand.isEmpty()) {
      return false;
    }

    char firstSuit = hand.getFirst().getSuit();

    for (PlayingCard card : hand) {
      if (card.getSuit() !=  firstSuit) {
        return false;
      }
    }

    return true;
  }

  /**
   * Method returns the total sum of all cards on hand.
   * @return int: sum
   */
  public int getSum() {
    int sum = 0;

    for (PlayingCard card : hand) {
      sum += card.getFace();
    }

    return sum;
  }

  public List<PlayingCard> getHand() {
    return hand;
  }

  /**
   * Creates a String of a hand of cards.
   * Example: A♠ 10♥ K♦ 3♣ 7♠.
   * @return Hand to String format.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (PlayingCard card : hand) {
      sb.append(card.getAsString()).append(" ");
    }
    return sb.toString().trim();
  }
}