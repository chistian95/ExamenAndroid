package com.example.dam32_corral.examenchristian;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AltaLibro extends AppCompatActivity {
    EditText etCodigo, etTitulo, etPaginas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_libro);

        etCodigo = (EditText) findViewById(R.id.etCodigo);
        etTitulo = (EditText) findViewById(R.id.etTitulo);
        etPaginas = (EditText) findViewById(R.id.etPaginas);
    }

    public void darAlta(View view) {
        if(etCodigo.getText().toString().length() <= 0) {
            Toast.makeText(this, "Debes introducir un codigo!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(etTitulo.getText().toString().length() <= 0) {
            Toast.makeText(this, "Debes introducir un titulo!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(etPaginas.getText().toString().length() <= 0) {
            Toast.makeText(this, "Debes introducir las paginas!", Toast.LENGTH_SHORT).show();
            return;
        }

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "biblioteca", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("cod_libro", etCodigo.getText().toString());
        values.put("titulo", etTitulo.getText().toString());
        values.put("paginas", etPaginas.getText().toString());
        db.insert("libros", null, values);

        db.close();

        etCodigo.setText("");
        etTitulo.setText("");
        etPaginas.setText("");
        Toast.makeText(this, "Libro creado!", Toast.LENGTH_SHORT).show();
    }

    public void volver(View view) {
        finish();
    }
}
