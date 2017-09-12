package jblejder.cards.chooseCount.viewModels;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import javax.inject.Inject;

import io.reactivex.Single;
import jblejder.cards.shared.services.DeckService;
import jblejder.cards.shared.api.NewSetResponse;

import static jblejder.cards.shared.Constants.*;

public class ChooseCountViewModel {

    // TODO: 11.09.2017 Block UI interaction while loading, show indicator
    public final ObservableBoolean loading;

    public final ObservableField<Integer> deckCount;
    public final ObservableBoolean        leftArrowVisible;
    public final ObservableBoolean        rightArrowVisible;

    private final DeckService service;

    {
        loading = new ObservableBoolean();
        deckCount = new ObservableField<>(1);
        leftArrowVisible = new ObservableBoolean();
        rightArrowVisible = new ObservableBoolean();
    }

    @Inject
    public ChooseCountViewModel(DeckService service) {
        this.service = service;
        updateArrows();
    }

    public Single<NewSetResponse> selectSetSize() {
        if (loading.get()) {
            return Single.error(new IllegalStateException("already running"));
        }
        loading.set(true);
        return service
                .getNewCardSet(deckCount.get())
                .doFinally(() -> {
                    loading.set(false);
                });
    }

    public void increment() {
        if (loading.get()) {
            return;
        }

        if (deckCount.get() < MAX_DECKS) {
            deckCount.set(deckCount.get() + 1);
            updateArrows();
        }
    }

    public void decrement() {
        if (loading.get()) {
            return;
        }

        if (deckCount.get() > 1) {
            deckCount.set(deckCount.get() - 1);
            updateArrows();
        }
    }

    private void updateArrows() {
        Integer count = deckCount.get();
        leftArrowVisible.set(count > 1);
        rightArrowVisible.set(count < MAX_DECKS);
    }
}
