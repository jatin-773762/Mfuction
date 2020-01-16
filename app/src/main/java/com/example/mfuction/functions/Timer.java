package com.example.mfuction.functions;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mfuction.First3;
import com.example.mfuction.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;
public class Timer extends AppCompatActivity {
    Button b1,b2,b3;
    EditText e1;
    TextView t1;
    TextToSpeech ts1;
    CountDownTimer ct1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        FloatingActionButton fab = findViewById(R.id.fabtimer);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Timer.this, First3.class);
                startActivity(i);
                finish();
            }
        });
        b1=(Button)findViewById(R.id.timerstart);
        b2=(Button)findViewById(R.id.timerstop);
        e1=(EditText)findViewById(R.id.inputtxt);
        t1=(TextView)findViewById(R.id.countertxt);
        ts1=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                ts1.setLanguage(Locale.ENGLISH);
                ts1.setSpeechRate(0.9f);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long x=Integer.parseInt(e1.getText().toString());
                ct1=new CountDownTimer(x,1000) {
                    int count;
                    @Override
                    public void onTick(long millisUntilFinished) {
                        t1.setText(String.format(Locale.getDefault(), "%02d:%02d",(millisUntilFinished/1000)/60,(millisUntilFinished/1000)%60));}
                    @Override
                    public void onFinish() {
                        ts1.speak("Timer is Completed",TextToSpeech.QUEUE_FLUSH,null);
                    }
                }.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Timer.this,First3.class);
                startActivity(i);
                finish();
            }
        });
    }
}
