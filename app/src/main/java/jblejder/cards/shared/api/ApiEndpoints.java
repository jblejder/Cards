package jblejder.cards.shared.api;


import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpoints {

    @GET("deck/new/shuffle")
    Single<NewSetResponse> getNewSet(
            @Query("deck_count") int deckCount
    );

    @GET("deck/{deckId}/draw/?count=1")
    Single<DrawCardResponse> drawCard(
            @Path("deckId") String deckId
    );
}
