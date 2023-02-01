package org.example.domain;

public enum Rank {
    _2, _3, _4, _5, _6, _7, _8, _9, _10, J, Q, K, A;

    public int getPointValue() {
        return switch (this) {
            case _2 -> 2;
            case _3 -> 3;
            case _4 -> 4;
            case _5 -> 5;
            case _6 -> 6;
            case _7 -> 7;
            case _8 -> 8;
            case _9 -> 9;
            case _10, J, Q, K -> 10;
            case A ->  11;
        };
    }

    public static Rank fromString(String numberAsString) {
        try {
            Integer.parseInt(numberAsString);
            return Rank.valueOf("_" + numberAsString);
        } catch (NumberFormatException ex){
            return Rank.valueOf(numberAsString);
        }
    }

    @Override
    public String toString() {
        if (this.name().startsWith("_")) {
            return this.name().split("_")[1];
        } else {
            return this.name();
        }
    }
}
