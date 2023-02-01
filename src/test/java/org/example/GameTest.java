package org.example;

import org.example.domain.Card;
import org.example.domain.Player;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void samShouldWinWhenBothHaveBlackJack() {
        LinkedList<Card> deck = new LinkedList<>(
                List.of(
                        Card.fromString("CA"),
                        Card.fromString("DA"),
                        Card.fromString("HK"),
                        Card.fromString("HQ"),
                        Card.fromString("S8")
                )
        );

        Game game = new Game(deck);
        Player winner = game.playAndReturnWinner();
        assertEquals("sam", winner.getName());
    }

    @Test
    void dealerShouldWinWhenBothGoesBust() {
        LinkedList<Card> deck = new LinkedList<>(
                List.of(
                        Card.fromString("CA"),
                        Card.fromString("DA"),
                        Card.fromString("HA"),
                        Card.fromString("SA")
                )
        );

        Game game = new Game(deck);
        Player winner = game.playAndReturnWinner();
        assertEquals("dealer", winner.getName());
    }

    @Test
    void dealerShouldWinWhenSamDrawsMoreThan21() {
        LinkedList<Card> deck = new LinkedList<>(
                List.of(
                        Card.fromString("C5"),
                        Card.fromString("H2"),
                        Card.fromString("DK"),
                        Card.fromString("S2"),
                        Card.fromString("H7")
                )
        );

        Game game = new Game(deck);
        Player winner = game.playAndReturnWinner();
        assertEquals("dealer", winner.getName());
    }

    @Test
    void samShouldWinWhenDealerDrawsMoreThan21() {
        LinkedList<Card> deck = new LinkedList<>(
                List.of(
                        Card.fromString("CA"),
                        Card.fromString("D5"),
                        Card.fromString("H9"),
                        Card.fromString("HQ"),
                        Card.fromString("S8")
                )
        );

        Game game = new Game(deck);
        Player winner = game.playAndReturnWinner();
        assertEquals("sam", winner.getName());
    }
}
