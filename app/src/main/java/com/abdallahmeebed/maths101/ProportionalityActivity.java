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

public class ProportionalityActivity extends AppCompatActivity {

    private final int BOUNDARY = 100;
    TextView questionTextViewNum1, questionTextViewNum2, questionTextViewNum3;
    MediaPlayer algorithmMusic;
    private int num1, num2, num3;
    private double answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proportionality);

        algorithmMusic = MediaPlayer.create(this, R.raw.bit8_summer);
        if (!mutedByUser) algorithmMusic.start();
        algorithmMusic.setLooping(true);

        questionTextViewNum1 = findViewById(R.id.proportionalityNum1);
        questionTextViewNum2 = findViewById(R.id.proportionalityNum2);
        questionTextViewNum3 = findViewById(R.id.proportionalityNum3);

        genNewNumbers();
    }

    public void genNewNumbers() {
        Random random = new Random();
        num1 = random.nextInt(BOUNDARY) + 1;
        num2 = random.nextInt(BOUNDARY) + 1;
        num3 = random.nextInt(BOUNDARY) + 1;

        questionTextViewNum1.setText(String.valueOf(num1));
        questionTextViewNum2.setText(String.valueOf(num2));
        questionTextViewNum3.setText(String.valueOf(num3));

        answer = Math.round(100.0 * (num2 * num3) / num1) / 100.0;
    }

    public void checkAnswer(View view) {
        try {
            EditText answerEditText = findViewById(R.id.proportionalityAnswer);
            double answerUser = Double.parseDouble(answerEditText.getText().toString());

            if (answerUser == answer) {
                Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, String.format(getString(R.string.proportionalityIncorrect), answer), Toast.LENGTH_SHORT).show();
            }
            genNewNumbers();
            answerEditText.setText("");
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
