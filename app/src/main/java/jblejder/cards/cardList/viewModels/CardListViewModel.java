package jblejder.cards.cardList.viewModels;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;

import javax.inject.Inject;

import io.reactivex.Single;
import jblejder.cards.shared.Constants;
import jblejder.cards.shared.api.DrawCardResponse;
import jblejder.cards.shared.cardHandRecognition.Hand;
import jblejder.cards.shared.models.Card;
import jblejder.cards.shared.services.DeckService;
import jblejder.cards.shared.services.RecognitionService;

public class CardListViewModel {

    public ObservableBoolean drawingCard;

    public ObservableBoolean    hasMoreCards;
    public ObservableList<Card> cards;
    public ObservableList<Hand> hands;

    private final DeckService        service;
    private final RecognitionService recognitionService;

    private String setId;

    {
        cards = new ObservableArrayList<>();
        hands = new ObservableArrayList<>();
        hasMoreCards = new ObservableBoolean(true);
        drawingCard = new ObservableBoolean();
    }

    @Inject
    public CardListViewModel(DeckService service, RecognitionService recognitionService) {
        this.service = service;
        this.recognitionService = recognitionService;
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
                .doOnSubscribe(disposable -> drawingCard.set(true))
                .doOnSuccess(drawCardResponse -> {
                    cards.addAll(drawCardResponse.cards);
                }).flatMap(drawCardResponse -> recognitionService.recognise(cards).doOnSuccess(result -> {
                    hands.clear();
                    hands.addAll(result);
                }).map(v -> drawCardResponse))
                .doFinally(() -> drawingCard.set(false));
    }
}
