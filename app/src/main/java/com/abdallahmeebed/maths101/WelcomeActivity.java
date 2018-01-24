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
import com.abdallahmeebed.maths101.fragments.InstructionsFragment;
import com.abdallahmeebed.maths101.fragments.IntermediateFragment;
import com.abdallahmeebed.maths101.fragments.IntermediateLifeFragment;
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
        if (view == findViewById(R.id.playButton) || view == findViewById(R.id.backBeginnerButton)|| view == findViewById(R.id.backIntermediateButton) || view == findViewById(R.id.backExpertButton) || view == findViewById(R.id.backNumberQuestion) || view == findViewById(R.id.backIncorrectLifeButton)){
            PlayFragment playFragment = new PlayFragment();
            fragmentTransaction.replace(android.R.id.content, playFragment);

        // to main menu
        }else if (view == findViewById(R.id.backPlayButton) || view == findViewById(R.id.backInstructionsButton)){
            WelcomeFragment welcomeFragment = new WelcomeFragment();
            fragmentTransaction.replace(android.R.id.content, welcomeFragment);
        }else if (view == findViewById(R.id.beginnerButton) || view == findViewById(R.id.backBeginnerLifeButton)){
            BeginnerFragment beginnerFragment = new BeginnerFragment();
            fragmentTransaction.replace(android.R.id.content, beginnerFragment);
        }else if (view == findViewById(R.id.intermediateButton) || view == findViewById(R.id.backIntermediateLifeButton)){
            IntermediateFragment intermediateFragment = new IntermediateFragment();
            fragmentTransaction.replace(android.R.id.content, intermediateFragment);
        }else if (view == findViewById(R.id.expertButton) || view == findViewById(R.id.backExpertLifeButton)){
            ExpertFragment expertFragment = new ExpertFragment();
            fragmentTransaction.replace(android.R.id.content, expertFragment);
        } else if (view == findViewById(R.id.beginnerLifeButton)) {
            BeginnerLifeFragment beginnerLifeFragment = new BeginnerLifeFragment();
            fragmentTransaction.replace(android.R.id.content, beginnerLifeFragment);
        } else if (view == findViewById(R.id.intermediateLifeButton)) {
            IntermediateLifeFragment intermediateLifeFragment = new IntermediateLifeFragment();
            fragmentTransaction.replace(android.R.id.content, intermediateLifeFragment);
        } else if (view == findViewById(R.id.expertLifeButton)) {
            ExpertLifeFragment expertLifeFragment = new ExpertLifeFragment();
            fragmentTransaction.replace(android.R.id.content, expertLifeFragment);
        } else if (view == findViewById(R.id.question30Button)){
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question30Prompt), 16, R.drawable.question30);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.numberQuestionValidate)){
            numberQuestionFragment.checkAnswer();
        } else if (view == findViewById(R.id.instructionsButton)){
            InstructionsFragment instructionsFragment = new InstructionsFragment();
            fragmentTransaction.replace(android.R.id.content, instructionsFragment);
        } else if (view == findViewById(R.id.question31Button)){
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question31Prompt), 2.92);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question32Button)){
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question32Prompt), 4);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question33Button)){
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question33Prompt), 382);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question34Button)){
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question34Prompt), 6);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question35Button)){
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question35Prompt), 22);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.greatestCommonDividerButton)) {
            startActivity(new Intent(this, GCDActivity.class));
        } else if (view == findViewById(R.id.fractionsButton)) {
            startActivity(new Intent(this, FractionsActivity.class));
        } else if (view == findViewById(R.id.firstDegreeEquationButton)) {
            startActivity(new Intent(this, FirstDegreeActivity.class));
        } else if (view == findViewById(R.id.arithmeticProgressionButton)) {
            startActivity(new Intent(this, ArithmeticProgressionActivity.class));
        } else if (view == findViewById(R.id.geometricProgressionButton)) {
            startActivity(new Intent(this, GeometricProgressionActivity.class));
        }
        fragmentTransaction.commit();
    }
}
