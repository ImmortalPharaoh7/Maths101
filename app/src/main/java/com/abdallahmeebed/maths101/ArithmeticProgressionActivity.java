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

public class ArithmeticProgressionActivity extends AppCompatActivity {

    private final int PROMPT_BOUNDARY = 60, REASON_BOUNDARY = 300, TERM1_BOUNDARY = 500;
    TextView promptTextView, term1TextView, reasonTextView;
    MediaPlayer algorithmMusic;
    private int promptNum, term1Num, reasonNum, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic_progression);

        algorithmMusic = MediaPlayer.create(this, R.raw.bit8_summer);
        if (!mutedByUser) algorithmMusic.start();
        algorithmMusic.setLooping(true);

        promptTextView = findViewById(R.id.arithmeticPrompt);
        term1TextView = findViewById(R.id.arithmeticTerm);
        reasonTextView = findViewById(R.id.arithmeticReason);
        genNewNumbers();
    }

    public void genNewNumbers() {
        Random random = new Random();
        promptNum = random.nextInt(PROMPT_BOUNDARY) + 3;
        term1Num = random.nextInt(TERM1_BOUNDARY) + 1;
        reasonNum = random.nextInt(REASON_BOUNDARY) + 1;

        promptTextView.setText(String.format(getString(R.string.arithmeticProgressionPrompt), promptNum));
        term1TextView.setText(String.format(getString(R.string.arithmeticProgressionTerm), term1Num));
        reasonTextView.setText(String.format(getString(R.string.arithmeticProgressionReason), reasonNum));

        answer = term1Num + (promptNum - 1) * reasonNum;
    }

    public void checkAnswer(View view) {
        try {
            EditText answerEditText = findViewById(R.id.arithmeticAnswer);
            int answerUser = Integer.parseInt(answerEditText.getText().toString());

            if (answerUser == answer) {
                Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, String.format(getString(R.string.arithmeticProgressionIncorrect), answer), Toast.LENGTH_LONG).show();
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
