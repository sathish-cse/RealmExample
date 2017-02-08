package tech42.sathish.realmexample.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lenovo on 7/2/17.
 */

@Module
public class AppModule {

    private final DaggerApplication daggerApplication;

    public AppModule(DaggerApplication daggerApplication)
    {
        this.daggerApplication = daggerApplication;
    }

    @Provides @Singleton
    Context providesApplicationContext()
    {
        return daggerApplication;
    }
}
