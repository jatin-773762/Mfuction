package com.example.mfuction;
import android.content.Intent;
import android.os.Bundle;

import com.example.mfuction.functions.Calc;
import com.example.mfuction.functions.Camera;
import com.example.mfuction.functions.Mplayer;
import com.example.mfuction.functions.quizs.Quiz;
import com.example.mfuction.functions.Timer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class First3 extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first3);
        FloatingActionButton fab = findViewById(R.id.signinfab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(First3.this,Sign.class);
                startActivity(i);
                finish();
            }
        });
        t1=(TextView)findViewById(R.id.username);
        t1.setText(Login.user);
        b1=(Button)findViewById(R.id.calc);
        b2=(Button)findViewById(R.id.musix);
        b3=(Button)findViewById(R.id.timer);
        b4=(Button)findViewById(R.id.quiz);
        b5=(Button)findViewById(R.id.camera);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First3.this, Calc.class));
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First3.this, Mplayer.class));
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First3.this, Quiz.class));
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First3.this, Timer.class));
                finish();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First3.this, Camera.class));
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}
