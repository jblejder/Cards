package jblejder.cards.shared.cardHandRecognition;

import java.util.List;

import jblejder.cards.shared.models.Card;

public interface HandRecognitor {
    RecognitionResult recognise(List<Card> cards);
}
