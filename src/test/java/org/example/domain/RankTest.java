package org.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @Test
    void getPointValueForNumericNumber() {
        Rank rank = Rank._2;
        int pointValue = rank.getPointValue();
        assertEquals(2, pointValue);
    }

    @Test
    void getPointValueForFaceNumber() {
        Rank rank = Rank.J;
        int pointValue = rank.getPointValue();
        assertEquals(10, pointValue);
    }

    @Test
    void fromString() {
        String numberAsString = "2";
        Rank rank = Rank.fromString(numberAsString);
        assertEquals(Rank._2, rank);
    }
}
