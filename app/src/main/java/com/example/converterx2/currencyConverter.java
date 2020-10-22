package com.example.converterx2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class currencyConverter extends AppCompatActivity {
    EditText amt;
    Spinner s1,s2;
    Button convert,clear;
    TextView out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        amt = findViewById(R.id.ip);
        s1 = findViewById(R.id.sp1);
        s2 = findViewById(R.id.sp2);
        convert = findViewById(R.id.con);
        clear = findViewById(R.id.clr);
        out = findViewById(R.id.op);

        String[] from = {"USD","INR"};
        ArrayAdapter ad = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,from);
        s1.setAdapter(ad);

        String[] to = {"USD","INR"};
        ArrayAdapter ad1 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,to);
        s2
                .setAdapter(ad1);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double tot;
                Double amount = Double.parseDouble(amt.getText().toString());

                if(s1.getSelectedItem().toString() == "USD" && s2.getSelectedItem().toString() == "INR")
                {
                    tot = amount*73.38;
                    String inr = String.valueOf(Math.round(tot));
                    out.setText(inr+"₹");
                }

                else if(s1.getSelectedItem().toString() == "INR" && s2.getSelectedItem().toString() == "USD")
                {
                    tot = amount/73.38;
                    String inr = String.valueOf(Math.round(tot));
                    out.setText(inr+"$");
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amt.setText("");
                out.setText("");
            }
        });

    }
}