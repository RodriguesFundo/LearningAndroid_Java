package com.fundo.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText usd;
    private EditText eur;
    private EditText pound;
    private EditText rand;
    private EditText mzn;
    private Button btnConverter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usd = findViewById(R.id.inputUSD);
        eur = findViewById(R.id.inputEURO);
        pound = findViewById(R.id.inputPOUND);
        rand = findViewById(R.id.inputRAND);
        mzn = findViewById(R.id.inputMZN);
        btnConverter = findViewById(R.id.btnConverter);

        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    DecimalFormat df = new DecimalFormat("0.00");


                    //Dolar
                    if (!usd.getText().toString().isEmpty() && eur.getText().toString().isEmpty() && pound.getText().toString().isEmpty() && rand.getText().toString().isEmpty() && mzn.getText().toString().isEmpty()){
                        double value = Integer.parseInt(usd.getText().toString());
                        eur.setText(df.format(value*0.93297) +" EUR");
                        pound.setText(df.format(value*0.82221)+" POUND");
                        rand.setText(df.format(value*18.1711)+" RAND");
                        mzn.setText(df.format(value* 63.2)+" MZN");

                    } //Euro
                    else if (!eur.getText().toString().isEmpty() && usd.getText().toString().isEmpty() && pound.getText().toString().isEmpty() && rand.getText().toString().isEmpty() && mzn.getText().toString().isEmpty()) {
                        double value = Integer.parseInt(eur.getText().toString());
                        usd.setText(df.format(value*1.07168)+"USD");
                        pound.setText(df.format(value*0.88121)+" POUND");
                        rand.setText(df.format(value*19.4758)+" RAND");
                        mzn.setText(df.format(value*67.7301)+" MZN");
                    } //Pound
                    else if(!pound.getText().toString().isEmpty() && usd.getText().toString().isEmpty() && eur.getText().toString().isEmpty() && rand.getText().toString().isEmpty() && mzn.getText().toString().isEmpty()){
                        double value = Integer.parseInt(pound.getText().toString());
                        usd.setText(df.format(value*1.216)+"USD");
                        eur.setText(df.format(value*1.13456)+" EUR");
                        rand.setText(df.format(value*22.096)+" RAND");
                        mzn.setText(df.format(value*76.851)+" MZN");
                    } // Rand
                    else if(!rand.getText().toString().isEmpty() && usd.getText().toString().isEmpty() && eur.getText().toString().isEmpty() && pound.getText().toString().isEmpty() && mzn.getText().toString().isEmpty()){
                        double value = Integer.parseInt(rand.getText().toString());
                        usd.setText(df.format(value*0.05497)+"USD");
                        eur.setText(df.format(value*0.05129)+" EUR");
                        pound.setText(df.format(value*0.0452)+" POUND");
                        mzn.setText(df.format(value*3.47404)+" MZN");
                    } //Metical
                    else if(!mzn.getText().toString().isEmpty() && usd.getText().toString().isEmpty() && eur.getText().toString().isEmpty() && rand.getText().toString().isEmpty() && pound.getText().toString().isEmpty()){
                        double value = Integer.parseInt(mzn.getText().toString());
                        usd.setText(df.format(value*0.01551)+"USD");
                        eur.setText(df.format(value*0.01447)+" EUR");
                        rand.setText(df.format(value*0.2819)+" RAND");
                        pound.setText(df.format(value*0.01276)+" POUND");
                    }
                     else{
                        Toast.makeText(MainActivity.this, "Insira o valor que deseja converter", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e){
                    Log.println(Log.ERROR, "Erro", e.toString());
                }
            }
        });
    }
}