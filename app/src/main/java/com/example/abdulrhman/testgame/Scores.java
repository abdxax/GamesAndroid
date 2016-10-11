package com.example.abdulrhman.testgame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Scores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        TextView textView=(TextView)findViewById(R.id.TextScore);
        SharedPreferences sharedPreferences=getSharedPreferences("MYPOINT",MODE_PRIVATE);
        String score=sharedPreferences.getString("SCORE","No Score");
        textView.setText(score);
    }
}
