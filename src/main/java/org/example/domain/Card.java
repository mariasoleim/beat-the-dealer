package org.example.domain;

public record Card(Suit suit, Rank rank) {

    public static Card fromString(String cardAsString) {
        Suit suit = Suit.valueOf(cardAsString.substring(0,1));
        Rank rank = Rank.fromString(cardAsString.substring(1));
        return new Card(suit, rank);
    }
}
