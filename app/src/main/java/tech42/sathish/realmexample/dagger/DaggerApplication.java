package tech42.sathish.realmexample.dagger;

import android.app.Application;

/**
 * Created by lenovo on 7/2/17.
 */

public class DaggerApplication extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

        appComponent.inject(this);

    }

    public AppComponent getAppComponent()
    {
        return appComponent;
    }
}
