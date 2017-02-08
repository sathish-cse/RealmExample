package tech42.sathish.realmexample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import tech42.sathish.realmexample.dagger.DaggerApplication;

/**
 * Created by lenovo on 7/2/17.
 */

public class BasicActivity extends AppCompatActivity {

    @Inject public Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((DaggerApplication) getApplication()).getAppComponent().inject(this);
    }
}
