package edu.ntnu.idatt2003.cardgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckOfCardsTest {

  @Test
  void testDeckHas52CardsWhenCreated() {
    DeckOfCards deck = new DeckOfCards();
    assertEquals(52, deck.getPlayingCards().size());
  }

  @Test
  void testDealHandReturnsCorrectNumberOfCards() {
    DeckOfCards deck = new DeckOfCards();
    Hand hand = deck.dealHand(7);
    assertEquals(7, hand.getHand().size());
  }

  @Test
  void testDealHandThrowsExceptionIfTooManyCards() {
    DeckOfCards deck = new DeckOfCards();
    assertThrows(IllegalArgumentException.class, () -> deck.dealHand(53));
  }

  @Test
  void testAllCardsAreUniqueInDeck() {
    DeckOfCards deck = new DeckOfCards();
    Hand hand = deck.dealHand(52);

    long distinctCount = hand.getHand().stream().distinct().count();

    assertEquals(52, distinctCount);
  }
}