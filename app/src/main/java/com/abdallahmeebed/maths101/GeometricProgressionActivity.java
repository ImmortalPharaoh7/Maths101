package com.abdallahmeebed.maths101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GeometricProgressionActivity extends AppCompatActivity {

    TextView promptTextView, term1TextView, reasonTextView;

    private int promptNum, term1Num, reasonNum;
    private long answer;

    private final int PROMPT_BOUNDARY = 8, REASON_BOUNDARY = 6, TERM1_BOUNDARY = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometric_progression);

        promptTextView = findViewById(R.id.geometricPrompt);
        term1TextView = findViewById(R.id.geometricTerm);
        reasonTextView = findViewById(R.id.geometricReason);
        genNewNumbers();
    }

    public void genNewNumbers() {
        Random random = new Random();
        promptNum = random.nextInt(PROMPT_BOUNDARY) + 3;
        term1Num = random.nextInt(TERM1_BOUNDARY) + 1;
        reasonNum = random.nextInt(REASON_BOUNDARY) + 1;

        promptTextView.setText(String.format(getString(R.string.geometricProgressionPrompt), promptNum));
        term1TextView.setText(String.format(getString(R.string.geometricProgressionTerm), term1Num));
        reasonTextView.setText(String.format(getString(R.string.geometricProgressionReason), reasonNum));

        answer = (long) ((long) term1Num * Math.pow((double) reasonNum, promptNum));
    }

    public void checkAnswer(View view) {
        try {
            EditText answerEditText = findViewById(R.id.geometricAnswer);
            long answerUser = Long.parseLong(answerEditText.getText().toString());

            if (answerUser == answer) {
                Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, String.format(getString(R.string.geometricProgressionIncorrect), answer), Toast.LENGTH_LONG).show();
            }
            genNewNumbers();
            answerEditText.setText("");
        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.emptyNumberLong), Toast.LENGTH_SHORT).show();
        }
    }
}
