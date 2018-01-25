package com.abdallahmeebed.maths101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FirstDegreeActivity extends AppCompatActivity {

    TextView questionTextView;

    private int a1, c1, a2, c2; //a = unknown, c = constant
    private double aAns;
    private final int BOUNDARY = 50, RANGE = -25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_degree);
        questionTextView = findViewById(R.id.firstDegreeLine);
        genNewNumbers();
    }

    public void genNewNumbers() {
        Random random = new Random();
        a1 = random.nextInt(BOUNDARY) + RANGE;
        c1 = random.nextInt(BOUNDARY) + RANGE;
        a2 = random.nextInt(BOUNDARY) + RANGE;
        c2 = random.nextInt(BOUNDARY) + RANGE;

        checkUnknown();


        questionTextView.setText(String.format(getString(R.string.firstDegreeLine), a1, c1, a2, c2));

        // putting unknown in a side, the constants on the other

        aAns = Math.round(100.0 * (a2 - a1) / (c2 - c1)) / 100.0;
    }

    public void checkUnknown() {
        if (a1 == a2) {
            Random random = new Random();
            a2 = random.nextInt(BOUNDARY) + RANGE;
            checkUnknown();
        }
    }

    public void checkAnswer(View view) {
        try {
            EditText answerEditText = findViewById(R.id.firstDegreeAnswer);
            double userAns = Double.parseDouble(answerEditText.getText().toString());

            if (userAns == aAns) {
                Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, String.format(getString(R.string.incorrectFirstDegree), aAns), Toast.LENGTH_LONG).show();
            }
            genNewNumbers();
            answerEditText.setText("");
        } catch (Exception e) {
            System.out.println(e.toString());
            Toast.makeText(this, getString(R.string.emptyNumber), Toast.LENGTH_SHORT).show();
        }
    }
}
