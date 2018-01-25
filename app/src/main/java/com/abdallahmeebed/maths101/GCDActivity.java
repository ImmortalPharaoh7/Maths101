package com.abdallahmeebed.maths101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GCDActivity extends AppCompatActivity {

    TextView firstNumTextView, secondNumTextView;

    private int firstNum, secondNum, gcd;
    private final int GCD_BOUNDARY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcd);

        firstNumTextView = findViewById(R.id.firstNumGCD);
        secondNumTextView = findViewById(R.id.secondNumGCD);

        genNewNumbers();

    }

    public static int calcGCD(int firstNum, int secondNum) {
        if (secondNum == 0) return firstNum;
        return calcGCD(secondNum, firstNum % secondNum);
    }

    public void genNewNumbers() {
        Random random = new Random();
        firstNum = random.nextInt(GCD_BOUNDARY) + 1;
        secondNum = random.nextInt(GCD_BOUNDARY) + 1;


        firstNumTextView.setText(String.valueOf(firstNum));
        secondNumTextView.setText(String.valueOf(secondNum));

        gcd = calcGCD(firstNum, secondNum);
    }

    public void checkAnswer(View view) {
        try {
            EditText answerEditText = findViewById(R.id.gcdAnswer);
            int answerUser = Integer.parseInt(answerEditText.getText().toString());

            if (answerUser == gcd) {
                Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, String.format(getString(R.string.incorrectGCD), gcd), Toast.LENGTH_LONG).show();
            }
            genNewNumbers();
            answerEditText.setText("");
        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.emptyNumber), Toast.LENGTH_SHORT).show();
        }
    }
}
