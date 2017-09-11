package jblejder.cards.shared.Services;


import javax.inject.Inject;

import io.reactivex.Single;
import jblejder.cards.shared.api.ApiEndpoints;
import jblejder.cards.shared.api.DrawCardResponse;
import jblejder.cards.shared.api.NewSetResponse;

public class DeckService {

    private ApiEndpoints endpoints;

    @Inject
    public DeckService(ApiEndpoints endpoints) {
        this.endpoints = endpoints;
    }

    public Single<NewSetResponse> getNewCardSet(int deckCount) {
        return endpoints.getNewSet(deckCount);
    }

    public Single<DrawCardResponse> drawCard(String deckId) {
        return endpoints.drawCard(deckId);
    }
}
