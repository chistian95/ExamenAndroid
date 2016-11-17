package com.example.dam32_corral.examenchristian;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ConsultaLibro extends AppCompatActivity {
    EditText etPaginas;
    ListView lvLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_libro);

        etPaginas = (EditText) findViewById(R.id.etPaginas);
        lvLibros = (ListView) findViewById(R.id.lvLibros);
    }

    public void consultar(View view) {
        int numPaginas = 0;
        if(etPaginas.getText().toString().length() > 0) {
            numPaginas = Integer.parseInt(etPaginas.getText().toString());
        }

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "biblioteca", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        List<String> libros = new ArrayList<>();
        Cursor fila = db.rawQuery("SELECT titulo FROM libros WHERE paginas > "+numPaginas, null);
        if(fila.getCount() <= 0 || fila.getColumnCount() <= 0) {
            Toast.makeText(this, "No se han encontrado libros que superen ese numero de paginas", Toast.LENGTH_SHORT).show();
        } else {
            while(fila.moveToNext()) {
                libros.add(fila.getString(0));
            }
        }

        db.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, libros);
        lvLibros.setAdapter(adapter);
    }

    public void volver(View view) {
        finish();
    }
}
