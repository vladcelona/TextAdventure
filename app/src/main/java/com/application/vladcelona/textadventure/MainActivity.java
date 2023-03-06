package com.application.vladcelona.textadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private CrewMember crewMember = new CrewMember();
    private Button firstChoice, secondChoice, thirdChoice;
    private TextView mainText, oxygenLevel, energyLevel;
    private ArrayList<int[]> story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = findViewById(R.id.main_text);
        oxygenLevel = findViewById(R.id.oxygen_level);
        energyLevel = findViewById(R.id.energy_level);

        firstChoice = findViewById(R.id.first_choice);
        secondChoice = findViewById(R.id.second_choice);
        thirdChoice = findViewById(R.id.third_choice);

        story = new LoadStory().getStoryList();

        String firstTag = "0";
        firstChoice.setTag(firstTag);
        String secondTag = "0";
        secondChoice.setTag(secondTag);
        String thirdTag = "0";
        thirdChoice.setTag(thirdTag);

        firstChoice.setVisibility(View.INVISIBLE); secondChoice.setVisibility(View.INVISIBLE);
        mainText.setText(getResources().getText(R.string.start_1).toString());
        thirdChoice.setTag("1"); thirdChoice.setText("Next");

        thirdChoice.setOnClickListener(view -> setThirdChoice());
    }

    private void setFirstChoice() {
        Log.i(TAG, "firstChoice Button was pressed");

        if (firstChoice.getTag().toString().equals("2")) {
            String[] randomArray = {
                    (String) getResources().getText(R.string.action_1_1),
                    (String) getResources().getText(R.string.action_1_2)};
            int select = new Random().nextInt(randomArray.length);

            if (select == 0) {
                mainText.setText(getResources().getText(story.get(2)[0]).toString());

                firstChoice.setVisibility(View.INVISIBLE); secondChoice.setVisibility(View.INVISIBLE);
                thirdChoice.setVisibility(View.VISIBLE); thirdChoice.setText("Next");

                thirdChoice.setOnClickListener(view -> {
                    secondChoice.setTag("4"); setSecondChoice();
                });
            } else {
                mainText.setText(getResources().getText(story.get(3)[0]).toString());
                Toast.makeText(this, "That is the end of the story!", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else if (firstChoice.getTag().toString().equals("4")) {
            mainText.setText(getResources().getText(story.get(3)[0]).toString());
            Toast.makeText(this, "That is the end of the story!", Toast.LENGTH_SHORT).show();
            finish();
        } else if (firstChoice.getTag().toString().equals("5")) {
            mainText.setText(getResources().getText(story.get(5)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(5)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(5)[2]).toString());

            firstChoice.setOnClickListener(view -> {
                firstChoice.setTag("3"); setFirstChoice();
            });
            secondChoice.setOnClickListener(view -> {
                secondChoice.setTag("3"); setSecondChoice();
            });
        } else if (firstChoice.getTag().toString().equals("7")) {
            mainText.setText(getResources().getText(story.get(7)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(7)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(7)[2]).toString());

            firstChoice.setOnClickListener(view -> {
                firstChoice.setTag("7"); takeAction(1); setFirstChoice();
            });
            secondChoice.setOnClickListener(view -> {
                secondChoice.setTag("3"); takeAction(0); setSecondChoice();
            });
        } else if (firstChoice.getTag().toString().equals("9")) {
            firstChoice.setVisibility(View.VISIBLE); secondChoice.setVisibility(View.VISIBLE);
            thirdChoice.setVisibility(View.VISIBLE);

            thirdChoice.setText(getResources().getText(story.get(9)[2]).toString());
            firstChoice.setText(getResources().getText(story.get(9)[0]).toString());
            secondChoice.setText(getResources().getText(story.get(9)[1]).toString());

            firstChoice.setOnClickListener(view -> {
                firstChoice.setTag("10"); takeAction(0); setFirstChoice();
            });
            secondChoice.setOnClickListener(view -> {
                secondChoice.setTag("10"); takeAction(0); setSecondChoice();
            });
            thirdChoice.setOnClickListener(view -> {
                thirdChoice.setTag("11"); takeAction(0); setThirdChoice();
            });
        } else if (firstChoice.getTag().toString().equals("10")) {
            firstChoice.setVisibility(View.INVISIBLE); secondChoice.setVisibility(View.INVISIBLE);
            mainText.setText(getResources().getText(story.get(10)[0]).toString());
            thirdChoice.setText("Next");

            thirdChoice.setOnClickListener(view -> {
                thirdChoice.setTag("9"); takeAction(0); setThirdChoice();
            });
        } else if (firstChoice.getTag().toString().equals("13")) {
            mainText.setText(getResources().getText(story.get(13)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(13)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(13)[2]).toString());

            firstChoice.setOnClickListener(view -> {
                secondChoice.setTag("3"); takeAction(0); setSecondChoice();
            });
            secondChoice.setOnClickListener(view -> {
                secondChoice.setTag("14"); takeAction(0); setSecondChoice();
            });
        }
    }

    private void setSecondChoice() {
        Log.i(TAG, "secondChoice Button was pressed");

        if (secondChoice.getTag().toString().equals("3")) {
            mainText.setText(getResources().getText(story.get(3)[0]).toString());
            Toast.makeText(this, "That is the end of the story!", Toast.LENGTH_SHORT).show();
            finish();
        } else if (secondChoice.getTag().toString().equals("4")) {
            firstChoice.setVisibility(View.VISIBLE); secondChoice.setVisibility(View.VISIBLE);
            thirdChoice.setVisibility(View.INVISIBLE);

            mainText.setText(getResources().getText(story.get(4)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(4)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(4)[2]).toString());

            firstChoice.setOnClickListener(view -> {
                firstChoice.setTag("5"); takeAction(0); setFirstChoice();
            });
            secondChoice.setOnClickListener(view -> {
                secondChoice.setTag("6"); takeAction(0); setSecondChoice();
            });
        } else if (secondChoice.getTag().toString().equals("6")) {

            mainText.setText(getResources().getText(story.get(6)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(6)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(6)[2]).toString());

            firstChoice.setOnClickListener(view -> {
                firstChoice.setTag("7"); takeAction(0); setFirstChoice();
            });
            secondChoice.setOnClickListener(view -> {
                secondChoice.setTag("8"); takeAction(0); setSecondChoice();
            });
        } else if (secondChoice.getTag().toString().equals("8")) {
            mainText.setText(getResources().getText(story.get(6)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(8)[0]).toString());
            secondChoice.setText(getResources().getText(story.get(8)[1]).toString());

            firstChoice.setOnClickListener(view -> {
                secondChoice.setTag("3"); takeAction(0); setSecondChoice();
            });
            secondChoice.setOnClickListener(view -> {
                secondChoice.setTag("9"); takeAction(0); setSecondChoice();
            });
        } else if (secondChoice.getTag().toString().equals("9")) {
            firstChoice.setVisibility(View.VISIBLE); secondChoice.setVisibility(View.VISIBLE);
            thirdChoice.setVisibility(View.VISIBLE);

            thirdChoice.setText(getResources().getText(story.get(9)[2]).toString());
            firstChoice.setText(getResources().getText(story.get(9)[0]).toString());
            secondChoice.setText(getResources().getText(story.get(9)[1]).toString());

            firstChoice.setOnClickListener(view -> {
                firstChoice.setTag("10"); takeAction(0); setFirstChoice();
            });
            secondChoice.setOnClickListener(view -> {
                secondChoice.setTag("10"); takeAction(0); setSecondChoice();
            });
            thirdChoice.setOnClickListener(view -> {
                thirdChoice.setTag("11"); takeAction(0); setThirdChoice();
            });
        } else if (secondChoice.getTag().toString().equals("10")) {
            firstChoice.setVisibility(View.INVISIBLE); secondChoice.setVisibility(View.INVISIBLE);
            mainText.setText(getResources().getText(story.get(10)[1]).toString());
            thirdChoice.setText("Next");

            thirdChoice.setOnClickListener(view -> {
                thirdChoice.setTag("9"); takeAction(0); setThirdChoice();
            });
        } else if (secondChoice.getTag().toString().equals("12")) {
            mainText.setText(getResources().getText(story.get(12)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(12)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(12)[2]).toString());

            firstChoice.setOnClickListener(view -> {
                firstChoice.setTag("13"); takeAction(0); setFirstChoice();
            });
            secondChoice.setOnClickListener(view -> {
                secondChoice.setTag("3"); takeAction(0); setSecondChoice();
            });
        } else if (secondChoice.getTag().toString().equals("14")) {
            firstChoice.setVisibility(View.INVISIBLE); secondChoice.setVisibility(View.INVISIBLE);
            thirdChoice.setVisibility(View.VISIBLE);

            mainText.setText(getResources().getText(story.get(14)[0]).toString());
            thirdChoice.setText("Next");

            thirdChoice.setOnClickListener(view -> {
                thirdChoice.setTag("15"); takeAction(0); setThirdChoice();
            });
        }
    }

    private void setThirdChoice() {
        Log.i(TAG, "thirdChoice Button was pressed");

        if (thirdChoice.getTag().toString().equals("1")) {
            firstChoice.setVisibility(View.VISIBLE); secondChoice.setVisibility(View.VISIBLE);
            thirdChoice.setVisibility(View.INVISIBLE);

            mainText.setText(getResources().getText(story.get(1)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(1)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(1)[2]).toString());

            firstChoice.setOnClickListener(view -> {
                firstChoice.setTag("2"); setFirstChoice();
            });
            secondChoice.setOnClickListener(view -> {
                secondChoice.setTag("4"); setSecondChoice();
            });
        } else if (thirdChoice.getTag().toString().equals("9")) {
            firstChoice.setVisibility(View.VISIBLE); secondChoice.setVisibility(View.VISIBLE);
            thirdChoice.setVisibility(View.VISIBLE);

            thirdChoice.setText(getResources().getText(story.get(9)[2]).toString());
            firstChoice.setText(getResources().getText(story.get(9)[0]).toString());
            secondChoice.setText(getResources().getText(story.get(9)[1]).toString());

            firstChoice.setOnClickListener(view -> {
                firstChoice.setTag("10"); takeAction(0); setFirstChoice();
            });
            secondChoice.setOnClickListener(view -> {
                secondChoice.setTag("10"); takeAction(0); setSecondChoice();
            });
            thirdChoice.setOnClickListener(view -> {
                thirdChoice.setTag("11"); takeAction(0); setThirdChoice();
            });
        } else if (thirdChoice.getTag().toString().equals("11")) {
            thirdChoice.setVisibility(View.INVISIBLE);

            mainText.setText(getResources().getText(story.get(11)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(11)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(11)[2]).toString());

            firstChoice.setOnClickListener(view -> {
                secondChoice.setTag("3"); takeAction(0); setSecondChoice();
            });
            secondChoice.setOnClickListener(view -> {
                secondChoice.setTag("12"); takeAction(0); setSecondChoice();
            });
        } else if (thirdChoice.getTag().toString().equals("15")) {
            Toast.makeText(this, "This is the end of the story!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void takeAction(int type) {
        Log.i(TAG, "Resources level: " +
                crewMember.getEnergyLevel() + " " +
                crewMember.getOxygenLevel());

        if (type == 0) {
            crewMember.reduceEnergy();
        } else {
            crewMember.reduceEnergyShooting();
        }

        crewMember.reduceOxygen();
        energyLevel.setText(Integer.toString(crewMember.getEnergyLevel()));
        oxygenLevel.setText(Integer.toString(crewMember.getOxygenLevel()));

        if (!crewMember.checkStats()) {
            Toast.makeText(this, "You are out of resources and you have died!",
                    Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}