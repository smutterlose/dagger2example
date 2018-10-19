package com.example.dagger2.features.wizard.view;

import com.example.dagger2.features.wizard.WizardContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class WizardViewModule {

    @Binds
    abstract WizardContract.View provideWizardView(WizardActivity wizardActivity);
}
