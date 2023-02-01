package org.example.utils;

import org.example.domain.Card;
import org.example.domain.Rank;
import org.example.domain.Suit;

import java.util.Collections;
import java.util.LinkedList;

public class RandomDeckGenerator {

    public static LinkedList<Card> getRandomDeck() {

        LinkedList<Card> deck = new LinkedList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                deck.add(card);
            }
        }

        Collections.shuffle(deck);

        return deck;
    }
}
