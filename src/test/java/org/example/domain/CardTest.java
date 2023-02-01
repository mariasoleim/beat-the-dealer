package org.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void testFromString() {
        String cardAsString = "D5";
        Card card = Card.fromString(cardAsString);
        Suit suit = card.suit();
        Rank rank = card.rank();
        assertEquals(Suit.D, suit);
        assertEquals(Rank._5, rank);
    }
}
