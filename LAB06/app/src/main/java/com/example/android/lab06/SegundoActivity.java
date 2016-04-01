package com.example.android.lab06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {
private TextView txvTitulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        Bundle data = getIntent().getExtras();
        String texto=data.getString(Intent.EXTRA_TEXT);

        txvTitulo= (TextView) findViewById(R.id.txvTextoSegActivity);
        txvTitulo.setText(texto);

    }
}
