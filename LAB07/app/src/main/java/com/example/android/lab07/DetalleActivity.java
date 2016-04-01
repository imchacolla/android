package com.example.android.lab07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.lab07.obj.Constantes;
import com.example.android.lab07.obj.Contacto;

public class DetalleActivity extends AppCompatActivity {
private TextView txvNombre;
    private  TextView txvCelular;
    private TextView txvWeb;

    Contacto contactoSeleccionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        txvNombre= (TextView) findViewById(R.id.txvNombre);
        txvCelular= (TextView) findViewById(R.id.txvTelefono);
        txvWeb= (TextView) findViewById(R.id.txvWeb);
        Bundle data = getIntent().getExtras();
        if(data==null)
            return;
        contactoSeleccionado = (Contacto) getIntent().getSerializableExtra(Constantes.CONTACTO_OBJ);

        txvNombre.setText(contactoSeleccionado.getNombre());
        txvCelular.setText(contactoSeleccionado.getTelefono());
        txvWeb.setText(contactoSeleccionado.getWeb());

    }
}
