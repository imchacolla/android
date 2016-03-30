package com.example.android.lab03;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Camera camera;
    private boolean isEncendido;
    private boolean isFlashCamera;
    private Camera.Parameters param;
    private ToggleButton tbtFlashCamara;
    private final String TAG="LAB03";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isFlashCamera= getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if(!isFlashCamera){
            AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setTitle("Error");
            alert.setMessage("Comprate otro celular");
            alert.setButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }
        getCamera();
        tbtFlashCamara= (ToggleButton) findViewById(R.id.tgbApagar);
        tbtFlashCamara.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    encenderLuz();
                }
                else {
                    apagarLuz();
                }
            }
        });
    }

    private void getCamera(){
        if(camera==null){
            try {
                camera = Camera.open();
                param = camera.getParameters();
            } catch (Exception ex){
                Log.e(TAG,ex.getMessage());
            }
        }
    }
    private void encenderLuz(){
        if(!isEncendido){
            if(camera==null||param ==null)
                return;
                param = camera.getParameters();
                param.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(param);
                camera.startPreview();
                isEncendido=true;
        }

    }
    private void apagarLuz(){
        if(isEncendido){
            if(camera==null||param ==null)
                return;
            param = camera.getParameters();
            param.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(param);
            camera.startPreview();
            isEncendido=false;
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        apagarLuz();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getCamera();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(camera!=null){
            camera.release();
            camera=null;
        }
    }
}
