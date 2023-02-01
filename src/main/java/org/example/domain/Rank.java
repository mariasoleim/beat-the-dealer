package org.example.domain;

public enum Rank {
    _2, _3, _4, _5, _6, _7, _8, _9, _10, J, Q, K, A;

    public static Rank fromString(String numberAsString) {
        try {
            Integer.parseInt(numberAsString);
            return Rank.valueOf("_" + numberAsString);
        } catch (NumberFormatException ex){
            return Rank.valueOf(numberAsString);
        }
    }
}
