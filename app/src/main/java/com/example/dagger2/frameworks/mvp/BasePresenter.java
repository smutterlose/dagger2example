package com.example.dagger2.frameworks.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V, I> implements IBasePresenter {

    protected final V view;
    protected final I interactor;

    private CompositeDisposable disposables = new CompositeDisposable();

    protected BasePresenter(V view, I interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        disposables.clear();
    }

    protected void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }
}
