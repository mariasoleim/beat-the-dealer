package org.example.utils;

import org.example.domain.Card;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class FileReader {

    public static LinkedList<Card> getDeckFromFile(String path) {
        String cardsAsString;

        try {
            cardsAsString = Files.readString(Path.of(path));
        } catch (IOException e) {
            if (e instanceof NoSuchFileException) {
                throw new RuntimeException("Could not find file with deck of cards: " + path);
            } else {
                throw new RuntimeException("Something went wrong with reading the file with deck of cards");
            }
        }

        return Arrays.stream(cardsAsString.split(","))
                .map(String::strip)
                .map(Card::fromString)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
