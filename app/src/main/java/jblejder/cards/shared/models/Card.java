package jblejder.cards.shared.models;

public class Card {
    private CardSuit  suit;
    private CardValue value;
    private String    image;
    private String    code;

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }

    public String getImage() {
        return image;
    }
}
