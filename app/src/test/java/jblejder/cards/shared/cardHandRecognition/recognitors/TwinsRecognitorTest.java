package jblejder.cards.shared.cardHandRecognition.recognitors;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import jblejder.cards.shared.cardHandRecognition.RecognitionResult;
import jblejder.cards.shared.models.Card;
import jblejder.cards.shared.models.CardValue;

public class TwinsRecognitorTest {

    @Test
    public void recognise3Kings() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(null, CardValue.King));
        cards.add(new Card(null, CardValue.King));
        cards.add(new Card(null, CardValue.King));

        TwinsRecognitor recognitor = new TwinsRecognitor(3);

        RecognitionResult result = recognitor.recognise(cards);

        Assert.assertEquals(true, result.isFound());
    }

    @Test
    public void recognise2Kings() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(null, CardValue.King));
        cards.add(new Card(null, CardValue.King));

        TwinsRecognitor recognitor = new TwinsRecognitor(3);

        RecognitionResult result = recognitor.recognise(cards);

        Assert.assertEquals(false, result.isFound());
    }

    @Test
    public void recogniseVariousFigures() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(null, CardValue.King));
        cards.add(new Card(null, CardValue.Queen));
        cards.add(new Card(null, CardValue.Jack));

        TwinsRecognitor recognitor = new TwinsRecognitor(3);

        RecognitionResult result = recognitor.recognise(cards);

        Assert.assertEquals(false, result.isFound());
    }

    @Test
    public void aceIsNotFigure() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(null, CardValue.King));
        cards.add(new Card(null, CardValue.Ace));
        cards.add(new Card(null, CardValue.Jack));

        TwinsRecognitor recognitor = new TwinsRecognitor(3);

        RecognitionResult result = recognitor.recognise(cards);

        Assert.assertEquals(false, result.isFound());
    }
}