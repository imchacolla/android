package com.example.android.lab04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private EditText etxTexto;
    private Button btnAgregar;
    private ListView ltvLista;
    private ArrayList<String> lista;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //asociamos las variales a los views
        etxTexto = (EditText) findViewById(R.id.etxTexto);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        ltvLista = (ListView) findViewById(R.id.ltvLista);
        //inicializar componentes
        lista = new ArrayList<>();
        adapter = new ArrayAdapter<String>(ListViewActivity.this, android.R.layout.simple_list_item_1, lista);
        ltvLista.setAdapter(adapter);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = etxTexto.getText().toString();
                if (texto.length() > 0) {
                    lista.add(texto);
                    adapter.notifyDataSetChanged();
                    etxTexto.setText("");
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Ingrese al menos un caracter", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        ltvLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                lista.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });


    }


}
