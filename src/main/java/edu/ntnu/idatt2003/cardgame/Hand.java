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
     * Method checks if hand is flush (All cards have same suit).
     * @return boolean: true if hand is flush or boolean: false if hand is not flush.
     */
    public boolean isFlush() {
      if (hand.isEmpty()) return false;

      char firstSuit = hand.getFirst().getSuit();
      return hand.stream().allMatch(card -> card.getSuit() == firstSuit);
    }

    /**
     * Method checks if hand contains card queen of spades,
     * and returns answer Yes or No.
     * @return Yes or No
     */
    public String checkQueenOfSpades() {
      boolean found = hand.stream()
          .anyMatch(card ->
              card.getFace() == 12 && card.getSuit() == 'S');
      return found ? "Yes" : "No";
    }

    /**
     * Method returns all cards of suit hearts.
     * Returns No Hearts if no cards of hearts.
     * @return All cards of hearts as String
     */
    public String getHearts() {
      String hearts = hand.stream()
          .filter(card -> card.getSuit() == 'H')
          .map(PlayingCard::getAsString)
          .collect(java.util.stream.Collectors.joining());

      return hearts.isEmpty() ? "No Hearts" : hearts;
    }

    /**
     * Method returns the total sum of all cards on hand.
     * @return int: sum
     */
    public int getSum() {
      return hand.stream()
          .mapToInt(PlayingCard::getFace)
          .sum();
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