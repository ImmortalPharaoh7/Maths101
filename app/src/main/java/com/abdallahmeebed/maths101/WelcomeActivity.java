package com.abdallahmeebed.maths101;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.abdallahmeebed.maths101.fragments.BeginnerFragment;
import com.abdallahmeebed.maths101.fragments.BeginnerLifeFragment;
import com.abdallahmeebed.maths101.fragments.ExpertFragment;
import com.abdallahmeebed.maths101.fragments.ExpertLifeFragment;
import com.abdallahmeebed.maths101.fragments.IntermediateFragment;
import com.abdallahmeebed.maths101.fragments.NumberQuestionFragment;
import com.abdallahmeebed.maths101.fragments.PlayFragment;
import com.abdallahmeebed.maths101.fragments.WelcomeFragment;

public class  WelcomeActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getFragmentManager();

        // beginTransaction() begins the FragmentTransaction which allows you to add, attach, detach, hide, remove, replace, animate, transition or show fragments

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        WelcomeFragment welcomeFragment = new WelcomeFragment();
        fragmentTransaction.replace(android.R.id.content, welcomeFragment);
        fragmentTransaction.commit();

        //setContentView(R.layout.activity_welcome);
    }

    NumberQuestionFragment numberQuestionFragment;

    //gets the fragments for all the menu items
    public void welcomeButtonPressed(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // to the play menu
        if (view == findViewById(R.id.playButton) || view == findViewById(R.id.backBeginnerButton)|| view == findViewById(R.id.backIntermediateButton) || view == findViewById(R.id.backExpertButton) || view == findViewById(R.id.backNumberQuestion)){
            PlayFragment playFragment = new PlayFragment();
            fragmentTransaction.replace(android.R.id.content, playFragment);

        // to main menu
        }else if (view == findViewById(R.id.backPlayButton)){
            WelcomeFragment welcomeFragment = new WelcomeFragment();
            fragmentTransaction.replace(android.R.id.content, welcomeFragment);
        }else if (view == findViewById(R.id.beginnerButton)){
            BeginnerFragment beginnerFragment = new BeginnerFragment();
            fragmentTransaction.replace(android.R.id.content, beginnerFragment);
        }else if (view == findViewById(R.id.intermediateButton)){
            IntermediateFragment intermediateFragment = new IntermediateFragment();
            fragmentTransaction.replace(android.R.id.content, intermediateFragment);
        }else if (view == findViewById(R.id.expertButton)){
            ExpertFragment expertFragment = new ExpertFragment();
            fragmentTransaction.replace(android.R.id.content, expertFragment);
        } else if (view == findViewById(R.id.beginnerLifeButton)) {
            BeginnerLifeFragment beginnerLifeFragment = new BeginnerLifeFragment();
            fragmentTransaction.replace(android.R.id.content, beginnerLifeFragment);
        } else if (view == findViewById(R.id.intermediateLifeButton)) {
            IntermediateFragment intermediateFragment = new IntermediateFragment();
            fragmentTransaction.replace(android.R.id.content, intermediateFragment);
        } else if (view == findViewById(R.id.expertLifeButton)) {
            ExpertLifeFragment expertLifeFragment = new ExpertLifeFragment();
            fragmentTransaction.replace(android.R.id.content, expertLifeFragment);
        } else if (view == findViewById(R.id.question1Button)){
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question30Prompt), 16);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.numberQuestionValidate)){
            numberQuestionFragment.checkAnswer();
        }

        fragmentTransaction.commit();
    }
}
