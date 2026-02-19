package edu.ntnu.idatt2003.cardgame;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

  // Positive tester

  @Test
  void isFlushReturnsTrueWhenAllSameSuit() {
    Hand hand = new Hand(List.of(
        new PlayingCard('H', 2),
        new PlayingCard('H', 5),
        new PlayingCard('H', 10)
    ));

    assertTrue(hand.isFlush());
  }

  @Test
  void isFlushReturnsFalseWhenDifferentSuits() {
    Hand hand = new Hand(List.of(
        new PlayingCard('H', 2),
        new PlayingCard('S', 5),
        new PlayingCard('H', 10)
    ));

    assertFalse(hand.isFlush());
  }

  @Test
  void checkQueenOfSpadesReturnsYesWhenPresent() {
    Hand hand = new Hand(List.of(
        new PlayingCard('S', 12),
        new PlayingCard('H', 5)
    ));

    assertEquals("Yes", hand.checkQueenOfSpades());
  }

  @Test
  void checkQueenOfSpadesReturnsNoWhenAbsent() {
    Hand hand = new Hand(List.of(
        new PlayingCard('H', 12),
        new PlayingCard('S', 5)
    ));

    assertEquals("No", hand.checkQueenOfSpades());
  }

  @Test
  void getHeartsReturnsHeartsCards() {
    Hand hand = new Hand(List.of(
        new PlayingCard('H', 2),
        new PlayingCard('S', 5),
        new PlayingCard('H', 10)
    ));

    String result = hand.getHearts();
    assertTrue(result.contains("2♥"));
    assertTrue(result.contains("10♥"));
  }

  @Test
  void getSumReturnsCorrectSum() {
    Hand hand = new Hand(List.of(
        new PlayingCard('H', 2),
        new PlayingCard('S', 5),
        new PlayingCard('D', 10)
    ));

    assertEquals(17, hand.getSum());
  }

  @Test
  void toStringReturnsCardsAsString() {
    Hand hand = new Hand(List.of(
        new PlayingCard('S', 1),
        new PlayingCard('H', 10)
    ));

    String result = hand.toString();

    assertTrue(result.contains("A♠"));
    assertTrue(result.contains("10♥"));
  }

  // Negative tester

  @Test
  void isFlushReturnsFalseForEmptyHand() {
    Hand hand = new Hand(List.of());
    assertFalse(hand.isFlush());
  }

  @Test
  void getHeartsReturnsNoHeartsIfNoneExist() {
    Hand hand = new Hand(List.of(
        new PlayingCard('S', 2),
        new PlayingCard('D', 5)
    ));

    assertEquals("No Hearts", hand.getHearts());
  }

  @Test
  void getSumReturnsZeroForEmptyHand() {
    Hand hand = new Hand(List.of());
    assertEquals(0, hand.getSum());
  }
}
