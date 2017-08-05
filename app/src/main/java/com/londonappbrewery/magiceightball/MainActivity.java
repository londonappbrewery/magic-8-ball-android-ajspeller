package com.londonappbrewery.magiceightball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            ImageView image8Ball = (ImageView) findViewById(R.id.image8Ball);
            int currentAnswer = savedInstanceState.getInt("answerID");
            image8Ball.setImageResource(currentAnswer);
            image8Ball.setTag(currentAnswer);
        }

        setup();
    }

    private void setup() {

        Button askBtn = (Button) findViewById(R.id.askBtn);

        askBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answer;

                int[] wisdom = {
                        R.drawable.ball1,
                        R.drawable.ball2,
                        R.drawable.ball3,
                        R.drawable.ball4,
                        R.drawable.ball5
                };

                ImageView eightBallImage = (ImageView) findViewById(R.id.image8Ball);

                Random randomInt = new Random();

                answer = wisdom[randomInt.nextInt(4)];
                eightBallImage.setImageResource(answer);
                eightBallImage.setTag(answer);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        ImageView eightBallImage = (ImageView) findViewById(R.id.image8Ball);
        Object tag = eightBallImage.getTag();
        int answerID = (int) tag;
        outState.putInt("answerID", answerID);

    }
}
