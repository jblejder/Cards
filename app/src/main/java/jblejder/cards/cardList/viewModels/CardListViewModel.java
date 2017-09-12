package jblejder.cards.cardList.viewModels;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;

import javax.inject.Inject;

import io.reactivex.Single;
import jblejder.cards.shared.Constants;
import jblejder.cards.shared.services.DeckService;
import jblejder.cards.shared.api.DrawCardResponse;
import jblejder.cards.shared.models.Card;

public class CardListViewModel {

    public ObservableBoolean    hasMoreCards;
    public ObservableList<Card> cards;

    private final DeckService service;

    private String setId;

    {
        cards = new ObservableArrayList<>();
        hasMoreCards = new ObservableBoolean(true);
    }

    @Inject
    public CardListViewModel(DeckService service) {
        this.service = service;
    }

    public Single<DrawCardResponse> drawCard() {
        return drawCards(1);
    }

    public Single<DrawCardResponse> loadInitialCards() {
        return drawCards(Constants.INITIAL_CARDS);
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    private Single<DrawCardResponse> drawCards(int count) {
        return service.drawCard(setId, count)
                .doOnSuccess(drawCardResponse -> {
                    cards.addAll(drawCardResponse.cards);
                });
    }
}
