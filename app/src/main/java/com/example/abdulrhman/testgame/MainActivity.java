package com.example.abdulrhman.testgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
    }
    public void click (View view){

        Intent intent=new Intent(this,GameActivity.class);
        startActivity(intent);
    }
    public void Multiplayer(View view){
        Intent intent=new Intent(MainActivity.this,MulitPlayer.class);
        startActivity(intent);
    }
    public void score(View view){
        Intent intent=new Intent(MainActivity.this,Scores.class);
        startActivity(intent);
    }
}
