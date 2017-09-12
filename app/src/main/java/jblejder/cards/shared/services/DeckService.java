package jblejder.cards.shared.services;


import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
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
        return endpoints.getNewSet(deckCount)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<DrawCardResponse> drawCard(String deckId, int cards) {
        return endpoints.drawCard(deckId, cards)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
