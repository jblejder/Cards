package jblejder.cards.shared.cardHandRecognition.recognitors;

import com.annimon.stream.Stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import jblejder.cards.R;
import jblejder.cards.shared.cardHandRecognition.Hand;
import jblejder.cards.shared.cardHandRecognition.HandRecognitor;
import jblejder.cards.shared.cardHandRecognition.RecognitionResult;
import jblejder.cards.shared.models.Card;
import jblejder.cards.shared.models.CardValue;

public class FigureRecognitor implements HandRecognitor {

    private int figuresCount;

    public FigureRecognitor(int figuresCount) {
        this.figuresCount = figuresCount;
    }

    @Override
    public RecognitionResult recognise(List<Card> cards) {
        CardValue[] figures = {CardValue.Jack, CardValue.Queen, CardValue.King};
        HashSet<CardValue> availableFigures = new HashSet<>(Arrays.asList(figures));

        long count = Stream.of(cards)
                .filter(value -> availableFigures.contains(value.getValue()))
                .count();

        if (count >= figuresCount) {
            return RecognitionResult.withHand(new Figure());
        } else {
            return RecognitionResult.notFound();
        }
    }

    private class Figure implements Hand {
        @Override
        public int getName() {
            return R.string.figure_hand;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Figure;
        }
    }
}
