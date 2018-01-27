package com.abdallahmeebed.maths101;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.abdallahmeebed.maths101.WelcomeActivity.mutedByUser;

public class PowersIActivity extends AppCompatActivity {

    private final int BOUNDARY = 101;
    TextView questionTextView;
    MediaPlayer algorithmMusic;
    private int power;
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_powers_i);

        algorithmMusic = MediaPlayer.create(this, R.raw.bit8_summer);
        if (!mutedByUser) algorithmMusic.start();
        algorithmMusic.setLooping(true);

        questionTextView = findViewById(R.id.powersILine);
        genNewNumbers();
    }

    public void genNewNumbers() {
        Random random = new Random();
        power = random.nextInt(BOUNDARY);

        questionTextView.setText(String.format(getString(R.string.powersILine), power));

        switch (power % 4) {
            case 0:
                answer = "1";
                break;
            case 1:
                answer = "i";
                break;
            case 2:
                answer = "-1";
                break;
            case 3:
                answer = "-i";
                break;
        }
    }

    public void checkAnswer(View view) {
        try {
            RadioGroup radioPowersIGroup = findViewById(R.id.RadioPowersIGroup);
            RadioButton radioPowersIButton = findViewById(radioPowersIGroup.getCheckedRadioButtonId());

            if (radioPowersIButton.getText().toString().equals(answer)) {
                Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, String.format(getString(R.string.powersIIncorrect), answer), Toast.LENGTH_LONG).show();
            }
            genNewNumbers();
            radioPowersIButton.setChecked(false);
        } catch (Exception e) {
            System.out.println(e.toString());
            Toast.makeText(this, getString(R.string.emptyOption), Toast.LENGTH_SHORT).show();
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
