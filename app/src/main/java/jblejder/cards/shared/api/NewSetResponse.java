package jblejder.cards.shared.api;

import com.google.gson.annotations.SerializedName;

public class NewSetResponse extends BaseResponse {
    @SerializedName("shuffled")
    public boolean shuffled;
}
