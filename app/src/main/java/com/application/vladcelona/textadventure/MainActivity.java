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

    private String firstTag = "0"; private String secondTag = "0"; private String thirdTag = "0";
    private Button firstChoice, secondChoice, thirdChoice;
    private TextView mainText;
    private ArrayList<int[]> story;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = findViewById(R.id.main_text);

        firstChoice = findViewById(R.id.first_choice);
        secondChoice = findViewById(R.id.second_choice);
        thirdChoice = findViewById(R.id.third_choice);

        story = new LoadStory().getStoryList();

        firstChoice.setTag(firstTag); secondChoice.setTag(secondTag); thirdChoice.setTag(thirdTag);

        firstChoice.setVisibility(View.INVISIBLE); secondChoice.setVisibility(View.INVISIBLE);
        mainText.setText(getResources().getText(R.string.start_1).toString());
        thirdChoice.setTag("1"); thirdChoice.setText("Next");

        thirdChoice.setOnClickListener(view -> setThirdChoice());

//        thirdChoice.setText("Next");
//
//        ArrayList<int[]> story = new LoadStory().getStoryList();
//        firstChoice.setVisibility(View.INVISIBLE); secondChoice.setVisibility(View.INVISIBLE);
//
//        Log.i(TAG, "thirdChoice Tag: " + thirdChoice.getTag().toString());
//
//        thirdChoice.setOnClickListener(view -> {
//            thirdChoice.setTag("1"); view.setOnClickListener(null);
//        });
//
//        if (thirdChoice.getTag().toString().equals("1")) {
//            firstChoice.setVisibility(View.VISIBLE);
//            secondChoice.setVisibility(View.VISIBLE);
//            thirdChoice.setVisibility(View.INVISIBLE);
//
//            mainText.setText(getResources().getText(story.get(1)[0]).toString());
//            firstChoice.setText(getResources().getText(story.get(1)[1]).toString());
//            secondChoice.setText(getResources().getText(story.get(1)[2]).toString());
//
//            firstChoice.setOnClickListener(view -> firstChoice.setTag("2"));
//            secondChoice.setOnClickListener(view -> secondChoice.setTag("3"));
//        }
//        if (thirdChoice.getTag().toString().equals("4")) {
//            firstChoice.setVisibility(View.VISIBLE); secondChoice.setVisibility(View.VISIBLE);
//            thirdChoice.setVisibility(View.INVISIBLE);
//
//            mainText.setText(getResources().getText(story.get(4)[0]).toString());
//            firstChoice.setText(getResources().getText(story.get(4)[1]).toString());
//            secondChoice.setText(getResources().getText(story.get(4)[2]).toString());
//
//            firstChoice.setOnClickListener(view -> firstChoice.setTag("5"));
//            secondChoice.setOnClickListener(view -> secondChoice.setTag("6"));
//        }
//        if (thirdChoice.getTag().toString().equals("11")) {
//            thirdChoice.setVisibility(View.INVISIBLE);
//
//            mainText.setText(getResources().getText(story.get(11)[0]).toString());
//            firstChoice.setText(getResources().getText(story.get(11)[1]).toString());
//            secondChoice.setText(getResources().getText(story.get(11)[2]).toString());
//
//            firstChoice.setOnClickListener(view -> firstChoice.setTag("15"));
//            secondChoice.setOnClickListener(view -> secondChoice.setTag("12"));
//        }
//
//        if (firstChoice.getTag().toString().equals("2")) {
//            mainText.setText(getResources().getText(story.get(2)[0]).toString());
//
//            firstChoice.setVisibility(View.INVISIBLE); secondChoice.setVisibility(View.INVISIBLE);
//            thirdChoice.setVisibility(View.VISIBLE); thirdChoice.setText("Next");
//
//            thirdChoice.setOnClickListener(view -> thirdChoice.setTag("4"));
//        }
//
//        if (secondChoice.getTag().toString().equals("3")) {
//            mainText.setText(getResources().getText(story.get(3)[0]).toString());
//            Toast.makeText(this, "That is the end of the story!", Toast.LENGTH_SHORT).show();
//            finish();
//        }
//
//        if (firstChoice.getTag().toString().equals("5")) {
//            mainText.setText(getResources().getText(story.get(5)[0]).toString());
//            firstChoice.setText(getResources().getText(story.get(5)[1]).toString());
//            secondChoice.setText(getResources().getText(story.get(5)[2]).toString());
//
//            firstChoice.setOnClickListener(view -> firstChoice.setTag("3"));
//            secondChoice.setOnClickListener(view -> secondChoice.setTag("3"));
//        }
//        if (secondChoice.getTag().toString().equals("6")) {
//            mainText.setText(getResources().getText(story.get(6)[0]).toString());
//            firstChoice.setText(getResources().getText(story.get(6)[1]).toString());
//            secondChoice.setText(getResources().getText(story.get(6)[2]).toString());
//
//            firstChoice.setOnClickListener(view -> firstChoice.setTag("7"));
//            secondChoice.setOnClickListener(view -> secondChoice.setTag("8"));
//        }
//
//        if (firstChoice.getTag().toString().equals("7")) {
//            mainText.setText(getResources().getText(story.get(7)[0]).toString());
//            firstChoice.setText(getResources().getText(story.get(7)[1]).toString());
//            secondChoice.setText(getResources().getText(story.get(7)[2]).toString());
//
//            firstChoice.setOnClickListener(view -> firstChoice.setTag("7"));
//            secondChoice.setOnClickListener(view -> secondChoice.setTag("15"));
//        }
//        if (secondChoice.getTag().toString().equals("8")) {
//            mainText.setText(getResources().getText(story.get(6)[0]).toString());
//            firstChoice.setText(getResources().getText(story.get(8)[1]).toString());
//            secondChoice.setText(getResources().getText(story.get(8)[2]).toString());
//
//            firstChoice.setOnClickListener(view -> firstChoice.setTag("15"));
//            secondChoice.setOnClickListener(view -> secondChoice.setTag("9"));
//        }
//
//        if (secondChoice.getTag().toString().equals("9") || thirdChoice.getTag().toString().equals("9")) {
//            thirdChoice.setVisibility(View.VISIBLE);
//
//            thirdChoice.setText(getResources().getText(story.get(9)[2]).toString());
//            firstChoice.setText(getResources().getText(story.get(9)[0]).toString());
//            secondChoice.setText(getResources().getText(story.get(9)[1]).toString());
//
//            firstChoice.setOnClickListener(view -> firstChoice.setTag("10"));
//            secondChoice.setOnClickListener(view -> secondChoice.setTag("10"));
//            thirdChoice.setOnClickListener(view -> thirdChoice.setTag("11"));
//        }
//
//        if (firstChoice.getTag().toString().equals("10")) {
//            thirdChoice.setVisibility(View.VISIBLE);
//
//            mainText.setText(getResources().getText(story.get(10)[0]).toString());
//            firstChoice.setText(getResources().getText(story.get(9)[1]).toString());
//            secondChoice.setText(getResources().getText(story.get(9)[2]).toString());
//
//            thirdChoice.setOnClickListener(view -> thirdChoice.setTag("9"));
//        }
//
//        if (secondChoice.getTag().toString().equals("10")) {
//            thirdChoice.setVisibility(View.VISIBLE);
//
//            mainText.setText(getResources().getText(story.get(10)[1]).toString());
//            firstChoice.setText(getResources().getText(story.get(9)[1]).toString());
//            secondChoice.setText(getResources().getText(story.get(9)[2]).toString());
//
//            thirdChoice.setOnClickListener(view -> thirdChoice.setTag("9"));
//        }
//
//        if (secondChoice.getTag().toString().equals("12")) {
//            mainText.setText(getResources().getText(story.get(12)[0]).toString());
//            firstChoice.setText(getResources().getText(story.get(12)[1]).toString());
//            secondChoice.setText(getResources().getText(story.get(12)[2]).toString());
//
//            firstChoice.setOnClickListener(view -> firstChoice.setTag("13"));
//            secondChoice.setOnClickListener(view -> secondChoice.setTag("15"));
//        }
//
//        if (firstChoice.getTag().toString().equals("13")) {
//            mainText.setText(getResources().getText(story.get(13)[0]).toString());
//            firstChoice.setText(getResources().getText(story.get(13)[1]).toString());
//            secondChoice.setText(getResources().getText(story.get(13)[2]).toString());
//
//            firstChoice.setOnClickListener(view -> firstChoice.setTag("15"));
//            secondChoice.setOnClickListener(view -> secondChoice.setTag("14"));
//        }
//
//        if (secondChoice.getTag().toString().equals("14")) {
//            mainText.setText(getResources().getText(story.get(14)[0]).toString());
//            Toast.makeText(this, "This is the end of the story!", Toast.LENGTH_SHORT).show();
//        }
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

                thirdChoice.setOnClickListener(view -> secondChoice.setTag("4"));
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

            firstChoice.setOnClickListener(view -> firstChoice.setTag("3"));
            secondChoice.setOnClickListener(view -> secondChoice.setTag("3"));
        } else if (firstChoice.getTag().toString().equals("7")) {
            mainText.setText(getResources().getText(story.get(7)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(7)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(7)[2]).toString());

            firstChoice.setOnClickListener(view -> firstChoice.setTag("7"));
            secondChoice.setOnClickListener(view -> secondChoice.setTag("3"));
        } else if (firstChoice.getTag().toString().equals("9")) {
            firstChoice.setVisibility(View.VISIBLE); secondChoice.setVisibility(View.VISIBLE);
            thirdChoice.setVisibility(View.VISIBLE);

            thirdChoice.setText(getResources().getText(story.get(9)[2]).toString());
            firstChoice.setText(getResources().getText(story.get(9)[0]).toString());
            secondChoice.setText(getResources().getText(story.get(9)[1]).toString());

            firstChoice.setOnClickListener(view -> firstChoice.setTag("10"));
            secondChoice.setOnClickListener(view -> secondChoice.setTag("10"));
            thirdChoice.setOnClickListener(view -> thirdChoice.setTag("11"));
        } else if (firstChoice.getTag().toString().equals("10")) {
            firstChoice.setVisibility(View.INVISIBLE); secondChoice.setVisibility(View.INVISIBLE);
            mainText.setText(getResources().getText(story.get(10)[0]).toString());
            thirdChoice.setText("Next");

            thirdChoice.setOnClickListener(view -> thirdChoice.setTag("9"));
        } else if (firstChoice.getTag().toString().equals("13")) {
            mainText.setText(getResources().getText(story.get(13)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(13)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(13)[2]).toString());

            firstChoice.setOnClickListener(view -> firstChoice.setTag("3"));
            secondChoice.setOnClickListener(view -> secondChoice.setTag("14"));
        }
    }

    private void setSecondChoice() {
        Log.i(TAG, "secondChoice Button was pressed");

        if (secondChoice.getTag().toString().equals("3")) {
            mainText.setText(getResources().getText(story.get(3)[0]).toString());
            Toast.makeText(this, "That is the end of the story!", Toast.LENGTH_SHORT).show();
            finish();
        } else if (secondChoice.getTag().toString().equals("4")) {
            mainText.setText(getResources().getText(story.get(4)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(4)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(4)[2]).toString());

            firstChoice.setOnClickListener(view -> firstChoice.setTag("5"));
            secondChoice.setOnClickListener(view -> secondChoice.setTag("6"));
        } else if (secondChoice.getTag().toString().equals("6")) {
            mainText.setText(getResources().getText(story.get(6)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(6)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(6)[2]).toString());

            firstChoice.setOnClickListener(view -> firstChoice.setTag("7"));
            secondChoice.setOnClickListener(view -> secondChoice.setTag("8"));
        } else if (secondChoice.getTag().toString().equals("8")) {
            mainText.setText(getResources().getText(story.get(6)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(8)[0]).toString());
            secondChoice.setText(getResources().getText(story.get(8)[1]).toString());

            firstChoice.setOnClickListener(view -> firstChoice.setTag("3"));
            secondChoice.setOnClickListener(view -> secondChoice.setTag("9"));
        } else if (secondChoice.getTag().toString().equals("9")) {
            firstChoice.setVisibility(View.VISIBLE); secondChoice.setVisibility(View.VISIBLE);
            thirdChoice.setVisibility(View.VISIBLE);

            thirdChoice.setText(getResources().getText(story.get(9)[2]).toString());
            firstChoice.setText(getResources().getText(story.get(9)[0]).toString());
            secondChoice.setText(getResources().getText(story.get(9)[1]).toString());

            firstChoice.setOnClickListener(view -> firstChoice.setTag("10"));
            secondChoice.setOnClickListener(view -> secondChoice.setTag("10"));
            thirdChoice.setOnClickListener(view -> thirdChoice.setTag("11"));
        } else if (secondChoice.getTag().toString().equals("10")) {
            firstChoice.setVisibility(View.INVISIBLE); secondChoice.setVisibility(View.INVISIBLE);
            mainText.setText(getResources().getText(story.get(10)[1]).toString());
            thirdChoice.setText("Next");

            thirdChoice.setOnClickListener(view -> thirdChoice.setTag("9"));
        } else if (secondChoice.getTag().toString().equals("12")) {
            mainText.setText(getResources().getText(story.get(12)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(12)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(12)[2]).toString());

            firstChoice.setOnClickListener(view -> firstChoice.setTag("13"));
            secondChoice.setOnClickListener(view -> secondChoice.setTag("3"));
        } else if (secondChoice.getTag().toString().equals("14")) {
            mainText.setText(getResources().getText(story.get(14)[0]).toString());
            Toast.makeText(this, "This is the end of the story!", Toast.LENGTH_SHORT).show();
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

            firstChoice.setOnClickListener(view -> firstChoice.setTag("2"));
            secondChoice.setOnClickListener(view -> secondChoice.setTag("4"));
        } else if (thirdChoice.getTag().toString().equals("9")) {
            firstChoice.setVisibility(View.VISIBLE); secondChoice.setVisibility(View.VISIBLE);
            thirdChoice.setVisibility(View.VISIBLE);

            thirdChoice.setText(getResources().getText(story.get(9)[2]).toString());
            firstChoice.setText(getResources().getText(story.get(9)[0]).toString());
            secondChoice.setText(getResources().getText(story.get(9)[1]).toString());

            firstChoice.setOnClickListener(view -> firstChoice.setTag("10"));
            secondChoice.setOnClickListener(view -> secondChoice.setTag("10"));
            thirdChoice.setOnClickListener(view -> thirdChoice.setTag("11"));
        } else if (thirdChoice.getTag().toString().equals("11")) {
            thirdChoice.setVisibility(View.INVISIBLE);

            mainText.setText(getResources().getText(story.get(11)[0]).toString());
            firstChoice.setText(getResources().getText(story.get(11)[1]).toString());
            secondChoice.setText(getResources().getText(story.get(11)[2]).toString());

            firstChoice.setOnClickListener(view -> firstChoice.setTag("3"));
            secondChoice.setOnClickListener(view -> secondChoice.setTag("12"));
        }
    }
}