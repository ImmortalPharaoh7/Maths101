package com.abdallahmeebed.maths101.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abdallahmeebed.maths101.R;


public class InstructionsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.instructions_fragment, container, false);
        TextView textView = view.findViewById(R.id.instructionsTextView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }
}
