package com.example.dagger2.frameworks.dependencyinjection;

import com.example.dagger2.features.launcher.LauncherModule;
import com.example.dagger2.features.launcher.view.LauncherActivity;
import com.example.dagger2.features.launcher.view.LauncherViewModule;
import com.example.dagger2.features.wizard.WizardModule;
import com.example.dagger2.features.wizard.view.WizardActivity;
import com.example.dagger2.features.wizard.view.WizardViewModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {LauncherViewModule.class, LauncherModule.class})
    abstract LauncherActivity bindLauncherActivity();

    @ContributesAndroidInjector(modules = {WizardViewModule.class, WizardModule.class})
    abstract WizardActivity bindWizardActivity();
}
