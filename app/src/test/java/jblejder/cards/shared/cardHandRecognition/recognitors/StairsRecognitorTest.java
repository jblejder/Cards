package jblejder.cards.shared.cardHandRecognition.recognitors;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import jblejder.cards.shared.cardHandRecognition.RecognitionResult;
import jblejder.cards.shared.models.Card;
import jblejder.cards.shared.models.CardValue;

import static org.junit.Assert.*;

public class StairsRecognitorTest {

    @Test
    public void recognise3RisingFromAce() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(null, CardValue.V3));
        cards.add(new Card(null, CardValue.Ace));
        cards.add(new Card(null, CardValue.V2));

        StairsRecognitor recognitor = new StairsRecognitor(3);

        RecognitionResult result = recognitor.recognise(cards);

        Assert.assertEquals(true, result.isFound());
    }

    @Test
    public void failWhenSpaceInRow() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(null, CardValue.V4));
        cards.add(new Card(null, CardValue.Ace));
        cards.add(new Card(null, CardValue.V2));

        StairsRecognitor recognitor = new StairsRecognitor(3);

        RecognitionResult result = recognitor.recognise(cards);

        Assert.assertEquals(false, result.isFound());
    }
}