package com.hp.hp.task_quantity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Dialog d;
    NumberPicker numberPicker;
    TextView quant;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  quant=findViewById(R.id.quant);
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
       quant.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               show();
           }
       });

    }

    public void show()
    {
        final Dialog d = new Dialog(MainActivity.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.numpick);
        Button b1 = (Button) d.findViewById(R.id.button);
        Button b2 = (Button) d.findViewById(R.id.button2);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.num);
        np.setMaxValue(100); // max value 100
        np.setMinValue(0);   // min value 0
        np.setWrapSelectorWheel(false);
        //np.setOnValueChangedListener();

//      np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//          @Override
//          public void onValueChange(NumberPicker numberPicker, int i, int i1) {
//              Toast.makeText(MainActivity.this, ""+ Integer.toString(i1), Toast.LENGTH_SHORT).show();
//
//          }
//      });
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                quant.setText(String.valueOf(np.getValue())); //set the value to textview
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss(); // dismiss the dialog
            }
        });


        d.show();


    }


    }



