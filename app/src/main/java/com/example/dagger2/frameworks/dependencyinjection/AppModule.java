package com.example.dagger2.frameworks.dependencyinjection;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.dagger2.App;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

    @Provides
    @Named("ApplicationContext")
    Context provideApplicationContext(App application) {
        return application.getApplicationContext();
    }

    @Provides
    SharedPreferences provideSharedPreference(App application) {
        return PreferenceManager.getDefaultSharedPreferences(application.getApplicationContext());
    }
}
