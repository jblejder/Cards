package jblejder.cards.shared.cardHandRecognition.recognitors;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.ArrayList;
import java.util.List;

import jblejder.cards.R;
import jblejder.cards.shared.cardHandRecognition.Hand;
import jblejder.cards.shared.cardHandRecognition.HandRecognitor;
import jblejder.cards.shared.cardHandRecognition.RecognitionResult;
import jblejder.cards.shared.models.Card;
import jblejder.cards.shared.models.CardValue;

public class StairsRecognitor implements HandRecognitor {

    private int elementsInRow;

    public StairsRecognitor(int elementsInRow) {
        this.elementsInRow = elementsInRow;
    }

    @Override
    public RecognitionResult recognise(List<Card> cards) {
        if (cards.size() < elementsInRow) {
            return RecognitionResult.notFound();
        }

        ArrayList<Card> copyCards = new ArrayList<>(cards);

        List<CardValue> sorted = Stream.of(copyCards)
                .map(Card::getValue)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        CardValue prevCard = sorted.get(0);
        int risingElements = 1;
        int decreasingElements = 1;

        for (int i = 1; i < sorted.size(); i++) {
            CardValue cardValue = sorted.get(i);
            int step = cardValue.ordinal() - prevCard.ordinal();
            if (step == 1) {
                risingElements += 1;
            } else {
                risingElements = 1;
            }

            if (step == -1) {
                decreasingElements += 1;
            } else {
                decreasingElements = 1;
            }
            prevCard = cardValue;

            if (risingElements >= elementsInRow || decreasingElements >= elementsInRow) {
                return RecognitionResult.withHand(new StepsHand());
            }
        }
        return RecognitionResult.notFound();
    }

    private int compare(CardValue c1, CardValue c2) {
        int c1value = c1.ordinal();
        int c2value = c2.ordinal();
        return Integer.compare(c1value, c2value);
    }

    private class StepsHand implements Hand {
        @Override
        public int getName() {
            return R.string.stairs_hand;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof StepsHand;
        }
    }
}
