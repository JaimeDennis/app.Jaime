package com.example.appholamundo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SpinnerActivity extends ComponentActivity {

    private Spinner sp;
    private Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);


        btnCerrar = (android.widget.Button) findViewById(R.id.btnCerrar);

        ArrayList<SpinnerData> lst = new ArrayList<>();
        lst.add(new SpinnerData(getString(R.string.itemFrappses), getString(R.string.msgFrappses), R.mipmap.categoria));
        lst.add(new SpinnerData(getString(R.string.itemAgradecimiento), getString(R.string.msgAgradecimiento), R.mipmap.agradecimiento));
        lst.add(new SpinnerData(getString(R.string.itemAmor), getString(R.string.msgAmor), R.mipmap.corazon));
        lst.add(new SpinnerData(getString(R.string.itemNewYear), getString(R.string.msgNewYear), R.mipmap.nuevo));
        lst.add(new SpinnerData(getString(R.string.itemCanciones), getString(R.string.msgCanciones), R.mipmap.canciones));

        sp = findViewById(R.id.spinner1);
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.activity_spinner_layout, lst);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),
                        getString(R.string.msgSeleccionado).toString() + " " +
                                ((SpinnerData) parent.getItemAtPosition(position)).getTextCategoria(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
