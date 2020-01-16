package com.example.mfuction.functions.quizs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.mfuction.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Ques2 extends AppCompatActivity {

    Button b2,b3,b1;
    RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques2);
        FloatingActionButton fab = findViewById(R.id.fabq2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ques2.this, Quiz.class);
                startActivity(i);
                finish();
            }
        });

        b2=(Button)findViewById(R.id.button17);
        b3=(Button)findViewById(R.id.button18);
        r1=(RadioButton)findViewById(R.id.radioButton5);
        r2=(RadioButton)findViewById(R.id.radioButton6);
        r3=(RadioButton)findViewById(R.id.radioButton7);
        r4=(RadioButton)findViewById(R.id.radioButton8);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(r3.isChecked())
                {

                    ++Quiz.score;
                }
                else
                {
                    --Quiz.score;
                }
                Intent i=new Intent(Ques2.this,Ques3.class);
                startActivity(i);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Ques2.this,Quiz.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Ques2.this,Quiz.class));
    }
}
