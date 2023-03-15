package com.fundo.licensedrive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.fundo.licensedrive.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    final int now= 2023;

    private ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = mainBinding.inputName.getText().toString();
                Integer year = Integer.parseInt(mainBinding.inputYear.getText().toString());
                int age = now - year;
                if (!(name.isEmpty() && year.toString().isEmpty())){
                    if (age>=18){
                        mainBinding.txtResult.setText(name+", you can now create a Driving License!");
                    }
                    else {
                        mainBinding.txtResult.setText(name+", you are underage");
                    }
                }

            }
        });

    }
}