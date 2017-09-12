package jblejder.cards.cardList.viewModels;

import android.databinding.ObservableField;

public class CardItemViewModel {
    public final ObservableField<String> image;

    {
        image = new ObservableField<>();
    }
}
