package com.application.vladcelona.textadventure;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ExecuteStory extends AppCompatActivity {

    private ArrayList<int[]> stories;

    private TextView mainText;
    private Button firstChoice, secondChoice, thirdChoice;

    public ExecuteStory(Button firstChoice, Button secondChoice, Button thirdChoice, TextView mainText) {
        stories = new LoadStory().getStoryList();
        this.firstChoice = firstChoice; this.secondChoice = secondChoice;
        this.thirdChoice = thirdChoice; this.mainText = mainText;
        startStory();
    }

    private void startStory() {
//        mainText.setText(getResources().getText(R.string.start_1).toString());
    }
}
