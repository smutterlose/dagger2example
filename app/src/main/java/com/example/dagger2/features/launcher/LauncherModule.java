package com.example.dagger2.features.launcher;

import android.content.Context;

import com.example.dagger2.frameworks.reactivex.SchedulersFacade;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class LauncherModule {

    @Provides
    LauncherContract.Presenter providePresenter(LauncherContract.View view,
                                                LauncherContract.Interactor interactor,
                                                SchedulersFacade schedulersFacade,
                                                @Named("ApplicationContext") Context context) {
        return new LauncherPresenter(view, interactor, schedulersFacade, context);
    }

    @Provides
    LauncherContract.Interactor provideInteractor(@Named("ApplicationContext") Context context,
                                                  EulaRepository eulaRepository) {
        return new LauncherInteractor(context, eulaRepository);
    }
}
