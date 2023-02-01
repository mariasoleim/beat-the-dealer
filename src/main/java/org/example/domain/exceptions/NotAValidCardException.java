package org.example.domain.exceptions;

public class NotAValidCardException extends RuntimeException {
    public NotAValidCardException(String cardAsString) {
        super(cardAsString + " is not a valid card.");
    }
}
