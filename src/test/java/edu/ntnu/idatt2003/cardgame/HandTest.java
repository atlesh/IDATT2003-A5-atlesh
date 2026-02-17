package edu.ntnu.idatt2003.cardgame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

  @Test
  void testFlushReturnsTrueWhenAllCardsSameSuit() {
    List<PlayingCard> cards = List.of(
        new PlayingCard('H', 1),
        new PlayingCard('H', 5),
        new PlayingCard('H', 9),
        new PlayingCard('H', 11),
        new PlayingCard('H', 13)
    );

    Hand hand = new Hand(cards);

    assertTrue(hand.isFlush());
  }

  @Test
  void testFlushReturnsFalseWhenDifferentSuits() {
    List<PlayingCard> cards = List.of(
        new PlayingCard('H', 1),
        new PlayingCard('H', 5),
        new PlayingCard('S', 9),
        new PlayingCard('H', 11),
        new PlayingCard('H', 13)
    );

    Hand hand = new Hand(cards);

    assertFalse(hand.isFlush());
  }

  @Test
  void testEmptyHandIsNotFlush() {
    Hand hand = new Hand(List.of());
    assertFalse(hand.isFlush());
  }
}
