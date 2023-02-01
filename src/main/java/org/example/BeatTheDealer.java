package org.example;

import org.example.domain.Card;
import org.example.domain.Player;
import org.example.utils.FileReader;
import org.example.utils.RandomDeckGenerator;

import java.util.LinkedList;

public class BeatTheDealer {
    public static void main(String[] args) {

        LinkedList<Card> deck;

        if (args.length > 0) {
            String pathToDeck = args[0];
            deck = FileReader.getDeckFromFile(pathToDeck);
        } else {
            deck = RandomDeckGenerator.getRandomDeck();
        }

        Game game = new Game(deck);

        Player winner = game.playAndReturnWinner();

        System.out.println(winner.getName());
    }
}