package com.example.mfuction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Login extends AppCompatActivity {

    Button b8, b9;
    EditText e1,e2;
    static String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FloatingActionButton fab = findViewById(R.id.fablog);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Sign.class);
                startActivity(i);
                finish();
            }
        });

        b8 = (Button) findViewById(R.id.button2);

        e1 = (EditText) findViewById(R.id.editText6);
        e2 = (EditText) findViewById(R.id.editText7);

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();


                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(Login.this,"Fill All",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    try{
                        SQLiteDatabase data=openOrCreateDatabase("newmember",MODE_PRIVATE,null);
                    //data.execSQL("create table if not exists student(name varchar,password varchar,email varchar)");
                    String s4="select * from details where username='"+s1+"' and password='"+s2+"'";
                    Cursor cursor3 =data.rawQuery(s4,null);
                    if(cursor3.getCount()>0)
                    {
                        user=s1;

                        // String s5="update details set confirm='"+"1"+"' where username='"+s1+"'";
                        Intent j = new Intent(Login.this, First3.class);
//                        j.putExtra("name",;
                        startActivity(j);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(Login.this, "Invalid", Toast.LENGTH_SHORT).show();
                    }}
                    catch(Exception e)
                    {
                        Toast.makeText(Login.this, "Invalid", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Login.this,First3.class));
    }
}
