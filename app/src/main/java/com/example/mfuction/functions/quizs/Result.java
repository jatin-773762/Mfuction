package com.example.mfuction.functions.quizs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mfuction.First3;
import com.example.mfuction.R;

public class Result extends AppCompatActivity {

    TextView t1,t2;
    Button b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        b4=(Button)findViewById(R.id.home);
        t1=(TextView)findViewById(R.id.score);
        t2=(TextView)findViewById(R.id.greet);
        t1.setText(""+ Quiz.score);
        if(Quiz.score==3)
            t2.setText("Congratulation You Scored Max:");
        else if(Quiz.score<0)
            t2.setText("Better Luck Next Time");
        else
            t2.setText("Thank You!!!");



        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Result.this, First3.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Result.this,First3.class));
    }
}
