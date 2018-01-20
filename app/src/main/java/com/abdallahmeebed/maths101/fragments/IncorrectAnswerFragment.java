package com.abdallahmeebed.maths101.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.abdallahmeebed.maths101.R;


public class IncorrectAnswerFragment extends Fragment {

    private int answerImageId = 0;


    //setting up the answer in an image form, won't be translatable though :(
    public void setAnswerImage(int answerImageId){
        this.answerImageId = answerImageId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.incorrect_answer_fragment, container, false);
        ImageView answerImage = view.findViewById(R.id.lifeNumberAnswer);
        if (answerImageId != 0){
            answerImage.setImageResource(answerImageId);
        }

        return view;
    }
}
