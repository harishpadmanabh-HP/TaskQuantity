package com.hp.hp.task_quantity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 final TextView quant=findViewById(R.id.quant);
        final TextView fare=findViewById(R.id.textView6);


        findViewById(R.id.plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String snum=quant.getText().toString();
                int num=Integer.parseInt(snum);
                //Toast.makeText(MainActivity.this, ""+num, Toast.LENGTH_SHORT).show();
                quant.setText(Integer.toString(num+1));
            }
        });

        findViewById(R.id.minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String snum=quant.getText().toString();
                int num=Integer.parseInt(snum);
                //Toast.makeText(MainActivity.this, ""+num, Toast.LENGTH_SHORT).show();
                quant.setText(Integer.toString(num-1));
            }
        });
        findViewById(R.id.bootomlayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String snum=quant.getText().toString();
                String sfare=fare.getText().toString();

                int num=Integer.parseInt(snum);
                //Toast.makeText(MainActivity.this, ""+num, Toast.LENGTH_SHORT).show();
                //quant.setText(Integer.toString(num-1));
                SharedPreferences shared = getApplicationContext().getSharedPreferences("Pref",MODE_PRIVATE);
                SharedPreferences.Editor editor=shared.edit();
                editor.putString("quantity",snum);
                editor.putString("fare",sfare);
                editor.apply();
                startActivity(new Intent(MainActivity.this,DisplayBill.class));
            }
        });

    }


    }



