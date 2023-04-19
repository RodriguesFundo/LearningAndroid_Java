package com.fundo.aul4_registrarprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.fundo.aul4_registrarprodutos.databinding.ActivityProducResultBinding;

import java.util.ArrayList;


public class ProducResult extends AppCompatActivity {
    private ActivityProducResultBinding activityProducResultBinding;
    private static final String TAG = "ProducResult";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProducResultBinding = ActivityProducResultBinding.inflate(getLayoutInflater());
        setContentView(activityProducResultBinding.getRoot());

        try {
            // Obter a intenção (Intent) que iniciou esta atividade
            Intent intent = getIntent();
            ArrayList<Product> products = intent.getParcelableArrayListExtra("listaProduct");

            ProductAdapter productAdapter = new ProductAdapter(this, products);
            activityProducResultBinding.listViewProduct.setAdapter(productAdapter);

        } catch (Exception e) {
            Log.e(TAG, "Erro ao obter a lista de produtos: ", e);
        }

    }

}

