package com.example.dagger2.features.launcher;

import android.content.Context;

import com.example.dagger2.frameworks.mvp.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Single;

public class LauncherInteractor extends BaseInteractor implements LauncherContract.Interactor {

    private final Context context;
    private final EulaRepository eulaRepository;

    @Inject
    LauncherInteractor(Context context, EulaRepository eulaRepository) {
        this.context = context;
        this.eulaRepository = eulaRepository;
    }

    @Override
    public Single<String> loadEula() {
        return Single.just(eulaRepository.getEulaText(context));
    }

    @Override
    public void saveEulaAcceptanceState(boolean accepted) {
        eulaRepository.saveEulaAcceptanceState(accepted);
    }

    @Override
    public Single<Boolean> isEulaAccepted() {
        return Single.just(eulaRepository.isEulaAccepted());
    }
}
