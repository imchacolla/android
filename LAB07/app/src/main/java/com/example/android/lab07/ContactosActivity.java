package com.example.android.lab07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.lab07.obj.Constantes;
import com.example.android.lab07.obj.Contacto;

import java.util.ArrayList;

public class ContactosActivity extends AppCompatActivity {

    private ListView lsvContactos;
    ArrayList<Contacto> lstContactos;


    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        lsvContactos= (ListView) findViewById(R.id.lstContactos);

        lstContactos = new ArrayList<>();
        lstContactos.add(new Contacto("Ivan Chacolla","75241486","www.miteleferico.bo"));
        lstContactos.add(new Contacto("Javier Loza","706","www.miteleferico.bo"));
        lstContactos.add(new Contacto("Freddy Velasco","75241486","www.miteleferico.bo"));
        lstContactos.add(new Contacto("Carlos Ramirez", "75241486", "www.miteleferico.bo"));



        ArrayList<String> lstContactosString = new ArrayList<>();
        for(Contacto item : lstContactos){
            lstContactosString.add(item.getNombre());
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lstContactosString);
        lsvContactos.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        lsvContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent = null;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                intent = new Intent(getApplicationContext(), DetalleActivity.class);
                intent.putExtra(Constantes.CONTACTO_OBJ,lstContactos.get(position) );
                ContactosActivity.this.startActivity(intent);
            }
        });

    }
}
