package com.example.dagger2.features.wizard;

import com.example.dagger2.frameworks.reactivex.SchedulersFacade;

import dagger.Module;
import dagger.Provides;

@Module
public class WizardModule {

    @Provides
    WizardContract.Presenter providePresenter(WizardContract.View view,
                                              WizardContract.Interactor interactor,
                                              SchedulersFacade schedulersFacade) {
        return new WizardPresenter(view, interactor, schedulersFacade);
    }

    @Provides
    WizardContract.Interactor provideInteractor() {
        return new WizardInteractor();
    }

}
