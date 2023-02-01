package org.example;

import org.example.domain.Card;
import org.example.domain.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class BeatTheDealer {
    public static void main(String[] args) {
        String cardsAsString;
        String path = args[0];

        try {
            cardsAsString = Files.readString(Path.of(args[0]));
        } catch (IOException e) {
            if (e instanceof NoSuchFileException) {
                throw new RuntimeException("Could not find file with deck of cards: " + path);
            } else {
                throw new RuntimeException("Something went wrong with reading the file with deck of cards");
            }
        }

        LinkedList<Card> deck = Arrays.stream(cardsAsString.split(","))
                .map(String::strip)
                .map(Card::fromString)
                .collect(Collectors.toCollection(LinkedList::new));

        Game game = new Game(deck);
        Player winner = game.playAndReturnWinner();

        System.out.println(winner.getName());
    }
}