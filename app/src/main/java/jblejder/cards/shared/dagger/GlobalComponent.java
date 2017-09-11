package jblejder.cards.shared.dagger;

import dagger.Component;
import jblejder.cards.chooseCount.fragments.ChooseCountFragment;

@Component(modules = {
        AppModule.class,
        RetrofitModule.class,
        ApiModule.class
})
public interface GlobalComponent {

    void inject(ChooseCountFragment chooseCountFragment);
}
