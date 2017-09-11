package jblejder.cards.chooseCount.viewModels;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import javax.inject.Inject;

import jblejder.cards.shared.configurations.Constants;

import static jblejder.cards.shared.configurations.Constants.*;

public class ChooseCountViewModel {

    public final ObservableField<Integer> deckCount;
    public final ObservableBoolean        leftArrowVisible;
    public final ObservableBoolean        rightArrowVisible;

    {
        deckCount = new ObservableField<>(1);
        leftArrowVisible = new ObservableBoolean();
        rightArrowVisible = new ObservableBoolean();
    }

    @Inject
    public ChooseCountViewModel() {
        updateArrows();
    }

    public void increment() {
        if (deckCount.get() < Constants.MAX_DECKS) {
            deckCount.set(deckCount.get() + 1);
            updateArrows();
        }
    }

    public void decrement() {
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
