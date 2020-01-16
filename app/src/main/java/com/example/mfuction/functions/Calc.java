package com.example.mfuction.functions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mfuction.First3;
import com.example.mfuction.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Calc extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bp,bs,bm,bd,bclr,bper,bdel,bdecimal;
    TextView tr,ti;
    FloatingActionButton be;
    static int n=0;
    static double a=Double.NaN,b;
    static char op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        FloatingActionButton back = findViewById(R.id.back_fab_calc);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Calc.this, First3.class);
                startActivity(i);
                finish();
            }
        });
        b1=(Button)findViewById(R.id.btn1);
        b2=(Button)findViewById(R.id.btn2);
        b3=(Button)findViewById(R.id.btn3);
        b4=(Button)findViewById(R.id.btn4);
        b5=(Button)findViewById(R.id.btn5);
        b6=(Button)findViewById(R.id.btn6);
        b7=(Button)findViewById(R.id.btn7);
        b8=(Button)findViewById(R.id.btn8);
        b9=(Button)findViewById(R.id.btn9);
        b0=(Button)findViewById(R.id.btn0);
        bs=(Button)findViewById(R.id.btnsub);
        bd=(Button)findViewById(R.id.btndiv);
        bp=(Button)findViewById(R.id.btnplus);
        bm=(Button)findViewById(R.id.btnmulti);
        bclr=(Button)findViewById(R.id.btnclr);
        be=(FloatingActionButton)findViewById(R.id.btnequal);
        bper=(Button)findViewById(R.id.btnperc);
        bdecimal=(Button)findViewById(R.id.btndec);
        bdel=(Button)findViewById(R.id.btndel);
        tr=(TextView)findViewById(R.id.txtresult);
        ti=(TextView)findViewById(R.id.txtin);
        bdecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op=='=')
                { a=Double.NaN;
                  b=Double.NaN; }
                ti.setText(ti.getText()+".");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op=='=')
                { a=Double.NaN;
                    b=Double.NaN;}
                ti.setText(ti.getText()+"0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op=='=')
                { a=Double.NaN;
                    b=Double.NaN; }
                ti.setText(ti.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op=='=')
                { a=Double.NaN;
                    b=Double.NaN; }
                ti.setText(ti.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op=='=')
                { a=Double.NaN;
                    b=Double.NaN; }
                ti.setText(ti.getText()+"3"); }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op=='=')
                { a=Double.NaN;
                    b=Double.NaN; }
                ti.setText(ti.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op=='=')
                { a=Double.NaN;
                    b=Double.NaN; }
                ti.setText(ti.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op=='=')
                { a=Double.NaN;
                    b=Double.NaN; }
                ti.setText(ti.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op=='=')
                { a=Double.NaN;
                    b=Double.NaN; }
                ti.setText(ti.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op=='=')
                { a=Double.NaN;
                    b=Double.NaN; }
                ti.setText(ti.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op=='=')
                { a=Double.NaN;
                    b=Double.NaN; }
                ti.setText(ti.getText()+"9");
            }
        });
        bclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tr.setText(null);
                ti.setText(null);
                a=Double.NaN;
                b=Double.NaN;
                Toast.makeText(Calc.this, "All Clear", Toast.LENGTH_SHORT).show();
            }
        });
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{String s=ti.getText().toString();
                    if(s!=null)
                        s=s.substring(0,s.length()-1);
                    else
                        Toast.makeText(Calc.this, "Empty", Toast.LENGTH_SHORT).show();
                    ti.setText(s);}
                catch(Exception e) {
                    Toast.makeText(Calc.this, "Empty", Toast.LENGTH_SHORT).show();}
            }
        });
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    operation();
                    op='+';
                    tr.setText(String.valueOf(a)+"+");
                    ti.setText(null);}
                catch(Exception e)
                {
                    op = '+';
                    tr.setText(String.valueOf(a) + "+");
                }
            }
        });
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {    operation();

                    op = '-';
                    tr.setText(String.valueOf(a) + "-");
                    ti.setText(null);
                }
                catch (Exception e)
                {
                    op = '-';
                    tr.setText(String.valueOf(a) + "-");
                    //System.out.println(ti.getText().toString());
                }
            }
        });
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    operation();
                    op = '*';
                    tr.setText(String.valueOf(a) + "*");
                    ti.setText(null);
                }
                catch(Exception e)
                { op = '*';
                    tr.setText(String.valueOf(a) + "*"); }
            }
        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    operation();
                    op='/';
                    tr.setText(String.valueOf(a)+"/");
                    ti.setText(null);}
                catch(Exception e)
                { op = '/';
                  tr.setText(String.valueOf(a) + "/"); }
            }
        });
        bper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{operation();
                    op='%';
                    tr.setText(String.valueOf(a)+"%");
                    ti.setText(null);}
                catch(Exception e)
                { op = '%';
                    tr.setText(String.valueOf(a)+"%"); }
            }
        });
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    operation();
                    op='=';
                    tr.setText(String.valueOf(a));
                    ti.setText(null);}
                catch(Exception e)
                {   op = '=';
                    tr.setText(String.valueOf(a)); }
            }
        });
    }
    public void operation()
    {
        if(!Double.isNaN(a))
        {
            if(op!='%') {
                b = Double.parseDouble(ti.getText().toString());
                switch (op) {
                    case '+':
                        a = a + b;
                        break;
                    case '-':
                        a = a - b;
                        break;
                    case '*':
                        a = a * b;
                        break;
                    case '/':
                        a = a / b;
                    case '=':
                        break;
                }
            }
            else if(op=='%')
            { a=a/100; }
        }
        else
            a=Double.parseDouble(ti.getText().toString());
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Calc.this,First3.class));
    }
}
