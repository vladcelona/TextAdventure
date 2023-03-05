package com.application.vladcelona.textadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private CrewMember crewMember = new CrewMember();
    protected int index = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mainText = findViewById(R.id.main_text);

        Button firstChoice = findViewById(R.id.first_choice);
        Button secondChoice = findViewById(R.id.second_choice);
        Button thirdChoice = findViewById(R.id.third_choice);

        mainText.setText(getResources().getText(R.string.start_1).toString());

        ArrayList<int[]> story = new LoadStory().getStoryList();
        firstChoice.setVisibility(View.INVISIBLE);
        secondChoice.setVisibility(View.INVISIBLE);

        thirdChoice.setOnClickListener(view -> {
            mainText.setText(getResources().getText(story.get(1)[0]).toString());
            firstChoice.setVisibility(View.VISIBLE);
            secondChoice.setVisibility(View.VISIBLE);
        });

        firstChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstChoice.setText("HELLO");
            }
        });

//        new ExecuteStory(firstChoice, secondChoice, thirdChoice, mainText);
    }
}