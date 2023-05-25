package com.fundo.sqliteconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//Class to manager DB
public class DBHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME="Alunos";
    private static final String _ID="id";
    private static final String NAME ="Nome";
    private static final String COURSE="Curso";

    // Definição da query SQL para criar a tabela
    private static final String CREATE_TABLE_SQL= "CREATE TABLE " + TABLE_NAME+ " ("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" TEXT NOT NULL, "+COURSE+" TEXT);";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Executa a query SQL para criar a tabela
        sqLiteDatabase.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Executa a query SQL para remover a tabela existente (caso exista)
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Chama o método onCreate para criar a nova versão da tabela
        onCreate(sqLiteDatabase);
    }

    // Salva os dados no banco de dados
    public long save(String name, String course){
        SQLiteDatabase sqLiteDatabase = null;
        try {
            sqLiteDatabase = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            // Insere os valores a serem salvos nas colunas correspondentes
            values.put(NAME, name);
            values.put(COURSE, course);

            // Insere os dados na tabela e retorna o ID do registro inserido
            long insert = sqLiteDatabase.insert(TABLE_NAME, null, values);
            return insert;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            if (sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }
        }

    }
}
