package com.fundo.aul4_registrarprodutos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.fundo.aul4_registrarprodutos.databinding.ActivityMainBinding;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    private  ActivityMainBinding mainBinding;
//    private static final String TAG= "Static Changed";
    int i=0;
    ArrayList<Product> products= new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());


        mainBinding.btnRegistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                try {
                    //Verifica se ha algum espaco em branco


                    if (mainBinding.inputName.getText().toString().isEmpty()) {
                        mainBinding.inputName.setError("Campo obrigatório");
                        return;
                    }

                    if (mainBinding.inputPrice.getText().toString().isEmpty()) {
                        mainBinding.inputPrice.setError("Campo obrigatório");
                        return;
                    }

                    if (mainBinding.inputQuantity.getText().toString().isEmpty()) {
                        mainBinding.inputQuantity.setError("Campo obrigatório");
                        return;
                    }

                    if (mainBinding.inputDate.getText().toString().isEmpty()) {
                        mainBinding.inputDate.setError("Campo obrigatório");
                        return;
                    }

                    // Se todos os campos obrigatórios estiverem preenchidos, continue com o registro do produto




                        //Adiciona um novo poduto
                        products.add(new Product(
                                mainBinding.inputName.getText().toString(),
                                Double.parseDouble(mainBinding.inputPrice.getText().toString()),
                                Integer.parseInt(mainBinding.inputQuantity.getText().toString()),
                                LocalDate.parse(mainBinding.inputDate.getText().toString(), formatter)
                        ));
                        //Exibe uma mensagem na tela que o produto foi registrado
                        mainBinding.txtResult.setText(mainBinding.inputName.getText().toString()+" registrado!");

                        //Mostra na consola/LogCat os produtos adicionados
                        for (Product product : products
                        ){
                            i++;
                            System.out.println(i+" - "+product.toString());

                        }


                } catch (DateTimeParseException e) {
                   // e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Formato de data invalido", Toast.LENGTH_SHORT).show();
                    // Trate o erro aqui como quiser, como exibir uma mensagem de erro para o usuário
                }
            }
        });


    }


}