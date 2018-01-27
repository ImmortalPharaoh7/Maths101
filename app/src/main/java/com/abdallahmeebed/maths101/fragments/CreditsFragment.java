package com.abdallahmeebed.maths101.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abdallahmeebed.maths101.R;


public class CreditsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.credits_fragment, container, false);
        TextView textView = view.findViewById(R.id.creditsTextView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return view;
    }
}
