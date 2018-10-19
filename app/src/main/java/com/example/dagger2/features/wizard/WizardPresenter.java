package com.example.dagger2.features.wizard;

import com.example.dagger2.frameworks.mvp.BasePresenter;
import com.example.dagger2.frameworks.reactivex.SchedulersFacade;

class WizardPresenter extends BasePresenter<WizardContract.View, WizardContract.Interactor> implements WizardContract.Presenter {

    private final SchedulersFacade schedulerFacade;

    WizardPresenter(WizardContract.View view,
                    WizardContract.Interactor interactor,
                    SchedulersFacade schedulersFacade) {
        super(view, interactor);
        this.schedulerFacade = schedulersFacade;
    }
}
