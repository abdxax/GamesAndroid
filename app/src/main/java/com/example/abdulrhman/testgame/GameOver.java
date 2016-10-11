package com.example.abdulrhman.testgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {
int points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        int points_game=getIntent().getIntExtra("point",0);
        TextView textView=(TextView)findViewById(R.id.textView10);
       points=points_game;
        textView.setText(points_game+"");
        //SharedPreferences sharedPreferences=getSharedPreferences("MYPOINT", Context.MODE_PRIVATE);
    }
    public  void saveScores(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("MYPOINT", Context.MODE_PRIVATE);
        EditText editText=(EditText)findViewById(R.id.editText2) ;
        String name=editText.getText().toString();
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String prefscor=sharedPreferences.getString("SCORE","");//Add old score at the game
        editor.putString("SCORE","Name: "+name+" , "+points+" POINTS\n"+prefscor);
        editor.commit();
        finish();
    }
}
