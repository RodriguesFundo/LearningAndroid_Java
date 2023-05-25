package com.fundo.sqliteconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.fundo.sqliteconnection.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private Context context; // Variável para armazenar o contexto da atividade

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        context = this; // Atribua o contexto atual à variável 'context'

        Controller controller = new Controller(context); // Cria uma instância do Controller passando o contexto

        mainBinding.btnSubmit.setOnClickListener(v->{

            String name = mainBinding.inputName.getText().toString();
            String course = mainBinding.inputCurso.getText().toString();

            if (name.trim().isEmpty() || course.trim().isEmpty()) {
                Toast.makeText(this, "Por favor, preencha ambos os campos de nome e curso", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    controller.saveDB(name, course);
                    Toast.makeText(this, "Dados salvos com sucesso", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Erro ao salvar os dados: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
