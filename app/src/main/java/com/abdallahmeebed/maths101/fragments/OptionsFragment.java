package com.abdallahmeebed.maths101.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.abdallahmeebed.maths101.R;

import static com.abdallahmeebed.maths101.WelcomeActivity.mutedByUser;


public class OptionsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.options_fragment, container, false);
        if (mutedByUser) {
            ImageView xMark = view.findViewById(R.id.xMarkImageView);
            xMark.setVisibility(View.VISIBLE);
        }
        return view;
    }
}
