 package com.example.mfuction.functions.quizs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.mfuction.First3;
import com.example.mfuction.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

 public class Quiz extends AppCompatActivity {
     Button b1,b2;
     RadioButton r1,r2,r3,r4;
     static int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        FloatingActionButton fab = findViewById(R.id.fabquiz);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Quiz.this, First3.class);
                startActivity(i);
                finish();
            }
        });

        b1=(Button)findViewById(R.id.button15);
        b2=(Button)findViewById(R.id.button16);
        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score=0;
                if(r1.isChecked())
                {

                    ++score;
                }
                else
                {
                    --score;
                }
                Intent i=new Intent(Quiz.this,Ques2.class);
               startActivity(i);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Quiz.this,First3.class);
                startActivity(i);
                finish();
            }
        });

    }
     @Override
     public void onBackPressed() {
         super.onBackPressed();
         startActivity(new Intent(Quiz.this,First3.class));
     }
}
