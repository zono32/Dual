package edu.gorillas;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreCardTest {

    private ScoreCard scoreCard = null;

    /* -------------- TESTING BEHAVIOURS -------------------*/

    @BeforeEach
    public void init() {
        scoreCard = new ScoreCard();
    }

    @Test

    public void calculateScoreTest() {
        String point = "12345123451234512345";
        int totalScore = scoreCard.calculateScore(point);
        assertEquals(60, totalScore);
    }
    
}