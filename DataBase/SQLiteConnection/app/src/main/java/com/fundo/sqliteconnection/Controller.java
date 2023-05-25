package com.fundo.sqliteconnection;

import android.content.Context;
import android.widget.Toast;

public class Controller {

    private static final String DB_NAME= "ALUNOS.DB";
    private static final int DB_VERSION= 1;
    private Context context;
    private DBHelper db;

    public Controller(Context context) {
        // Instancia um DBHelper para manipular o banco de dados
        db = new DBHelper(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    public void saveDB(String name, String course){
        try {
            // Chama o método save do DBHelper para salvar os dados no banco de dados
            if (db.save(name, course) != -1) {
                // Exibe uma mensagem de sucesso utilizando um Toast
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
            } else {
                // Exibe uma mensagem de erro utilizando um Toast
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Exibe uma mensagem de erro genérica utilizando um Toast
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
        }
    }

}
