package jblejder.cards.shared.dagger;

import dagger.Component;
import jblejder.cards.cardList.fragments.CardListFragment;
import jblejder.cards.chooseCount.fragments.ChooseCountFragment;

@Component(modules = {
        AppModule.class,
        RetrofitModule.class,
        ApiModule.class,
        RecognitionModule.class
})
public interface GlobalComponent {

    void inject(ChooseCountFragment chooseCountFragment);

    void inject(CardListFragment cardListFragment);
}
