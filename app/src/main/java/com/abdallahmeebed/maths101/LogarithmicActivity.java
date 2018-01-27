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

public class LogarithmicActivity extends AppCompatActivity {

    private final int BOUNDARYAB = 20, RANGEAB = -10, BOUNDARYC = 10;
    TextView questionTextView;
    MediaPlayer algorithmMusic;
    private int a, b, c; // a= coefficient, b = second number, c = other number
    private double aAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logarithmic);

        algorithmMusic = MediaPlayer.create(this, R.raw.bit8_summer);
        if (!mutedByUser) algorithmMusic.start();
        algorithmMusic.setLooping(true);

        questionTextView = findViewById(R.id.logarithmicLine);
        genNewNumbers();
    }

    public void genNewNumbers() {
        Random random = new Random();
        a = random.nextInt(BOUNDARYAB) + RANGEAB;
        b = random.nextInt(BOUNDARYAB) + RANGEAB;
        c = random.nextInt(BOUNDARYC) + 1;

        questionTextView.setText(String.format(getString(R.string.logarithmicLine), a, b, c));

        checkA();

        aAns = Math.round(100.0 * ((Math.pow(2, c) - b) / a)) / 100.0;
    }

    public void checkA() {
        if (a == 0) {
            Random random = new Random();
            a = random.nextInt(BOUNDARYAB) + RANGEAB;
            checkA();
        }
    }

    public void checkAnswer(View view) {
        try {
            EditText answerEditText = findViewById(R.id.logarithmicAnswer);
            double userAns = Double.parseDouble(answerEditText.getText().toString());

            if (userAns == aAns) {
                Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, String.format(getString(R.string.logarithmicIncorrect), aAns), Toast.LENGTH_LONG).show();
            }
            genNewNumbers();
            answerEditText.setText("");
        } catch (Exception e) {
            System.out.println(e.toString());
            Toast.makeText(this, getString(R.string.emptyNumber), Toast.LENGTH_SHORT).show();
        }
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
