package org.example;

import org.example.domain.Card;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Arrays;

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

        var x = Arrays.stream(cardsAsString.split(","))
                .map(String::strip)
                .map(Card::fromString)
                .toList();

        System.out.println(x);
    }
}