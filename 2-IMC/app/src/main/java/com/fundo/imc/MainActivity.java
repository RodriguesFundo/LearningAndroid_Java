package com.fundo.imc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import  com.fundo.imc.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private boolean isMaleSelected = false;
    private boolean isFemaleSelected = false;
    private String genero;
    private float peso;
    private int idade;
    private float altura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());


        //Buttons
        mainBinding.femaleButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                    Toast.makeText(MainActivity.this, "Feminino", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        mainBinding.maleButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Masculino ", Toast.LENGTH_SHORT).show();
                return true;
            }
        });


        //Clique no masculino, desativa o feminino
        mainBinding.maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isMaleSelected) {
                    isMaleSelected = true;
                    isFemaleSelected = false;
                    mainBinding.maleButton.setImageResource(R.drawable.person_male_selected);
                    mainBinding.femaleButton.setImageResource(R.drawable.person_female);
                }
            }
        });

        //Clique no feminino, desativa o masculino
        mainBinding.femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFemaleSelected) {
                    isFemaleSelected = true;
                    isMaleSelected = false;
                    mainBinding.femaleButton.setImageResource(R.drawable.person_female_selected);
                    mainBinding.maleButton.setImageResource(R.drawable.person_male);
                }
            }
        });


        //SeekBar{
        mainBinding.seekBarPeso.setMax(150);
        mainBinding.seekBarPeso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mainBinding.lblCountPeso.setText(String.valueOf(i));
            }

            //Quando toca e segura o objecto
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            //Quando larga o objecto
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //}

    }


    public int idade(){
        return 1;
    }


}