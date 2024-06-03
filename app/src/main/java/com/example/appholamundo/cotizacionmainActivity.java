package com.example.appholamundo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cotizacionmainActivity extends AppCompatActivity {

    private EditText txtPregunta;
    private Button btnCotizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cotizacionmain);
        iniciarcomponentes();

        btnCotizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto del EditText
                String pregunta = txtPregunta.getText().toString();

                // Crear un Intent para iniciar la actividad de cotización
                Intent intent = new Intent(cotizacionmainActivity.this, cotizacionActivity.class);

                // Agregar el texto como un extra al Intent
                intent.putExtra("PREGUNTA", pregunta);

                // Iniciar la actividad de cotización
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void iniciarcomponentes(){
        txtPregunta = (EditText) findViewById(R.id.editTextNombreCliente);
        btnCotizacion = (Button) findViewById(R.id.btnIrCotizacion);
    }
}