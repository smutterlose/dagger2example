package com.example.dagger2.frameworks.dependencyinjection;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;

//TODO Highly expiremental not working!!!

@Module
public abstract class BaseActivityModule {

    @Binds
    abstract Activity activity(AppCompatActivity appCompatActivity);

    @Binds
    abstract Context activityContext(Activity activity);
}
