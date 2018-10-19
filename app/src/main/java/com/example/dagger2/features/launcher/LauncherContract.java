package com.example.dagger2.features.launcher;

import android.content.Intent;

import com.example.dagger2.frameworks.mvp.IBaseInteractor;
import com.example.dagger2.frameworks.mvp.IBasePresenter;

import io.reactivex.Single;

public interface LauncherContract {

    interface View {

        void finishApp();
        void enableNextButton(boolean enable);
        void fireIntent(Intent intent);
        void checkEulaCheckbox(boolean checked);
        void showEula(String eula);
    }

    interface Presenter extends IBasePresenter {

        void clickedOnClose();
        void clickedOnNext();
        void clickedOnEula();
        void acceptEula();
        void declineEula();
    }

    interface Interactor extends IBaseInteractor {

        Single<String> loadEula();
        void saveEulaAcceptanceState(boolean accepted);
        Single<Boolean> isEulaAccepted();
    }

}
