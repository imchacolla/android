package com.example.android.lab06;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PrimerActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLlamarActivity;
    private Button btnLlamarExplorador;
    private Button btnLlamarGeo;
    private Button btnLlamarCelular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer);

        btnLlamarActivity = (Button) findViewById(R.id.btnLLamarActivity);
        btnLlamarExplorador = (Button) findViewById(R.id.btnLLamarExplorador);
        btnLlamarGeo = (Button) findViewById(R.id.btnLlamarGeo);
        btnLlamarCelular = (Button) findViewById(R.id.btnLlamarCelular);

        btnLlamarActivity.setOnClickListener(this);
        btnLlamarExplorador.setOnClickListener(this);
        btnLlamarGeo.setOnClickListener(this);
        btnLlamarCelular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnLLamarActivity:
                intent = new Intent(this, SegundoActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, "Mi nombre es Ivan");
                this.startActivity(intent);
                break;
            case R.id.btnLLamarExplorador:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.miteleferico.bo"));
                this.startActivity(intent);
                break;
            case R.id.btnLlamarGeo:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:54.646,-19.25"));
                this.startActivity(intent);
                break;
            case R.id.btnLlamarCelular:
                intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:70617136"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast toast = Toast.makeText(this,"nom cuenta con permisos",Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                this.startActivity(intent);
                break;

        }
    }
}
