package jblejder.cards;

import android.app.Application;

import jblejder.cards.shared.dagger.AppModule;
import jblejder.cards.shared.dagger.DaggerGlobalComponent;
import jblejder.cards.shared.dagger.GlobalComponent;

public class GlobalApplication extends Application {

    GlobalComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public GlobalComponent getComponent() {
        if (component == null) {
            component = DaggerGlobalComponent
                    .builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return component;
    }
}
