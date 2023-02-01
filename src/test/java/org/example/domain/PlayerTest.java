package org.example.domain;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player pusefinn = new Player("Pusefinn");

    @Test
    void scoreOfTwoAcesIs22() {
        Card spadesAce = Card.fromString("SA");
        Card heartsAce = Card.fromString("HA");
        LinkedList<Card> deck = new LinkedList<>(List.of(spadesAce, heartsAce));
        pusefinn.drawFromDeck(deck);
        pusefinn.drawFromDeck(deck);
        int score = pusefinn.getScore();
        assertEquals(22, score);
    }

    @Test
    void scoreOfJackAndFiveIs15() {
        Card spadesJack = Card.fromString("SJ");
        Card clubsFive = Card.fromString("C5");
        LinkedList<Card> deck = new LinkedList<>(List.of(spadesJack, clubsFive));
        pusefinn.drawFromDeck(deck);
        pusefinn.drawFromDeck(deck);
        int score = pusefinn.getScore();
        assertEquals(15, score);
    }

    @Test
    void threeCardsIsNotBlackJack() {
        Card clubs2 = Card.fromString("C2");
        Card diamonds9 = Card.fromString("D9");
        Card heartsQueen = Card.fromString("HQ");
        LinkedList<Card> deck = new LinkedList<>(List.of(clubs2, diamonds9, heartsQueen));
        pusefinn.drawFromDeck(deck);
        pusefinn.drawFromDeck(deck);
        pusefinn.drawFromDeck(deck);
        boolean hasBlackJack = pusefinn.hasBlackJack();
        assertFalse(hasBlackJack);
    }

    @Test
    void twoAcesIsNotBlackJack() {
        Card clubsAce = Card.fromString("CA");
        Card diamondsAce = Card.fromString("DA");
        LinkedList<Card> deck = new LinkedList<>(List.of(clubsAce, diamondsAce));
        pusefinn.drawFromDeck(deck);
        pusefinn.drawFromDeck(deck);
        boolean hasBlackJack = pusefinn.hasBlackJack();
        assertFalse(hasBlackJack);
    }

    @Test
    void twoCardsAndScore21IsBlackJack() {
        Card clubsAce = Card.fromString("CA");
        Card diamondsKing = Card.fromString("DK");
        LinkedList<Card> deck = new LinkedList<>(List.of(clubsAce, diamondsKing));
        pusefinn.drawFromDeck(deck);
        pusefinn.drawFromDeck(deck);
        boolean hasBlackJack = pusefinn.hasBlackJack();
        assertTrue(hasBlackJack);
    }
}
