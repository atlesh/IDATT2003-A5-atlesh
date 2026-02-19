package edu.ntnu.idatt2003.cardgame;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

  // Positive tester

  @Test
  void constructorCreates52Cards() {
    DeckOfCards deck = new DeckOfCards();
    assertEquals(52, deck.getPlayingCards().size());
  }

  @Test
  void deckContainsAllSuits() {
    DeckOfCards deck = new DeckOfCards();
    List<PlayingCard> cards = deck.getPlayingCards();

    assertTrue(cards.stream().anyMatch(c -> c.getSuit() == 'S'));
    assertTrue(cards.stream().anyMatch(c -> c.getSuit() == 'H'));
    assertTrue(cards.stream().anyMatch(c -> c.getSuit() == 'D'));
    assertTrue(cards.stream().anyMatch(c -> c.getSuit() == 'C'));
  }

  @Test
  void dealHandReturnsCorrectNumberOfCards() {
    DeckOfCards deck = new DeckOfCards();
    Hand hand = deck.dealHand(5);

    assertEquals(5, hand.getHand().size());
  }

  @Test
  void dealHandReturnsHandObject() {
    DeckOfCards deck = new DeckOfCards();
    Hand hand = deck.dealHand(3);

    assertNotNull(hand);
  }

  // Negative tester

  @Test
  void dealHandThrowsExceptionForZeroCards() {
    DeckOfCards deck = new DeckOfCards();

    assertThrows(IllegalArgumentException.class, () -> {
      deck.dealHand(0);
    });
  }

  @Test
  void dealHandThrowsExceptionForTooManyCards() {
    DeckOfCards deck = new DeckOfCards();

    assertThrows(IllegalArgumentException.class, () -> {
      deck.dealHand(53);
    });
  }
}
