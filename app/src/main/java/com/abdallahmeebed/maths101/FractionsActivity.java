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

public class FractionsActivity extends AppCompatActivity {

    private final int FRACTIONS_BOUNDARY = 20;
    TextView num1TextView, denum1TextView, num2TextView, denum2TextView;
    MediaPlayer algorithmMusic;
    private int num1, denum1, num2, denum2, numAns, denumAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fractions);

        algorithmMusic = MediaPlayer.create(this, R.raw.bit8_summer);
        if (!mutedByUser) algorithmMusic.start();
        algorithmMusic.setLooping(true);

        num1TextView = findViewById(R.id.numerator1Fractions);
        denum1TextView = findViewById(R.id.denumerator1Fractions);
        num2TextView = findViewById(R.id.numerator2Fractions);
        denum2TextView = findViewById(R.id.denumerator2Fractions);
        genNewNumbers();
    }

    public void genNewNumbers() {
        Random random = new Random();

        num1 = random.nextInt(FRACTIONS_BOUNDARY) + 1;
        num2 = random.nextInt(FRACTIONS_BOUNDARY) + 1;
        denum1 = random.nextInt(FRACTIONS_BOUNDARY) + 1;
        denum2 = random.nextInt(FRACTIONS_BOUNDARY) + 1;


        num1TextView.setText(String.valueOf(num1));
        denum1TextView.setText(String.valueOf(denum1));
        num2TextView.setText(String.valueOf(num2));
        denum2TextView.setText(String.valueOf(denum2));

        int gcd = GCDActivity.calcGCD(num1 * num2, denum1 * denum2);

        numAns = (num1 * num2) / gcd;
        denumAns = (denum1 * denum2) / gcd;
    }

    public void checkAnswer(View view) {
        try {
            EditText numAnsEditText = findViewById(R.id.numeratorAnswerFractions);
            int numUser = Integer.parseInt(numAnsEditText.getText().toString());

            EditText denumAnsEditText = findViewById(R.id.denumeratorAnswerFractions);
            int denumUser = Integer.parseInt(denumAnsEditText.getText().toString());

            if (numUser == numAns && denumUser == denumAns) {
                Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, String.format(getString(R.string.incorrectFractions), numAns, denumAns), Toast.LENGTH_SHORT).show();
            }
            genNewNumbers();
            numAnsEditText.setText("");
            denumAnsEditText.setText("");
        } catch (Exception e) {
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
