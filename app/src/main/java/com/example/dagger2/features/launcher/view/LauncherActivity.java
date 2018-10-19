package com.example.dagger2.features.launcher.view;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.dagger2.R;
import com.example.dagger2.features.launcher.LauncherContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class LauncherActivity extends AppCompatActivity implements LauncherContract.View {

    @BindView(R.id.launcher_cb_eula)
    CheckBox checkBoxEula;
    @BindView(R.id.launcher_btn_next)
    Button btnNext;

    @Inject
    LauncherContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher_activity);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }

    @OnClick(R.id.launcher_btn_close)
    public void onCloseButtonClicked() {
        presenter.clickedOnClose();
    }

    @OnClick(R.id.launcher_btn_next)
    public void onNextButtonClicked() {
        presenter.clickedOnNext();
    }

    @OnClick(R.id.launcher_cb_eula)
    public void onEulaCheckBoxClicked() {
        presenter.clickedOnEula();
    }

    @Override
    public void enableNextButton(boolean enable) {
        btnNext.setEnabled(enable);
    }

    @Override
    public void showEula(String eula) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.eula_title)
               .setMessage(eula)
               .setPositiveButton(R.string._accept,
                                  (dialog, which) -> presenter.acceptEula())
               .setNegativeButton(R.string._decline, (dialog, which) -> presenter.declineEula());

        builder.create().show();
    }

    @Override
    public void finishApp() {
        finish();
    }

    @Override
    public void fireIntent(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void checkEulaCheckbox(boolean check) {
        checkBoxEula.setChecked(check);
    }
}
