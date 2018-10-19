package com.example.dagger2.features.wizard.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.dagger2.R;
import com.example.dagger2.features.wizard.WizardContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class WizardActivity extends AppCompatActivity implements WizardContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    WizardContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_activity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

}
