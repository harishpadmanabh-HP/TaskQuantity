package com.hp.hp.task_quantity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayBill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_bill);
        EditText quantity=findViewById(R.id.editTextquantity);
        EditText amount=findViewById(R.id.editText3totalrs);

        SharedPreferences shared = getApplicationContext().getSharedPreferences("Pref",MODE_PRIVATE);
        String squantity=shared.getString("quantity",null);
        String sfare=shared.getString("fare",null);
        quantity.setText(squantity);
        int numofitem=Integer.parseInt(squantity);
        int totalamount=Integer.parseInt(sfare);
        int totalrs=numofitem*totalamount;
        amount.setText(Integer.toString(totalrs));

    }
}
