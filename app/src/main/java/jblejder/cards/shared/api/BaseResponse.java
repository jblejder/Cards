package jblejder.cards.shared.api;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {
    @SerializedName("success")
    public boolean success;
    @SerializedName("deckId")
    public String  deckId;
    @SerializedName("remaining")
    public int     remaining;
}
