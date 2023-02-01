package org.example.domain;

import org.example.domain.exceptions.NotAValidCardException;

public record Card(Suit suit, Rank rank) {

    public static Card fromString(String cardAsString) {
        Suit suit;
        Rank rank;
        try {
            suit = Suit.valueOf(cardAsString.substring(0,1));
            rank = Rank.fromString(cardAsString.substring(1));
        } catch (Exception e) {
            throw new NotAValidCardException(cardAsString);
        }
        return new Card(suit, rank);
    }

    public int getPointValue() {
        return rank().getPointValue();
    }

    @Override
    public String toString() {
        return suit.toString() + rank;
    }
}
