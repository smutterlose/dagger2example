package com.example.dagger2.features.launcher.view;

import android.content.Context;

import com.example.dagger2.features.launcher.LauncherContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class LauncherViewModule {

    private final Context context;

    protected LauncherViewModule(Context context) {
        this.context = context;
    }

    @Binds
    abstract LauncherContract.View provideLauncherView(LauncherActivity launcherActivity);
}
