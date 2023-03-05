package com.application.vladcelona.textadventure;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LoadStory extends AppCompatActivity {

    private ArrayList<int[]> storyList = new ArrayList<>();

    public LoadStory() { initializeStoryList(); }

    private void initializeStoryList() {
        storyList.add(new int[]
                {R.string.start_1});
        storyList.add(new int[]
                {R.string.action_1, R.string.decision_1_1, R.string.decision_1_2});
        storyList.add(new int[]
                {R.string.action_1_1});
        storyList.add(new int[]
                {R.string.action_1_2}); // End
        storyList.add(new int[]
                {R.string.action_2, R.string.decision_2_1, R.string.decision_2_2});
        storyList.add(new int[]
                {R.string.action_2_1, R.string.decision_2_1_1, R.string.decision_2_1_2});
        storyList.add(new int[]
                {R.string.action_2_2, R.string.decision_2_2_1, R.string.decision_2_2_2});
        storyList.add(new int[]
                {R.string.action_2_2_1, R.string.decision_2_2_1_1, R.string.decision_2_2_1_2});
        storyList.add(new int[]
                {R.string.decision_2_2_2_1, R.string.decision_2_2_2_2});
        storyList.add(new int[]
                {R.string.decision_2_2_2_2_1, R.string.decision_2_2_2_2_2, R.string.decision_2_2_2_2_3});
        storyList.add(new int[]
                {R.string.action_2_2_2_2_1, R.string.action_2_2_2_2_2});
        storyList.add(new int[]
                {R.string.action_2_2_2_2_3, R.string.decision_2_2_2_2_3_1, R.string.decision_2_2_2_2_3_2});
        storyList.add(new int[]
                {R.string.action_2_2_2_2_3_2, R.string.decision_2_2_2_2_3_2_1, R.string.decision_2_2_2_2_3_2_2});
        storyList.add(new int[]
                {R.string.action_2_2_2_2_3_2_1, R.string.decision_2_2_2_2_3_2_1_1, R.string.decision_2_2_2_2_3_2_1_2});
        storyList.add(new int[]
                {R.string.action_2_2_2_2_3_2_1_1});
    }

    public ArrayList<int[]> getStoryList() { return storyList; }
}
