package jblejder.cards.shared.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import jblejder.cards.shared.models.Card;

public class DrawCardResponse extends BaseResponse {
    @SerializedName("cards")
    public List<Card> cards;
}
