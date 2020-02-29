package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView input, output;
    Button rock, paper, scissors;
    TextView score;


    @Override
    protected void onCreate(Bundle savedInstanceState) { //This is where you initialize activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        score.setText("Your score: " + Integer.toString(playerWins) + " Computer Score: " + Integer.toString(computerWins));


        input = (ImageView) findViewById(R.id.iv_input);
        rock = (Button) findViewById(R.id.btn_rock);
        paper = (Button) findViewById(R.id.btn_paper);
        scissors = (Button) findViewById(R.id.btn_scissors);
        score = (TextView) findViewById(R.id.tv_score);

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String message = playTurn(1);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                score.setText("Your score: " + Integer.toString(playerWins) + " Computer Score: " + Integer.toString(computerWins));

            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = playTurn(2);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                score.setText("Your score: " + Integer.toString(playerWins) + " Computer Score: " + Integer.toString(computerWins));
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = playTurn(3);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                score.setText("Your score: " + Integer.toString(playerWins) + " Computer Score: " + Integer.toString(computerWins));
            }
        });


    }

    int playerWins = 0;
    int computerWins = 0;

    public String playTurn(int playerChoice) {
        Random randomNum = new Random();

        int computerChoice = randomNum.nextInt(3) + 1;

        if (playerChoice == computerChoice) {
            // Tie
            return "Tie!";
        } else if ( (playerChoice == 1 && computerChoice == 3) ||
                (playerChoice == 2 && computerChoice == 1) ||
                (playerChoice == 3 && computerChoice == 2)) {
            playerWins++;
            return "You Win... Congratulations!";
        } else {
            computerWins++;
            return "The Computer Won!";

        }


    }

}
