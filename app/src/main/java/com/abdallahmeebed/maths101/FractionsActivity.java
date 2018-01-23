package com.abdallahmeebed.maths101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FractionsActivity extends AppCompatActivity {

    TextView num1TextView, denum1TextView, num2TextView, denum2TextView;

    private int num1, denum1, num2, denum2, numAns, denumAns;
    private final int FRACTIONS_BOUNDARY = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fractions);

        genNewNumbers();
    }

    public void genNewNumbers() {
        Random random = new Random();

        num1 = random.nextInt(FRACTIONS_BOUNDARY) + 1;
        num2 = random.nextInt(FRACTIONS_BOUNDARY) + 1;
        denum1 = random.nextInt(FRACTIONS_BOUNDARY) + 1;
        denum2 = random.nextInt(FRACTIONS_BOUNDARY) + 1;

        num1TextView = findViewById(R.id.numerator1Fractions);
        denum1TextView = findViewById(R.id.denumerator1Fractions);
        num2TextView = findViewById(R.id.numerator2Fractions);
        denum2TextView = findViewById(R.id.denumerator2Fractions);

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
                genNewNumbers();
            } else {
                Toast.makeText(this, String.format(getString(R.string.incorrectFractions), numAns, denumAns), Toast.LENGTH_SHORT).show();
                genNewNumbers();
            }
        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.emptyNumber), Toast.LENGTH_SHORT).show();
        }
    }
}
