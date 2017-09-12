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
import jblejder.cards.shared.models.CardSuit;

public class ColorRecognitor implements HandRecognitor {

    private int sameElements;

    public ColorRecognitor(int sameElements) {
        this.sameElements = sameElements;
    }

    @Override
    public RecognitionResult recognise(List<Card> cards) {
        Map<CardSuit, Integer> counts = new HashMap<>();

        Stream.of(cards)
                .forEach(card -> {
                    CardSuit suit = card.getSuit();
                    Integer current = counts.get(suit);
                    if (current == null) {
                        current = 0;
                    }
                    counts.put(suit, current + 1);
                });

        boolean hasColor = Stream.of(counts.values())
                .anyMatch(value -> value >= sameElements);

        if (hasColor) {
            return RecognitionResult.withHand(new ColorHand());
        } else {
            return RecognitionResult.notFound();
        }
    }

    private class ColorHand implements Hand {
        @Override
        public int getName() {
            return R.string.color_hand;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof ColorHand;
        }
    }
}
