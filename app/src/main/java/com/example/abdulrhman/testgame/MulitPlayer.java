package com.example.abdulrhman.testgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MulitPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulit_player);

    }
    public void sentword(View view){
        EditText text=(EditText) findViewById(R.id.enterword);
        Intent intent=new Intent(MulitPlayer.this,GameMulit.class);
        String word=text.getText().toString();
        intent.putExtra("id_word",word);
        startActivity(intent);
        finish();



    }

}
