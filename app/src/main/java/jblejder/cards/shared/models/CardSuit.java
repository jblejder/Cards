package jblejder.cards.shared.models;

import com.google.gson.annotations.SerializedName;

public enum CardSuit {
    @SerializedName("DIAMONDS")
    Diamonds,
    @SerializedName("CLUBS")
    Clubs,
    @SerializedName("HEARTS")
    Hearts,
    @SerializedName("SPADES")
    Spades;
}
