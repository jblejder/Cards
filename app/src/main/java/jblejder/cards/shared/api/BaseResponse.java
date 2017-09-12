package jblejder.cards.shared.api;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {
    @SerializedName("success")
    public boolean success;
    @SerializedName("deck_id")
    public String  deckId;
    @SerializedName("remaining")
    public int     remaining;
}
