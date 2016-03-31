package com.example.android.lab05;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SumaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SumaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SumaFragment extends Fragment {

    EditText etxNumero1;
    EditText etxNumero2;
    Button btnCalcular;
    TextView txvResultadoSuma;

    public SumaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        etxNumero1 =(EditText) container.findViewById(R.id.etxNumero1);
        etxNumero2 =(EditText) container.findViewById(R.id.etxNumero2);
        btnCalcular = (Button) container.findViewById(R.id.btnSumar);
        txvResultadoSuma= (TextView) container.findViewById(R.id.txvResultadoSuma);
/*
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(etxNumero1.getText().toString());
                int num2 = Integer.parseInt(etxNumero2.getText().toString());
                txvResultadoSuma.setText("La resta es: "+(num1-num2));
            }
        });
*/
        return inflater.inflate(R.layout.fragment_suma, container, false);
    }

}
