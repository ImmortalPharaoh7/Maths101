package com.abdallahmeebed.maths101;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.abdallahmeebed.maths101.fragments.BeginnerFragment;
import com.abdallahmeebed.maths101.fragments.BeginnerLifeFragment;
import com.abdallahmeebed.maths101.fragments.CreditsFragment;
import com.abdallahmeebed.maths101.fragments.ExpertFragment;
import com.abdallahmeebed.maths101.fragments.ExpertLifeFragment;
import com.abdallahmeebed.maths101.fragments.InstructionsFragment;
import com.abdallahmeebed.maths101.fragments.IntermediateFragment;
import com.abdallahmeebed.maths101.fragments.IntermediateLifeFragment;
import com.abdallahmeebed.maths101.fragments.NumberQuestionFragment;
import com.abdallahmeebed.maths101.fragments.OptionsFragment;
import com.abdallahmeebed.maths101.fragments.PlayFragment;
import com.abdallahmeebed.maths101.fragments.WelcomeFragment;

public class WelcomeActivity extends AppCompatActivity {


    public static boolean mutedByUser = false;
    NumberQuestionFragment numberQuestionFragment;
    MediaPlayer backgroundMusic;
    ImageView xMark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getFragmentManager();

        // beginTransaction() begins the FragmentTransaction which allows you to add, attach, detach, hide, remove, replace, animate, transition or show fragments

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        WelcomeFragment welcomeFragment = new WelcomeFragment();
        fragmentTransaction.replace(android.R.id.content, welcomeFragment);
        fragmentTransaction.commit();

        backgroundMusic = MediaPlayer.create(this, R.raw.bit8_power);
        backgroundMusic.start();
        backgroundMusic.setLooping(true);

        //setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (backgroundMusic.isPlaying()) {
            backgroundMusic.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!backgroundMusic.isPlaying() && !mutedByUser) {
            backgroundMusic.start();
        }
    }

    //gets the fragments for all the menu items
    public void welcomeButtonPressed(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // to the play menu
        if (view == findViewById(R.id.playButton) || view == findViewById(R.id.backBeginnerButton) || view == findViewById(R.id.backIntermediateButton) || view == findViewById(R.id.backExpertButton) || view == findViewById(R.id.backNumberQuestion) || view == findViewById(R.id.backIncorrectLifeButton)) {
            PlayFragment playFragment = new PlayFragment();
            fragmentTransaction.replace(android.R.id.content, playFragment);

            // to main menu
        } else if (view == findViewById(R.id.backPlayButton) || view == findViewById(R.id.backInstructionsButton) || view == findViewById(R.id.backOptionsButton) || view == findViewById(R.id.backCreditsButton)) {
            WelcomeFragment welcomeFragment = new WelcomeFragment();
            fragmentTransaction.replace(android.R.id.content, welcomeFragment);
        } else if (view == findViewById(R.id.beginnerButton) || view == findViewById(R.id.backBeginnerLifeButton)) {
            BeginnerFragment beginnerFragment = new BeginnerFragment();
            fragmentTransaction.replace(android.R.id.content, beginnerFragment);
        } else if (view == findViewById(R.id.intermediateButton) || view == findViewById(R.id.backIntermediateLifeButton)) {
            IntermediateFragment intermediateFragment = new IntermediateFragment();
            fragmentTransaction.replace(android.R.id.content, intermediateFragment);
        } else if (view == findViewById(R.id.expertButton) || view == findViewById(R.id.backExpertLifeButton)) {
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
        } else if (view == findViewById(R.id.question30Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question30Prompt), 16, R.drawable.question30);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.numberQuestionValidate)) {
            numberQuestionFragment.checkAnswer();
        } else if (view == findViewById(R.id.instructionsButton)) {
            InstructionsFragment instructionsFragment = new InstructionsFragment();
            fragmentTransaction.replace(android.R.id.content, instructionsFragment);
        } else if (view == findViewById(R.id.question31Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question31Prompt), 2.92, R.drawable.question31);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question32Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question32Prompt), 4, R.drawable.question32);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question33Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question33Prompt), 382, R.drawable.question33);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question34Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question34Prompt), 6, R.drawable.question34);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question35Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question35Prompt), 22, R.drawable.question35);
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
        } else if (view == findViewById(R.id.question36Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question36Prompt), 6, R.drawable.question36);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question37Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question37Prompt), 11.52, R.drawable.question37);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question38Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question38Prompt), 21.82, R.drawable.question38);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.secondDegreeEquationButton)) {
            startActivity(new Intent(this, SecondDegreeActivity.class));
        } else if (view == findViewById(R.id.logarithmicEquationButton)) {
            startActivity(new Intent(this, LogarithmicActivity.class));
        } else if (view == findViewById(R.id.powersOfIButton)) {
            startActivity(new Intent(this, PowersIActivity.class));
        } else if (view == findViewById(R.id.proportionalityButton)) {
            startActivity(new Intent(this, ProportionalityActivity.class));
        } else if (view == findViewById(R.id.question20Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question20Prompt), 64, R.drawable.question20);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question21Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question21Prompt), 42, R.drawable.question21);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question22Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question22Prompt), 3.86, R.drawable.question22);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question23Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question23Prompt), 151.15, R.drawable.question23);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question24Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question24Prompt), 500, R.drawable.question24);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question25Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question25Prompt), 10, R.drawable.question25);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question26Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question26Prompt), 1884.12, R.drawable.question26);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question27Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question27Prompt), 56.89, R.drawable.question27);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question28Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question28Prompt), 28, R.drawable.question28);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question10Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question10Prompt), 4, R.drawable.question10);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question11Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question11Prompt), 5, R.drawable.question11);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question12Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question12Prompt), 4, R.drawable.question12);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question13Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question13Prompt), 0.75, R.drawable.question13);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question14Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question14Prompt), 11, R.drawable.question14);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question15Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question15Prompt), 25, R.drawable.question15);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question16Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question16Prompt), 700, R.drawable.question16);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question17Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question17Prompt), 186.48, R.drawable.question17);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.question18Button)) {
            numberQuestionFragment = new NumberQuestionFragment();
            numberQuestionFragment.setupQuestion(getString(R.string.question18Prompt), 204, R.drawable.question18);
            fragmentTransaction.replace(android.R.id.content, numberQuestionFragment);
        } else if (view == findViewById(R.id.optionsButton)) {
            OptionsFragment optionsFragment = new OptionsFragment();
            fragmentTransaction.replace(android.R.id.content, optionsFragment);
        } else if (view == findViewById(R.id.creditsButton)) {
            CreditsFragment creditsFragment = new CreditsFragment();
            fragmentTransaction.replace(android.R.id.content, creditsFragment);
        }
        fragmentTransaction.commit();
    }

    public void muteBackgroundMusic(View view) {
        xMark = findViewById(R.id.xMarkImageView);
        if (backgroundMusic.isPlaying()) {
            backgroundMusic.pause();
            mutedByUser = true;
            xMark.setVisibility(View.VISIBLE);
        } else {
            backgroundMusic.start();
            mutedByUser = false;
            xMark.setVisibility(View.INVISIBLE);
        }
    }
}
