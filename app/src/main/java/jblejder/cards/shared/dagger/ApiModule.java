package jblejder.cards.shared.dagger;

import dagger.Module;
import dagger.Provides;
import jblejder.cards.shared.api.ApiEndpoints;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    public ApiEndpoints getEndpoints(Retrofit retrofit) {
        return retrofit.create(ApiEndpoints.class);
    }
}
