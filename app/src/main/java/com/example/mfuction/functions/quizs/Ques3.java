package com.example.mfuction.functions.quizs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.mfuction.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Ques3 extends AppCompatActivity {
    Button b2,b3,b1;
    RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques3);
        FloatingActionButton fab = findViewById(R.id.fabq3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ques3.this, Ques2.class);
                startActivity(i);
                finish();
            }
        });


        b2=(Button)findViewById(R.id.button19);
        b3=(Button)findViewById(R.id.button20);
        r1=(RadioButton)findViewById(R.id.radioButton9);
        r2=(RadioButton)findViewById(R.id.radioButton10);
        r3=(RadioButton)findViewById(R.id.radioButton11);
        r4=(RadioButton)findViewById(R.id.radioButton12);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(r4.isChecked())
                {

                    ++Quiz.score;
                }
                else
                {
                    --Quiz.score;
                }
                Intent i=new Intent(Ques3.this,Result.class);
                startActivity(i);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Ques3.this,Ques2.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Ques3.this,Ques2.class));
    }
}
