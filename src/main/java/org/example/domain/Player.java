package org.example.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Player {

    private final String name;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getCardsAsString() {
        return cards.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return cards.stream().mapToInt(Card::getPointValue).sum();
    }

    public boolean hasBlackJack() {
        return cards.size() == 2 && getScore() == 21;
    }

    public void drawFromDeck(LinkedList<Card> deck) {
        this.cards.add(deck.pop());
    }
}
