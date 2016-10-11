package com.example.abdulrhman.testgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameMulit extends AppCompatActivity {
   String mword;
    int counterFailed=0;
    int guessletter=0;
    int point=0;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mulit);
        String wordsent=getIntent().getStringExtra("id_word");

        mword=wordsent;
        creatText(wordsent);
    }
    public void checkletter(View view){
        EditText editText=(EditText) findViewById(R.id.editText_multi);
        String letter=editText.getText().toString();
        editText.setText("");
        Log. d("MyLog","My Letter is "+letter);
        if (letter.length()==1){
            checks(letter.toUpperCase());
        }
        else{
            Toast.makeText(this,"pleas enter one letter ",Toast.LENGTH_LONG).show();
        }

    }
    public void creatText(String word){
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.Liner);
        for (int i=0;i<word.length();i++){
            TextView textView= (TextView) getLayoutInflater().inflate(R.layout.textviews,null);
            linearLayout.addView(textView);
        }

    }

    public void checks(String letters) {
        boolean result_letter = false;
        char words = letters.charAt(0);
        for (int i = 0; i < mword.length(); i++) {
            char testletter = mword.charAt(i);
            if (testletter == words) {
                Log.d("Test", "letter is " + testletter);
                result_letter = true;
                showLetterIndex(i, testletter);
                guessletter++;

            }


        }
        if (result_letter == false) {
            letterfailed(words + "");

        }
        if (guessletter == mword.length()) {
            Intent intent=new Intent(GameMulit.this,MulitPlayer.class);
            startActivity(intent);
            finish();


        }
    }

    public void clearScreen(){
        result.setText("");
        counterFailed=0;
        guessletter=0;
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.Liner);
        for (int i=0;i<linearLayout.getChildCount();i++){
            TextView textView= (TextView) linearLayout.getChildAt(i);
            textView.setText("-");
        }
        ImageView imageView=(ImageView)findViewById(R.id.imageView_multi);
        imageView.setImageResource(R.drawable.hangdroid_0);
    }



    public void showLetterIndex(int index,char letterguessed){
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.Liner);
        TextView textView= (TextView) linearLayout.getChildAt(index);
        textView.setText(letterguessed+"");



    }
    public void letterfailed(String letter) {
        counterFailed += 1;
        ImageView imageView = (ImageView) findViewById(R.id.imageView_multi);
        result=(TextView)findViewById(R.id.ress);
        String phletter = result.getText().toString();
        result.setText(phletter + letter);
        switch (counterFailed) {
            case 1:
                imageView.setImageResource(R.drawable.hangdroid_1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.hangdroid_2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.hangdroid_3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.hangdroid_4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.hangdroid_5);
                break;
            case 6:
                Intent intent = new Intent(GameMulit.this, MulitPlayer.class);
                intent.putExtra("point", point);
                startActivity(intent);
                // clearScreen();
                break;


        }
    }

}
