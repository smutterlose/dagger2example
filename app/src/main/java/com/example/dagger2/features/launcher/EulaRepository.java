package com.example.dagger2.features.launcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.StringRes;
import android.util.Log;

import com.example.dagger2.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.inject.Inject;

class EulaRepository {

    private static final String EULA_ASSET_FILE = "eula.html";

    private static final String PREF_KEY_EULA_ACCEPTANCE_STATE = "eulaAcceptanceState";

    private final SharedPreferences preferences;

    @Inject
    EulaRepository(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @StringRes
    public int getTitle() {
        return R.string.eula_title;
    }

    String getEulaText(Context context) {
        return readEulaAsset(context);
    }

    private String readEulaAsset(Context context) {
        StringBuilder eula = new StringBuilder();
        try (InputStream inputStream = context.getAssets().open(EULA_ASSET_FILE)) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    inputStream,
                    "UTF-8"))) {

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    eula.append(line);
                }

            } catch (IOException e) {
                Log.e(getClass().getName(), e.getMessage(), e);
            }
        } catch (IOException e) {
            Log.e(getClass().getName(), e.getMessage(), e);
        }
        return eula.toString();
    }

    void saveEulaAcceptanceState(boolean eulaAccepted) {
        preferences.edit().putBoolean(PREF_KEY_EULA_ACCEPTANCE_STATE, eulaAccepted).apply();
    }

    boolean isEulaAccepted() {
        return preferences.getBoolean(PREF_KEY_EULA_ACCEPTANCE_STATE, false);
    }
}
