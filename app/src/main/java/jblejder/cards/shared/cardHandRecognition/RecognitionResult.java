package jblejder.cards.shared.cardHandRecognition;

public class RecognitionResult {
    private boolean found;
    private Hand    hand;

    private RecognitionResult(boolean found, Hand hand) {
        this.found = found;
        this.hand = hand;
    }

    public static RecognitionResult notFound() {
        return new RecognitionResult(false, null);
    }

    public static RecognitionResult withHand(Hand hand) {
        return new RecognitionResult(true, hand);
    }

    public boolean isFound() {
        return found;
    }

    public Hand getHand() {
        return hand;
    }
}
