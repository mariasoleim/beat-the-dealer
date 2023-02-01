package org.example;

import org.example.domain.Card;
import org.example.domain.Player;

import java.util.LinkedList;

public class Game {

    private final LinkedList<Card> deck;

    private final Player sam = new Player("sam");
    private final Player dealer = new Player("dealer");

    public Game(LinkedList<Card> deck) {
        this.deck = deck;
    }

    public Player playAndReturnWinner() {

        dealCards();

        if (sam.hasBlackJack()) {
            return sam;
        }

        if (dealer.hasBlackJack()) {
            return dealer;
        }

        if (sam.getScore() > 21 && dealer.getScore() > 21) {
            return dealer;
        }

        while (sam.getScore() < 17) {
            sam.drawFromDeck(deck);
        }

        if (sam.getScore() >= 22) {
            return dealer;
        }

        if (dealer.getScore() <= sam.getScore()) {
            dealer.drawFromDeck(deck);
        }

        if (dealer.getScore() >= 22) {
            return sam;
        }

        return null;
    }

    private void dealCards() {
        sam.drawFromDeck(deck);
        dealer.drawFromDeck(deck);
        sam.drawFromDeck(deck);
        dealer.drawFromDeck(deck);
    }
}
