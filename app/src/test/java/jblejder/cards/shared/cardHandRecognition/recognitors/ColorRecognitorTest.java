package jblejder.cards.shared.cardHandRecognition.recognitors;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import jblejder.cards.shared.cardHandRecognition.RecognitionResult;
import jblejder.cards.shared.models.Card;
import jblejder.cards.shared.models.CardSuit;

public class ColorRecognitorTest {

    @Test
    public void recognize3Colors() throws Exception {

        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.Clubs, null));
        cards.add(new Card(CardSuit.Clubs, null));
        cards.add(new Card(CardSuit.Clubs, null));

        ColorRecognitor recognitor = new ColorRecognitor(3);

        RecognitionResult result = recognitor.recognise(cards);

        Assert.assertEquals(true, result.isFound());
    }

    @Test
    public void recognize4Colors() throws Exception {

        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.Clubs, null));
        cards.add(new Card(CardSuit.Spades, null));
        cards.add(new Card(CardSuit.Clubs, null));
        cards.add(new Card(CardSuit.Clubs, null));

        ColorRecognitor recognitor = new ColorRecognitor(3);

        RecognitionResult result = recognitor.recognise(cards);

        Assert.assertEquals(true, result.isFound());
    }

}