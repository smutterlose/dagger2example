package com.example.dagger2.features.wizard.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dagger2.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class PoliciesFragment extends Fragment {

    public PoliciesFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.wizard_fragment_policies, container, false);
    }
}
