package tech42.sathish.realmexample.dagger;

import javax.inject.Singleton;

import dagger.Component;
import tech42.sathish.realmexample.BasicActivity;

/**
 * Created by lenovo on 7/2/17.
 */
@Singleton @Component (modules = {AppModule.class})
public interface AppComponent {

    void inject(DaggerApplication daggerApplication);

    void inject(BasicActivity basicActivity);
}
