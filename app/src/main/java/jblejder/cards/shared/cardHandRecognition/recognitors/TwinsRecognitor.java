package jblejder.cards.shared.cardHandRecognition.recognitors;

import com.annimon.stream.Stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jblejder.cards.R;
import jblejder.cards.shared.cardHandRecognition.Hand;
import jblejder.cards.shared.cardHandRecognition.HandRecognitor;
import jblejder.cards.shared.cardHandRecognition.RecognitionResult;
import jblejder.cards.shared.models.Card;
import jblejder.cards.shared.models.CardValue;

public class TwinsRecognitor implements HandRecognitor {

    private int twinsCount;

    public TwinsRecognitor(int twinsCount) {
        this.twinsCount = twinsCount;
    }

    @Override
    public RecognitionResult recognise(List<Card> cards) {
        Map<CardValue, Integer> twins = new HashMap<>();

        Stream.of(cards).forEach(card -> {
            CardValue value = card.getValue();
            Integer count = twins.get(value);
            if (count == null) {
                count = 0;
            }
            twins.put(value, count + 1);
        });

        boolean matched = Stream.of(twins.values()).anyMatch(value -> value >= twinsCount);
        if (matched) {
            return RecognitionResult.withHand(new Twins());
        } else {
            return RecognitionResult.notFound();
        }
    }

    private class Twins implements Hand {
        @Override
        public int getName() {
            return R.string.twins_hand;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Twins;
        }
    }
}
