package com.example.dagger2.frameworks.reactivex;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SchedulersFacade {

    @Inject
    SchedulersFacade() {

    }

    public Scheduler io() {
        return Schedulers.io();
    }

    public Scheduler computation() {
        return Schedulers.computation();
    }

    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

}
