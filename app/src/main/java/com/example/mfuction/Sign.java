package com.example.mfuction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Sign extends AppCompatActivity {

    Button b1,b2,b3,b7;
    EditText t1,t2,t3,t4,t5;
    TextView tx1,tx2,tx3,tx4,tx5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        FloatingActionButton fab = findViewById(R.id.fabsign);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Sign.this, First3.class);
                startActivity(i);
                finish();
            }
        });


        b2=(Button)findViewById(R.id.button);

        b3=(Button)findViewById(R.id.button5);

        t1=(EditText)findViewById(R.id.editText);
        t2=(EditText)findViewById(R.id.editText2);
        t3=(EditText)findViewById(R.id.editText3);
        t4=(EditText)findViewById(R.id.editText4);
        t5=(EditText)findViewById(R.id.editText5);

        tx1=(TextView)findViewById(R.id.textView5);
        tx2=(TextView)findViewById(R.id.textView6);
        tx3=(TextView)findViewById(R.id.textView7);
        tx4=(TextView)findViewById(R.id.textView8);
        tx5=(TextView)findViewById(R.id.textView9);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sign.this,Login.class);
                startActivity(i);
                finish();
            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2,s3,s4,s5;

                s1=t1.getText().toString();
                s2=t2.getText().toString();
                s3=t3.getText().toString();
                s4=t4.getText().toString();
                s5=t5.getText().toString();

                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals(""))
                {
                    if(s1.equals(""))
                    {
                        tx1.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        tx1.setVisibility(View.INVISIBLE);
                    }
                    if(s2.equals(""))
                    {
                        tx2.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        tx2.setVisibility(View.INVISIBLE);
                    }
                    if(s3.equals(""))
                    {
                        tx3.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        tx3.setVisibility(View.INVISIBLE);
                    }
                    if(s4.equals(""))
                    {
                        tx4.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        tx4.setVisibility(View.INVISIBLE);
                    }
                    if(s5.equals(""))
                    {
                        tx5.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        tx5.setVisibility(View.INVISIBLE);
                    }
                    Toast.makeText(Sign.this, "Fill up the RED MARKS", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    tx1.setVisibility(View.INVISIBLE);tx2.setVisibility(View.INVISIBLE);
                    tx3.setVisibility(View.INVISIBLE);tx4.setVisibility(View.INVISIBLE);
                    tx5.setVisibility(View.INVISIBLE);

                    SQLiteDatabase data=openOrCreateDatabase("newmember",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists details(name varchar,email varchar,mobile varchar,username varchar,password varchar)");
                    String s8="select * from details where username='"+s4+"'";
                    String s9="select * from details where email='"+s2+"' and mobile='"+s3+"'";

                    Cursor cursor2=data.rawQuery(s9,null);
                    Cursor cursor =data.rawQuery(s8,null);
                    if(cursor2.getCount()>0)
                    {
                        Toast.makeText(Sign.this, "User Exists", Toast.LENGTH_SHORT).show();

                    }
                    else if(cursor.getCount()>0)
                    {
                        Toast.makeText(Sign.this, "Username Exists", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        data.execSQL("insert into details values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
                        Toast.makeText(Sign.this, "Congratulation!!!", Toast.LENGTH_SHORT).show();
                        Intent j=new Intent(Sign.this,First3.class);
                        startActivity(j);
                        finish();
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Sign.this,First3.class));
    }
}
