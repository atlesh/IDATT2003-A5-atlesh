package edu.ntnu.idatt2003.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a full deck of 52 playing cards.
 */
public class DeckOfCards {

  private final List<PlayingCard> deck;
  private final char[] suit = {'S', 'H', 'D', 'C'};

  /**
   * Creates a full deck of 52 playing cards.
   */
  public DeckOfCards() {
    deck = new ArrayList<>();

    for (char suit : suit) {
      for(int face = 1; face <= 13; face++) {
        deck.add(new PlayingCard(suit, face));
      }
    }
  }

  public Hand dealHand(int n) {
    if (n < 1 || n > deck.size()) {
      throw new IllegalArgumentException("n must be a number between 1 and " + deck.size());
    }

    Collections.shuffle(deck);

    return new Hand(deck.subList(0, n));
  }

  public List<PlayingCard> getPlayingCards() {
    return deck;
  }
}
