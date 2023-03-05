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
        ImageView mainImage = findViewById(R.id.main_image);

        Button firstChoice = findViewById(R.id.first_choice);
        Button secondChoice = findViewById(R.id.second_choice);
        Button thirdChoice = findViewById(R.id.third_choice);

        ArrayList<int[]> story = new LoadStory().getStoryList();
        while (index < story.size()) {
            if (index == 0) {
                firstChoice.setVisibility(View.INVISIBLE);
                secondChoice.setVisibility(View.INVISIBLE);

                mainText.setText(getResources().getText(story.get(0)[0]).toString());
                thirdChoice.setOnClickListener(view -> index++);
            }
        }
    }
}