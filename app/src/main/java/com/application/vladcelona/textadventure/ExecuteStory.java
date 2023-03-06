package com.application.vladcelona.textadventure;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ExecuteStory extends AppCompatActivity {

    private ArrayList<int[]> stories;
    private String firstTag; private String secondTag;
    private Button firstChoice; private Button secondChoice;
    public ExecuteStory() {
        stories = new LoadStory().getStoryList();
        this.firstTag = "0"; this.secondTag = "0";
    }
}
