package com.example.appholamundo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class menuActivity extends AppCompatActivity {
    private CardView crvPrimer, crvIMC, crvCambio, crvConversion, crvCotizacion, crvSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        iniciarcomponentes();

        crvPrimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent= new Intent(menuActivity.this,MainActivity.class);
                    startActivity(intent);
            }
        });

        crvIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(menuActivity.this,IMCActivity.class);
                startActivity(intent);
            }
        });

        crvCambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(menuActivity.this,conversionMonedasActivity.class);
                startActivity(intent);
            }
        });

        crvConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(menuActivity.this,conversionGradosActivity.class);
                startActivity(intent);
            }
        });

        crvCotizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(menuActivity.this,cotizacionmainActivity.class);
                startActivity(intent);
            }
        });

        crvSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(menuActivity.this,SpinnerActivity.class);
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
        crvPrimer=(CardView) findViewById(R.id.Hola);
        crvIMC=(CardView) findViewById(R.id.imc);
        crvCotizacion=(CardView) findViewById(R.id.Cotizacion);
        crvCambio=(CardView) findViewById(R.id.Moneda);
        crvConversion=(CardView) findViewById(R.id.Conversion);
        crvSpinner = (CardView) findViewById(R.id.Spinner);
    }
}