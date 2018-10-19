package com.example.dagger2.features.launcher;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.example.dagger2.features.wizard.view.WizardActivity;
import com.example.dagger2.frameworks.mvp.BasePresenter;
import com.example.dagger2.frameworks.reactivex.SchedulersFacade;

import io.reactivex.Single;

class LauncherPresenter extends BasePresenter<LauncherContract.View, LauncherContract.Interactor> implements LauncherContract.Presenter, DialogInterface.OnClickListener {

    private final Context context;
    private final SchedulersFacade schedulerFacade;

    LauncherPresenter(LauncherContract.View view,
                      LauncherContract.Interactor interactor,
                      SchedulersFacade schedulerFacade,
                      Context context) {
        super(view, interactor);
        this.context = context;
        this.schedulerFacade = schedulerFacade;
    }

    @Override
    public void start() {
        super.start();
        notifyViewAboutEulaAcceptance(interactor.isEulaAccepted());
    }

    @Override
    public void clickedOnClose() {
        view.finishApp();
    }

    @Override
    public void clickedOnNext() {
        Intent intent = new Intent(context, WizardActivity.class);
        addDisposable(Single.just(intent)
                            .subscribeOn(schedulerFacade.io())
                            .observeOn(schedulerFacade.ui())
                            .subscribe(view::fireIntent));
    }

    @Override
    public void clickedOnEula() {
        addDisposable(interactor.loadEula()
                                .subscribeOn(schedulerFacade.io())
                                .observeOn(schedulerFacade.ui())
                                .subscribe(view::showEula));
    }

    @Override
    public void acceptEula() {
        interactor.saveEulaAcceptanceState(true);
        notifyViewAboutEulaAcceptance(interactor.isEulaAccepted());
    }

    @Override
    public void declineEula() {
        interactor.saveEulaAcceptanceState(false);
        notifyViewAboutEulaAcceptance(interactor.isEulaAccepted());
    }

    @Override
    public void onClick(DialogInterface dialog, int btnId) {
        boolean isEulaAccepted = btnId == DialogInterface.BUTTON_POSITIVE;
        interactor.saveEulaAcceptanceState(isEulaAccepted);
    }

    private void notifyViewAboutEulaAcceptance(Single<Boolean> eulaAcceptedSingle) {
        addDisposable(eulaAcceptedSingle.subscribeOn(schedulerFacade.io())
                                        .observeOn(schedulerFacade.ui())
                                        .subscribe(view::checkEulaCheckbox));
        addDisposable(eulaAcceptedSingle.subscribeOn(schedulerFacade.io())
                                        .observeOn(schedulerFacade.ui())
                                        .subscribe(view::enableNextButton));
    }


}
