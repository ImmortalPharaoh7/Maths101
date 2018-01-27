package com.abdallahmeebed.maths101;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.abdallahmeebed.maths101.WelcomeActivity.mutedByUser;

public class SecondDegreeActivity extends AppCompatActivity {

    private final int BOUNDARYAC = 20, RANGEAC = -10, BOUNDARYB = 40, RANGEB = -20;
    TextView questionTextView;
    MediaPlayer algorithmMusic;
    private int a, b, c, numberOfSolutions; // just like in class
    private double a1, a2; //answers

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_degree);

        algorithmMusic = MediaPlayer.create(this, R.raw.bit8_summer);
        if (!mutedByUser) algorithmMusic.start();
        algorithmMusic.setLooping(true);

        questionTextView = findViewById(R.id.secondDegreeLine);
        genNewNumbers();
    }

    public void genNewNumbers() {
        Random random = new Random();
        a = random.nextInt(BOUNDARYAC) + RANGEAC;
        b = random.nextInt(BOUNDARYB) + RANGEB;
        c = random.nextInt(BOUNDARYAC) + RANGEAC;

        checkA();
        questionTextView.setText(String.format(getString(R.string.secondDegreeLine), a, b, c));

        calculateSecondDegreeSolutions();
    }

    public void checkA() {
        if (a == 0) {
            Random random = new Random();
            a = random.nextInt(BOUNDARYAC) + RANGEAC;
            checkA();
        }
    }

    public void calculateSecondDegreeSolutions() {
        int delta = (int) Math.pow(b, 2) - 4 * a * c;
        if (delta > 0) {
            numberOfSolutions = 2;
            a1 = Math.round(100.0 * (-b - Math.sqrt(delta)) / 2 * a) / 100.0;
            a2 = Math.round(100.0 * (-b + Math.sqrt(delta)) / 2 * a) / 100.0;
        } else if (delta == 0) {
            numberOfSolutions = 1;
            a1 = Math.round(100.0 * (-b) / 2 * a) / 100.0;
            a2 = a1;
        } else {
            numberOfSolutions = 0;
        }
    }

    public void checkAnswer(View view) {
        try {
            EditText answer1EditText = findViewById(R.id.secondDegree1EditText);
            EditText answer2EditText = findViewById(R.id.secondDegree2EditText);

            double user1Ans = Double.parseDouble(answer1EditText.getText().toString());
            double user2Ans = Double.parseDouble(answer2EditText.getText().toString());

            switch (numberOfSolutions) {
                case 2:
                    if (user1Ans == a1) {
                        if (user2Ans == a2) {
                            Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
                        }
                    } else if (user1Ans == a2) {
                        if (user2Ans == a1) {
                            Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(this, String.format(getString(R.string.secondDegree2Incorrect), a1, a2), Toast.LENGTH_LONG).show();
                    }
                    break;
                case 1:
                    if (user1Ans == user2Ans && user1Ans == a1) {
                        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, String.format(getString(R.string.secondDegree1Incorrect), a1), Toast.LENGTH_LONG).show();
                    }
                    break;
                default:
                    Toast.makeText(this, getString(R.string.secondDegree0Incorrect), Toast.LENGTH_SHORT).show();
            }
            genNewNumbers();
            answer1EditText.setText("");
            answer2EditText.setText("");
        } catch (Exception e) {
            System.out.println(e.toString());
            Toast.makeText(this, getString(R.string.emptyNumber), Toast.LENGTH_SHORT).show();
        }
    }

    public void noSolutionsButton(View view) {
        if (numberOfSolutions == 0) {
            Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
        } else {
            switch (numberOfSolutions) {
                case 1:
                    Toast.makeText(this, String.format(getString(R.string.secondDegree1Incorrect), a1), Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    Toast.makeText(this, String.format(getString(R.string.secondDegree2Incorrect), a1, a2), Toast.LENGTH_LONG).show();
                    break;
            }
        }
        EditText answer1EditText = findViewById(R.id.secondDegree1EditText);
        EditText answer2EditText = findViewById(R.id.secondDegree2EditText);

        genNewNumbers();
        answer1EditText.setText("");
        answer2EditText.setText("");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (algorithmMusic.isPlaying()) {
            algorithmMusic.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!algorithmMusic.isPlaying() && !mutedByUser) {
            algorithmMusic.start();
        }
    }
}
